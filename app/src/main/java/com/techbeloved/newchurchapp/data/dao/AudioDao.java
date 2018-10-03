package com.techbeloved.newchurchapp.data.dao;

import com.techbeloved.newchurchapp.data.model.Audio;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface AudioDao {

    @Query("SELECT * FROM audios ORDER BY downloaded")
    LiveData<List<Audio>> loadAllAudio();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAudio(Audio audio);

    @Query("SELECT * FROM audios WHERE id = :audioId")
    LiveData<Audio> getAudio(String audioId);

    @Query("SELECT * FROM audios WHERE sermon_id = :sermonId")
    LiveData<List<Audio>> loadSermonAudios(String sermonId);
}
