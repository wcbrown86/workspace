package com.example.williambrown.midtearm;

import android.graphics.Bitmap;

/**
 * Created by williambrown on 6/13/17.
 */

public class Tunes {

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
        this.date = date;
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
}
