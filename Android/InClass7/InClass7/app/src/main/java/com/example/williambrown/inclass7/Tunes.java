package com.example.williambrown.inclass7;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.icu.text.SimpleDateFormat;
import android.support.annotation.NonNull;

/**
 * Created by williambrown on 6/15/17.
 */

public class Tunes implements Comparable<Tunes> {

    String trackName, genre, artist, album, date, artworkURL;
    Bitmap artwork;
    double trackPrice, AlbumPrice;

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        String[] array = date.split("-");


        this.date = array[2] + "-" + array[1] + "-" + array[0];
    }

    public Bitmap getArtwork() {
        return artwork;
    }

    public void setArtwork(Bitmap artwork) {
        this.artwork = artwork;
    }

    public double getTrackPrice() {
        return trackPrice;
    }

    public void setTrackPrice(double trackPrice) {
        this.trackPrice = trackPrice;
    }

    public double getAlbumPrice() {
        return AlbumPrice;
    }

    public void setAlbumPrice(double albumPrice) {
        AlbumPrice = albumPrice;
    }

    public String getArtworkURL() {
        return artworkURL;
    }

    public void setArtworkURL(String artworkURL) {
        this.artworkURL = artworkURL;
    }

    @Override
    public int compareTo(Tunes tunes) {

        return this.getDate().compareTo(tunes.getDate());
    }
}

