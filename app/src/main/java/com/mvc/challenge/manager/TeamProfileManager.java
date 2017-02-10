package com.mvc.challenge.manager;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.mvc.challenge.pojos.Profile;
import com.mvc.challenge.utils.Utils;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ajayshrestha on 1/17/17.
 */

public class TeamProfileManager {
    private static final String TAG = TeamProfileManager.class.getSimpleName();
    private static TeamProfileManager Instance;
    private Context mContext;

    private TeamProfileManagerListener mTeamProfileManagerListener;

    /**
     * This listener gets fired when successfully loaded data
     */
    public interface TeamProfileManagerListener {
        void onProfileFetched(ArrayList<Profile> teamProfileList);
    }

    private TeamProfileManager(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * get the instance following Singleton pattern
     * @param mContext
     * @return
     */
    public static TeamProfileManager getInstance(Context mContext) {
        if (null == Instance) {
            Instance = new TeamProfileManager(mContext);
        }
        return Instance;
    }

    /**
     * load data on background thread and notified on UI thread
     */
    public void loadTeamProfile() {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    ArrayList<Profile> teamProfileList = Utils.parseTeamProfile(Utils.getJsonFromAssets(mContext));
                    Collections.sort(teamProfileList);
                    notifyTeamProfileLoaded(teamProfileList);
                } catch (JSONException ex) {
                    Log.e(TAG, ex.getMessage());
                } catch (IOException ex) {
                    Log.e(TAG, ex.getMessage());
                    Utils.showMessage(mContext, "Error while loading data");

                }
            }
        });
    }

    /**
     * notify on main thread
     *
     * @param teamProfileList
     */
    private void notifyTeamProfileLoaded(final ArrayList<Profile> teamProfileList) {
        ((Activity) mContext).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mTeamProfileManagerListener != null) {
                    mTeamProfileManagerListener.onProfileFetched(teamProfileList);
                }
            }
        });
    }

    /**
     * Register the listener for manage team data
     *
     * @param mTeamProfileManagerListener
     */
    public void registerListener(TeamProfileManagerListener mTeamProfileManagerListener) {
        this.mTeamProfileManagerListener = mTeamProfileManagerListener;
    }

}
