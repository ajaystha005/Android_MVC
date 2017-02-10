package com.mvc.challenge.view;

import android.view.View;

import com.mvc.challenge.pojos.Profile;

/**
 * Created by ajayshrestha on 1/18/17.
 */

/**
 * This MVC Thumbnail View class is used for Adapter class
 */
public interface ProfileThumbnailView extends MVCView {

    interface OnItemClickListener {
        void onItemClick(Profile profile, View transitionView);
    }

    void bindProfileInfo(Profile profile);

    void setClickListener(OnItemClickListener onItemClickListener);

    void initializeUI(View rootView);
}
