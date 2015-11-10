/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab20.upg1a;

/**
 * Created by Sebastian Börebäck on 2015-11-10.
 */
public class Media {

    private long id;
    private String title;

    public Media()
    {

    }

    public Media(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Media{" +
                "id=" + id +
                ", title='" + title + '\'' +"\n"+
                super.toString()+
                '}';
    }
}
