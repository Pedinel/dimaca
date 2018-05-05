/*
 * Copyright (c) 2018 Distribuidora Mariana C.A. - All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited,
 * proprietary and confidential.
 * Written by Rosangela Segura.
 * Last Modified by Rosangela Segura 04/05/18 08:45 PM
 */

package com.dimaca.app;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.dimaca.database.UsersDao;
import com.dimaca.models.User;

/**
 * The Application Database
 */
@Database(
        entities = {
                User.class
        },
        version = 1,
        exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {
    /** The database name */
    private static final String DB_NAME = "dimaca_db";

    /**
     * Retrieves the {@link User} dao
     *
     * @return the {@link UsersDao} instance
     */
    public abstract UsersDao usersDao();

    /**
     * Retrieves the {@link AppDatabase} from any {@link Context}
     *
     * @param context the Context
     * @return the Database instance
     */
    @NonNull
    public static AppDatabase from(@NonNull Context context) {
        AppContext appContext = AppContext.from(context);

        if (appContext.database != null) {
            return appContext.database;
        } else {
            return buildOnce(appContext);
        }
    }

    /**
     * Builds the Database instance if not built before
     *
     * @param context the Application Context
     * @return the Database instance
     */
    @NonNull
    private static synchronized AppDatabase buildOnce(AppContext context) {
        if (context.database == null) {
            RoomDatabase.Builder<AppDatabase> builder = Room.databaseBuilder(
                    context,
                    AppDatabase.class,
                    DB_NAME
            );

            context.database = builder
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return context.database;
    }
}
