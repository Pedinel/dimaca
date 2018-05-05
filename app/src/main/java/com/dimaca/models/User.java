/*
 * Copyright (c) 2018 Distribuidora Mariana C.A. - All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited,
 * proprietary and confidential.
 * Written by Rosangela Segura.
 * Last Modified by Rosangela Segura 04/05/18 08:30 PM
 */

package com.dimaca.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "users")
public final class User {
    @PrimaryKey
    private long id;

    @NonNull
    private String name;

    @NonNull
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }
}
