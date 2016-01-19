/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.skola.lab13;

/**
 * Created by sebadmin on 2015-10-13.
 */
public class PhoneNumber {
    private String home;
    private String work;
    private String mobile;

    public PhoneNumber(String home, String work, String mobile) {
        this.home = home;
        this.work = work;
        this.mobile = mobile;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "home='" + home + '\'' +
                ", work='" + work + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}

