package com.techbeloved.churchbeloved.data.dao;

import com.techbeloved.churchbeloved.data.model.Sermon;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface SermonDao {

    @Query("SELECT * FROM sermons ORDER BY updated")
    LiveData<List<Sermon>> loadAllSermon();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSermon(Sermon sermon);

    @Query("SELECT * FROM sermons WHERE id = :sermonId")
    LiveData<Sermon> getSermon(String sermonId);

    @Query("SELECT * FROM sermons WHERE series_id = :sermonId")
    LiveData<List<Sermon>> loadSermonsForSeries(String sermonId);
}
