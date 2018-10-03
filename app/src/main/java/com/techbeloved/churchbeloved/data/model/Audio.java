package com.techbeloved.churchbeloved.data.model;

import java.util.Date;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "audios", indices = @Index(value = {"id", "title", "artist"}),
        foreignKeys = @ForeignKey(entity = Sermon.class, parentColumns = "id",
                childColumns = "sermon_id", onDelete = CASCADE))
public class Audio {

    /**
     * Auto generated Firebase Id for this audio
     */
    @NonNull
    @PrimaryKey
    private String id;
    private String title;

    @ColumnInfo(name = "sermon_id")
    private String sermonId;

    /**
     * The specific audio format. Can be mp3, aac, opus, etc
     */
    private String format;
    private String bitrate;

    /**
     * The storage location of the audio. (Firebase storage, google drive, mediafire, amazon, etc)
     */
    private String location;

    /**
     * The stream id which can be in conjunction with the location used to reconstruct the streamUrl
     */
    private String streamId;

    /**
     * The direct streaming url
     */
    private String streamUrl;
    private String artist;

    private Date downloaded;

    public Audio(@NonNull String id, String title) {
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

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getBitrate() {
        return bitrate;
    }

    public void setBitrate(String bitrate) {
        this.bitrate = bitrate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStreamId() {
        return streamId;
    }

    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }

    public String getStreamUrl() {
        return streamUrl;
    }

    public void setStreamUrl(String streamUrl) {
        this.streamUrl = streamUrl;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSermonId() {
        return sermonId;
    }

    public void setSermonId(String sermonId) {
        this.sermonId = sermonId;
    }

    public Date getDownloaded() {
        return downloaded;
    }

    public void setDownloaded(Date downloaded) {
        this.downloaded = downloaded;
    }
}

