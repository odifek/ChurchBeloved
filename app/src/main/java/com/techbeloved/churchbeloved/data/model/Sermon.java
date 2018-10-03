package com.techbeloved.churchbeloved.data.model;

import java.util.Date;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "sermons", indices = @Index(value = {"id", "title", "minister", "location"}),
        foreignKeys = @ForeignKey(entity = Series.class, parentColumns = "id",
                childColumns = "series_id", onDelete = CASCADE))
public class Sermon {
    /**
     * id is a firebase generated id
     */
    @NonNull
    @PrimaryKey
    private String id;
    private String title;

    private String summary;

    /**
     * Name of the minister
     */
    private String minister;

    /**
     * Where (parish, district, diocese, state etc) the message was preached
     */
    private String location;

    /**
     * series id for the particular series the message belongs to, if any
     */
    @ColumnInfo(name = "series_id")
    private String seriesId;
    @ColumnInfo(name = "series_name")
    private String seriesName;

    /**
     * Can be Sunday light, Bible study, Charismatic hour, Mount Horeb, etc
     */
    private String category;

    private Date published;
    private Date updated;

    /**
     * If the audio has been downloaded, the file location will be stored here
     */
    private String localAudioUrl;

    /**
     * Notes is html formatted String which can be displayed in a Webview
     */
    private String notes;


    public Sermon(@NonNull String id, String title) {
        this.id = id;
        this.title = title;
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

    public String getMinister() {
        return minister;
    }

    public void setMinister(String minister) {
        this.minister = minister;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLocalAudioUrl() {
        return localAudioUrl;
    }

    public void setLocalAudioUrl(String localAudioUrl) {
        this.localAudioUrl = localAudioUrl;
    }
}
