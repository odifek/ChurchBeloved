package com.techbeloved.churchbeloved.data;

import android.content.Context;

import com.techbeloved.churchbeloved.data.dao.AudioDao;
import com.techbeloved.churchbeloved.data.dao.SeriesDao;
import com.techbeloved.churchbeloved.data.dao.SermonDao;
import com.techbeloved.churchbeloved.data.dao.VideoDao;
import com.techbeloved.churchbeloved.data.model.Audio;
import com.techbeloved.churchbeloved.data.model.Series;
import com.techbeloved.churchbeloved.data.model.Sermon;
import com.techbeloved.churchbeloved.data.model.Video;
import com.techbeloved.churchbeloved.utils.AppExecutors;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Series.class, Sermon.class, Audio.class, Video.class}, version = 1)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase sInstance;

    private static final String DATABASE_NAME = "church_beloved_db";

    public abstract AudioDao audioDao();

    public abstract VideoDao videoDao();

    public abstract SermonDao sermonDao();

    public abstract SeriesDao seriesDao();

    public static AppDatabase getInstance(final Context context, AppExecutors executors) {
        if (sInstance == null) {
            synchronized (AppDatabase.class) {
                sInstance = Room.databaseBuilder(
                        context.getApplicationContext(),
                        AppDatabase.class,
                        AppDatabase.DATABASE_NAME
                ).build();
            }
        }
        return sInstance;
    }
}
