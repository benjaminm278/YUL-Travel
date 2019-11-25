package com.example.yultravel.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Profile.class}, version = 1, exportSchema = false)
public abstract class YULTravelDatabase extends RoomDatabase {
    // Defines the DAO that works with the room

    // Creates a SINGLETON to prevent multple instances of the database from being created
    private static YULTravelDatabase INSTANCE;

    /**
     * Prevents multiple instances from being created
     *
     * @param ctx
     * @return
     */
    public static YULTravelDatabase getDatabase(final Context ctx) {
        if (INSTANCE == null) {
            // No instance of database
            synchronized (YULTravelDatabase.class) {
                if (INSTANCE == null) {
                    // Create database
                    INSTANCE = Room.databaseBuilder(ctx.getApplicationContext(),
                            YULTravelDatabase.class, "profile_database")
                            .fallbackToDestructiveMigration() // Wipes and rebuilds instead of migrating
                            //.addCallback(sRoomDBCallBack)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDB = new RoomDatabase.Callback() {
        public
    };

    public abstract ProfileDAO ProfileDAO();
}
