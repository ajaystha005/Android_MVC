package com.mvc.challenge.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mvc.challenge.pojos.Profile;
import com.mvc.challenge.view.ProfileThumbnailView;
import com.mvc.challenge.view.ProfileThumbnailViewImpl;

import java.util.ArrayList;

/**
 * Created by ajayshrestha on 1/17/17.
 */

/**
 * Adapter class for Team Profile
 */
public class TeamProfileAdapter extends RecyclerView.Adapter<TeamProfileAdapter.ProfileHolder> {

    private Context mContext;
    private ArrayList<Profile> mTeamProfileList = new ArrayList<>();
    private ProfileThumbnailView mProfileView;
    private ProfileThumbnailView.OnItemClickListener onItemClickListener;

    public TeamProfileAdapter(Context mContext, ArrayList<Profile> mTeamProfileList) {
        this.mContext = mContext;
        this.mTeamProfileList = mTeamProfileList;
    }

    public void updateProfileList(ArrayList<Profile> mTeamProfileList) {
        this.mTeamProfileList = mTeamProfileList;
    }

    public void setItemClickListener(ProfileThumbnailView.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ProfileHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mProfileView = new ProfileThumbnailViewImpl(LayoutInflater.from(mContext), parent);
        mProfileView.setClickListener(onItemClickListener);

        return new ProfileHolder(mProfileView.getRootView());
    }

    @Override
    public void onBindViewHolder(ProfileHolder holder, final int position) {
        mProfileView.bindProfileInfo(mTeamProfileList.get(holder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return mTeamProfileList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ProfileHolder extends RecyclerView.ViewHolder {

        public ProfileHolder(View itemView) {
            super(itemView);
            mProfileView.initializeUI(itemView);

        }
    }
}
