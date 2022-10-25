package com.amiri.faleHafez.dataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.amiri.faleHafez.entity.Fal;
import com.amiri.faleHafez.service.FalDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Fal.class}, version = 1, exportSchema = false)
public abstract class FalDatabase extends RoomDatabase {

    public abstract FalDao falDao();

    private static volatile FalDatabase Instance;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static FalDatabase getDatabase(final Context context) {
        if (Instance == null) {
            synchronized (FalDatabase.class) {
                if (Instance == null) {
                    Instance = Room.databaseBuilder(context.getApplicationContext(),
                            FalDatabase.class, "fal_database")
                            .build();
                }
            }
        }
        return Instance;
    }
}
