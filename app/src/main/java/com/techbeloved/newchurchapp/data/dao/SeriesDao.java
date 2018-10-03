package com.techbeloved.newchurchapp.data.dao;

import com.techbeloved.newchurchapp.data.model.Series;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface SeriesDao {

    @Query("SELECT * FROM series")
    LiveData<List<Series>> loadAllSeries();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSeries(Series series);

    @Query("SELECT * FROM sermons WHERE id = :seriesId")
    LiveData<Series> getSeries(String seriesId);
}
