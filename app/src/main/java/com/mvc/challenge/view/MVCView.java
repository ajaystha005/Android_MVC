package com.mvc.challenge.view;

import android.view.View;

/**
 * Created by ajayshrestha on 1/17/17.
 */

/**
 * This class is the MVC view which is used by all View class
 */

public interface MVCView {

    /**
     * Returns the Android view which is used by MVC view for presenting to user
     *
     * @return View
     */
    public View getRootView();
}
