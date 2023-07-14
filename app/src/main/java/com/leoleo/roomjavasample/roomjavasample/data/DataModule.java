package com.leoleo.roomjavasample.roomjavasample.data;

import android.content.Context;

import androidx.room.Room;

import com.leoleo.roomjavasample.roomjavasample.Logger;

/**
 * @see <a href="https://en.wikipedia.org/wiki/Double-checked_locking#Usage_in_Java">Double-checked_locking</a>
 * @see <a href="https://en.wikipedia.org/wiki/Singleton_pattern">Singleton_pattern</a>
 */
public class DataModule {
    private static volatile DataModule dataModule;
    private volatile AppDatabase appDatabase;

    private DataModule() {
        Logger.d("hashcode= " + hashCode());
    }

    public static DataModule getInstance() {
        if (dataModule != null) {
            return dataModule;
        } else {
            synchronized (DataModule.class) {
                if (dataModule == null) {
                    dataModule = new DataModule();
                }
                return dataModule;
            }
        }
    }

    public AppDatabase appDatabase(Context context) {
        if (appDatabase != null) {
            return appDatabase;
        } else {
            synchronized (this) {
                if (appDatabase == null) {
                    appDatabase = Room.databaseBuilder(context,
                            AppDatabase.class, "database-name").build();
                }
                return appDatabase;
            }
        }
    }
}
