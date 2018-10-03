package com.techbeloved.newchurchapp.data;

import android.content.Context;

import com.techbeloved.newchurchapp.data.dao.AudioDao;
import com.techbeloved.newchurchapp.data.dao.SeriesDao;
import com.techbeloved.newchurchapp.data.dao.SermonDao;
import com.techbeloved.newchurchapp.data.dao.VideoDao;
import com.techbeloved.newchurchapp.data.model.Audio;
import com.techbeloved.newchurchapp.data.model.Series;
import com.techbeloved.newchurchapp.data.model.Sermon;
import com.techbeloved.newchurchapp.data.model.Video;
import com.techbeloved.newchurchapp.utils.AppExecutors;

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
