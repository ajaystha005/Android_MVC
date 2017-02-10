package com.mvc.challenge.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.mvc.challenge.pojos.Profile;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by ajayshrestha on 1/17/17.
 */

public class Utils {

    /**
     * parse the team json data
     *
     * @param teamJson
     * @return
     * @throws JSONException
     */
    public static ArrayList<Profile> parseTeamProfile(String teamJson) throws JSONException {

        if (null != teamJson) {
            ArrayList<Profile> teamProfileList = new ArrayList<>();
            JSONArray profileJsonArray = new JSONArray(teamJson);
            for (int i = 0; i < profileJsonArray.length(); i++) {
                JSONObject jsonObject = profileJsonArray.getJSONObject(i);
                if (null != jsonObject) {
                    String avatar = jsonObject.getString("avatar");
                    String bio = jsonObject.getString("intro");
                    String name = jsonObject.getString("name");
                    String id = jsonObject.getString("id");
                    String title = jsonObject.getString("title");

                    Profile profile = new Profile();
                    profile.setId(id);
                    profile.setAvatar(avatar);
                    profile.setName(name);
                    profile.setBio(bio);
                    profile.setTitle(title);

                    teamProfileList.add(profile);
                }
            }
            return teamProfileList;
        }
        return null;
    }

    /**
     * Return json file from Assets folder
     *
     * @param mContext
     * @return
     * @throws IOException
     */
    public static String getJsonFromAssets(Context mContext) throws IOException {
        InputStream inputStream = mContext.getAssets().open("team.json");
        int size = inputStream.available();
        byte[] buffer = new byte[size];
        inputStream.read(buffer);
        inputStream.close();

        return new String(buffer, "UTF-8");

    }

    /**
     * This display the toast message
     *
     * @param mContext
     * @param message
     */
    public static void showMessage(final Context mContext, final String message) {
        new Handler(Looper.myLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
