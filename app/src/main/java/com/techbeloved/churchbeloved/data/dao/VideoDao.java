package com.techbeloved.churchbeloved.data.dao;

import com.techbeloved.churchbeloved.data.model.Video;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface VideoDao {
    @Query("SELECT * FROM videos ORDER BY dowloaded")
    LiveData<List<Video>> loadAllVideo();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertVideo(Video videos);

    @Query("SELECT * FROM videos WHERE id = :videoId")
    LiveData<Video> getVideo(String videoId);

    @Query("SELECT * FROM videos WHERE sermon_id = :sermonId")
    LiveData<List<Video>> loadSermonVideos(String sermonId);
}
