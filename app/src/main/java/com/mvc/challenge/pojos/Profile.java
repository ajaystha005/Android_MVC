package com.mvc.challenge.pojos;

import java.io.Serializable;

/**
 * Created by ajayshrestha on 1/17/17.
 */

public class Profile implements Serializable, Comparable<Profile> {
    private String mName;
    private String mAvatar;
    private String mId;
    private String mBio;
    private String mTitle;

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getAvatar() {
        return mAvatar;
    }

    public void setAvatar(String mAvatar) {
        this.mAvatar = mAvatar;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        this.mId = id;
    }

    public String getBio() {
        return mBio;
    }

    public void setBio(String mBio) {
        this.mBio = mBio;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    @Override
    public int compareTo(Profile profile) {
        int result = this.mId.compareToIgnoreCase(profile.mId);
        if (result != 0) return result;

        return this.mId.compareTo(profile.mId);
    }
}

