/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab20.upg1e;

import skola.lab20.upg1a.Media;

import java.util.Arrays;

/**
 * Created by Sebastian Börebäck on 2015-11-10.
 */
public class CD extends Media{

    private String artist;
    private String[] songs;

    public CD(long id, String title, String artist, String[] songs) {
        super(id, title);
        this.artist = artist;
        this.songs = songs;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String[] getSongs() {
        return songs;
    }

    public void setSongs(String[] songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "CD{" +
                "artist='" + artist + '\'' +
                ", Album='"+getTitle()+'\'' +
                ", songs=" + Arrays.toString(songs) +
                '}';
    }


}
