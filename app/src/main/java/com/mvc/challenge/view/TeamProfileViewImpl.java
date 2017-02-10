package com.mvc.challenge.view;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mvc.challenge.R;
import com.mvc.challenge.adapter.TeamProfileAdapter;
import com.mvc.challenge.pojos.Profile;

import java.util.ArrayList;

/**
 * Created by ajayshrestha on 1/17/17.
 */

/**
 * This is the implementation of Team profile MVC view which helps to load all the team members
 */
public class TeamProfileViewImpl implements TeamProfileView, ProfileThumbnailView.OnItemClickListener {

    private View mRootView;
    private RecyclerView mRecyclerView;
    private TeamProfileAdapter mTeamProfileAdapter;
    private ProfileClickListener mProfileClickListener;
    private ArrayList<Profile> mTeamProfileList = new ArrayList<>();


    public TeamProfileViewImpl(LayoutInflater inflater, ViewGroup root) {
        mRootView = inflater.inflate(R.layout.layout_team_profile, root, false);
        initializeUI();
        initializeAdapter(inflater.getContext());
    }

    private void initializeUI() {
        mRecyclerView = (RecyclerView) mRootView.findViewById(R.id.teamRecyclerView);
    }

    private void initializeAdapter(Context mContext) {
        //mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getRootView().getContext(), 2));

        mTeamProfileAdapter = new TeamProfileAdapter(mContext, mTeamProfileList);
        mTeamProfileAdapter.setItemClickListener(this);

        mRecyclerView.setAdapter(mTeamProfileAdapter);
    }

    /**
     * Refresh the adapter after update
     */
    private void refreshProfileAdapter() {
        mTeamProfileAdapter.updateProfileList(mTeamProfileList);
        mTeamProfileAdapter.notifyDataSetChanged();
    }


    @Override
    public View getRootView() {
        return mRootView;
    }

    @Override
    public void setListener(ProfileClickListener mProfileClickListener) {
        this.mProfileClickListener = mProfileClickListener;
    }

    @Override
    public void bindTeamProfileList(ArrayList<Profile> teamProfileList) {
        this.mTeamProfileList = teamProfileList;
        refreshProfileAdapter();
    }

    @Override
    public void onItemClick(Profile profile, View transitionView) {
        if (mProfileClickListener != null) {
            mProfileClickListener.onProfileClick(profile, transitionView);
        }
    }
}
