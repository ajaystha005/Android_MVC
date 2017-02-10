package com.mvc.challenge.view;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mvc.challenge.R;
import com.mvc.challenge.pojos.Profile;

/**
 * Created by ajayshrestha on 1/19/17.
 */

/**
 * This MVC view helps to bind profile data with view
 */
public class TeamDetailsViewImpl implements TeamDetailsView {

    private View mRootView;

    private Toolbar mToolbar;
    private ImageView mProfileImage;
    private TextView mFullName;
    private TextView mTitle;
    private TextView mBio;

    public TeamDetailsViewImpl(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        mRootView = layoutInflater.inflate(R.layout.layout_profile_details, viewGroup, false);
        initializeView();
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    private void initializeView() {
        mToolbar = (Toolbar) mRootView.findViewById(R.id.toolbar);
        ((AppCompatActivity) mRootView.getContext()).setSupportActionBar(mToolbar);

        mProfileImage = (ImageView) mRootView.findViewById(R.id.profileImage);
        mFullName = (TextView) mRootView.findViewById(R.id.fullname);
        mTitle = (TextView) mRootView.findViewById(R.id.title);
        mBio = (TextView) mRootView.findViewById(R.id.bio);
    }

    @Override
    public void onBindProfile(Profile mProfile) {
        Glide.with(mRootView.getContext()).load(mProfile.getAvatar()).asBitmap()
                .placeholder(R.drawable.loading).into(mProfileImage);
        mFullName.setText(mProfile.getName());
        mTitle.setText("@" + mProfile.getTitle());
        mBio.setText(mProfile.getBio());
    }
}
