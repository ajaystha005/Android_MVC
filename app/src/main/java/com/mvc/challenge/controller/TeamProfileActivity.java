package com.mvc.challenge.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.mvc.challenge.R;
import com.mvc.challenge.manager.TeamProfileManager;
import com.mvc.challenge.pojos.Profile;
import com.mvc.challenge.view.TeamProfileView;
import com.mvc.challenge.view.TeamProfileViewImpl;

import java.util.ArrayList;

/**
 * Created by ajayshrestha on 1/17/17.
 */

/**
 * This controller manage all the team
 */
public class TeamProfileActivity extends AppCompatActivity implements TeamProfileView.ProfileClickListener,
        TeamProfileManager.TeamProfileManagerListener {

    private TeamProfileViewImpl mTeamProfileView;
    private TeamProfileManager mProfileManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTeamProfileView = new TeamProfileViewImpl(LayoutInflater.from(TeamProfileActivity.this), null);
        mTeamProfileView.setListener(this);

        setContentView(mTeamProfileView.getRootView());

        mProfileManager = TeamProfileManager.getInstance(TeamProfileActivity.this);
        mProfileManager.registerListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mProfileManager.loadTeamProfile();
    }

    /**
     * its get fired when we click on team profile
     *
     * @param profile
     * @param transitionView
     */
    @Override
    public void onProfileClick(Profile profile, View transitionView) {

        Intent profileDetailsIntent = new Intent(TeamProfileActivity.this, TeamDetailsActivity.class);
        profileDetailsIntent.putExtra(getString(R.string.profile), profile);

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, transitionView, getString(R.string.profile));
        startActivity(profileDetailsIntent, options.toBundle());
    }

    @Override
    public void onProfileFetched(ArrayList<Profile> teamProfileList) {
        mTeamProfileView.bindTeamProfileList(teamProfileList);
    }
}
