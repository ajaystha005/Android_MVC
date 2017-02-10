package com.mvc.challenge.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;

import com.mvc.challenge.R;
import com.mvc.challenge.pojos.Profile;
import com.mvc.challenge.view.TeamDetailsView;
import com.mvc.challenge.view.TeamDetailsViewImpl;

/**
 * Created by ajayshrestha on 1/17/17.
 */

/**
 * This class is the details profile view of individual team
 */
public class TeamDetailsActivity extends AppCompatActivity {

    private TeamDetailsView mTeamDetailsView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTeamDetailsView = new TeamDetailsViewImpl(LayoutInflater.from(TeamDetailsActivity.this), null);
        setContentView(mTeamDetailsView.getRootView());

        setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();
        Profile profile = (Profile) intent.getSerializableExtra(getString(R.string.profile));
        if (null != profile) {
            mTeamDetailsView.onBindProfile(profile);
        } else {
            finish();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);

    }
}
