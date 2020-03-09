package com.htngu.btth200309;

class Song {
    private String songName, artName;
    private int thumb;
    private long time;

    public Song(String songName, String artName, int thumb, long time) {
        this.songName = songName;
        this.artName = artName;
        this.thumb = thumb;
        this.time = time;
    }


    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtName() {
        return artName;
    }

    public void setArtName(String artName) {
        this.artName = artName;
    }

    public int getThumb() {
        return thumb;
    }

    public void setThumb(int thumb) {
        this.thumb = thumb;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
