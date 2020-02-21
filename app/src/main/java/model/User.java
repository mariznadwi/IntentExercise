package model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    String name,email,pass,cpass,homepage,about;

    public User(){}

    public User(String name,String email,String pass,String cpass,String homepage,String about){
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.cpass = cpass;
        this.homepage = homepage;
        this.about = about;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCpass() {
        return cpass;
    }

    public void setCpass(String cpass) {
        this.cpass = cpass;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public static Creator<User> getCREATOR() {
        return CREATOR;
    }

    protected User(Parcel in) {
        this.name = in.readString();
        this.email = in.readString();
        this.pass = in.readString();
        this.cpass = in.readString();
        this.homepage = in.readString();
        this.about = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.email);
        dest.writeString(this.pass);
        dest.writeString(this.cpass);
        dest.writeString(this.homepage);
        dest.writeString(this.about);
    }
}