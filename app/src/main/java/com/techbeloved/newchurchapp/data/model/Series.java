package com.techbeloved.newchurchapp.data.model;

import java.util.Date;
import java.util.List;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * A series can be a series of sermons such as have part 1, 2, 3 etc.
 * It can also be used to group sermons preached in a particular occasion such as
 * December retreat 2018, Easter Retreat 2018, etc. In that case the title will be the theme of the
 * occasion
 */
@Entity(tableName = "series")
public class Series {

    @PrimaryKey
    private String id;

    /**
     * The theme of the series or occasion as the case may be
     */
    private String title;
    /**
     * A brief description of the series or occasion
     */
    private String description;

    private Date updated;

    public Series() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
