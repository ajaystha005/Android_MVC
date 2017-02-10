package com.mvc.challenge.view;

import android.view.View;

import com.mvc.challenge.pojos.Profile;

import java.util.ArrayList;

/**
 * Created by ajayshrestha on 1/18/17.
 */


/**
 * This MVC view class is used in TeamProfile screen
 */
public interface TeamProfileView extends MVCView {

    /**
     * This callback gets fired when user click on team profile by defining the transition view
     */
    interface ProfileClickListener {
        void onProfileClick(Profile profile, View transitionView);
    }

    /**
     * Register the listener
     *
     * @param profileClickListener
     */
    void setListener(ProfileClickListener profileClickListener);


    /**
     * bind the data to view
     *
     * @param teamProfileList
     */
    void bindTeamProfileList(ArrayList<Profile> teamProfileList);

}
