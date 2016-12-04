package com.codesgood.libraries.model;

import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;


public class Post implements Parcelable{

    private static final String FIELD_ID = "id";
    private static final String FIELD_TITLE = "title";
    private static final String FIELD_BODY = "body";
    private static final String FIELD_USER_ID = "userId";


    @SerializedName(FIELD_ID)
    private long mId;
    @SerializedName(FIELD_TITLE)
    private String mTitle;
    @SerializedName(FIELD_BODY)
    private String mBody;
    @SerializedName(FIELD_USER_ID)
    private int mUserId;


    public Post(){

    }

    public void setId(long id) {
        mId = id;
    }

    public long getId() {
        return mId;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setBody(String body) {
        mBody = body;
    }

    public String getBody() {
        return mBody;
    }

    public void setUserId(int userId) {
        mUserId = userId;
    }

    public int getUserId() {
        return mUserId;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Post){
            return ((Post) obj).getId() == mId;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return ((Long)mId).hashCode();
    }

    public Post(Parcel in) {
        mId = in.readLong();
        mTitle = in.readString();
        mBody = in.readString();
        mUserId = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Post> CREATOR = new Creator<Post>() {
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        public Post[] newArray(int size) {
        return new Post[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(mId);
        dest.writeString(mTitle);
        dest.writeString(mBody);
        dest.writeInt(mUserId);
    }


}