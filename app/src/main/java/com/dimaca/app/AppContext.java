/*
 * Copyright (c) 2018 Soluciones Informáticas Manzanares - All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited,
 * proprietary and confidential.
 * Written by Pedro Parra <pedrop@manzanares.com.ve>.
 * Last Modified by Pedro Parra 04/05/18 08:18 PM
 */

package com.dimaca.app;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

/**
 * The Application Context
 */
public class AppContext extends Application {
    /**
     * Persistent database object
     *
     * @see AppDatabase#from(Context)
     */
    volatile AppDatabase database;

    @Override
    public void onTerminate() {
        super.onTerminate();

        //frees-up resources for Garbage Collector
        database = null;
    }

    /**
     * Retrieves the {@link AppContext} from any {@link Context}
     *
     * @param context the Context
     * @return the Application Context
     */
    @NonNull
    public static AppContext from(@NonNull Context context) {
        return (AppContext) context.getApplicationContext();
    }
}
