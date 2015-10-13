/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab13;

/**
 * Created by sebadmin on 2015-10-13.
 */
public class Contact {

    private String name;
    private PhoneNumber phone;

    public Contact(String name, String home, String work, String mobile) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHome() {
        return phone.getHome();
    }

    public void setHome(String home) {
        this.phone.setHome(home);
    }

    public String getWork() {
        return phone.getWork();
    }

    public void setWork(String work) {
        phone.setWork(work);
    }

    public String getMobile() {
        return phone.getMobile();
    }

    public void setMobile(String mobile) {
        phone.setMobile(mobile);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +"\n"+
                phone.toString()+
                '}';
    }
}
