package com.mvc.challenge.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mvc.challenge.R;
import com.mvc.challenge.pojos.Profile;

/**
 * Created by ajayshrestha on 1/18/17.
 */

public class ProfileThumbnailViewImpl implements ProfileThumbnailView {

    private View mRootView;
    private ImageView mProfileImage;
    private TextView mFullName;
    private TextView mTitle;

    private Profile mProfile;

    private OnItemClickListener onItemClickListener;

    public ProfileThumbnailViewImpl(LayoutInflater inflater, ViewGroup root) {
        mRootView = inflater.inflate(R.layout.layout_team_profile_item, root, false);
        setListener();
    }

    public void initializeUI(View view) {
        mProfileImage = (ImageView) view.findViewById(R.id.profileImage);
        mFullName = (TextView) view.findViewById(R.id.fullname);
        mTitle = (TextView) view.findViewById(R.id.title);
    }

    public void setListener() {
        mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(mProfile, mProfileImage);
                }
            }
        });
    }

    private void setProfileInfo() {
        Glide.with(mRootView.getContext()).load(mProfile.getAvatar()).asBitmap()
                .placeholder(R.drawable.loading).into(mProfileImage);
        mFullName.setText(mProfile.getName());
        mTitle.setText(mProfile.getTitle());
    }

    @Override
    public View getRootView() {
        return mRootView;
    }


    @Override
    public void bindProfileInfo(Profile profile) {
        this.mProfile = profile;
        setProfileInfo();
    }

    @Override
    public void setClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
