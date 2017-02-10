package com.mvc.challenge.view;

import com.mvc.challenge.pojos.Profile;

/**
 * Created by ajayshrestha on 1/17/17.
 */

/**
 * This MVC view class is used to bind profile data to view
 */
public interface TeamDetailsView extends MVCView {

    void onBindProfile(Profile profile);

}
