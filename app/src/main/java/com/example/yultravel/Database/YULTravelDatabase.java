package com.example.yultravel.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.yultravel.Plans.Plan;
import com.example.yultravel.Plans.PlanDAO;

@Database(entities = {Profile.class,Plan.class}, version = 1, exportSchema = false )

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
                            .addCallback(sRoomDB)
                            .build();

                    INSTANCE = Room.databaseBuilder(ctx.getApplicationContext(),
                            YULTravelDatabase.class,"plan_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(sRoomDB)
                    .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDB = new RoomDatabase.Callback() {
        public void onOpen(@NonNull SupportSQLiteDatabase sqldb) {
            super.onOpen(sqldb);
            new PopulateDbAsync(INSTANCE).execute();
        }

        class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
            //private final ProfileDAO pDAO;
            private final PlanDAO planDAO;
            String[]plans= {"hiking","Biking","CURLING"};

            public PopulateDbAsync(YULTravelDatabase instance) {
                //pDAO = instance.ProfileDAO();
                planDAO = instance.PlanDAO();

            }

            @Override
            protected Void doInBackground(Void... voids) {
               // pDAO.deleteAll();
                planDAO.detleAll();
                for (int i=0; i<plans.length; i++){
                    Plan plan = new Plan(plans[i]);
                    planDAO.insertPlan(plan);
                }
                return null;
            }
        }
    };

    public abstract ProfileDAO ProfileDAO();
    public abstract PlanDAO PlanDAO();
}
