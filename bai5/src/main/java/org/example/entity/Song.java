package org.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Song {
    @Id
    private int id;
    private String name;
    private String type;
    private String urlSong;

    public Song() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrlSong() {
        return urlSong;
    }

    public void setUrlSong(String urlSong) {
        this.urlSong = urlSong;
    }

    public Song(int id, String name, String type, String urlSong) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.urlSong = urlSong;
    }
}
