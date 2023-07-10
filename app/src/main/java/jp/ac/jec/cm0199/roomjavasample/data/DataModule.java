package jp.ac.jec.cm0199.roomjavasample.data;

import android.content.Context;

import androidx.room.Room;

import jp.ac.jec.cm0199.roomjavasample.Logger;

public class DataModule {
    private static DataModule dataModule;
    private final AppDatabase db;

    private DataModule(Context context) {
        Logger.d("hashcode= " + hashCode());
        db = Room.databaseBuilder(context,
                AppDatabase.class, "database-name").build();
    }

    public static synchronized DataModule getInstance(Context context) {
        if (dataModule == null) {
            dataModule = new DataModule(context);
        }
        return dataModule;
    }

    public AppDatabase getDb() {
        return db;
    }
}
