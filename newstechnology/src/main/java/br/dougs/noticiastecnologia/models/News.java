package br.dougs.noticiastecnologia.models;

import android.support.v7.appcompat.R;

/**
 * Created by Douglas on 07/06/14.
 */
public class News {

    private String title;
    private String link;
    private String description;
    private String pubdate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + getTitle() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", pubdate='" + getPubdate() + '\'' +
                ", link='" + getLink() + '\'' +
                '}';
    }
}
