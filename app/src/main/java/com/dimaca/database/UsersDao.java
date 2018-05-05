/*
 * Copyright (c) 2018 Distribuidora Mariana C.A. - All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited,
 * proprietary and confidential.
 * Written by Rosangela Segura.
 * Last Modified by Rosangela Segura 04/05/18 08:35 PM
 */

package com.dimaca.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.dimaca.models.User;

@Dao
public interface UsersDao {
    @Insert
    void saveUser(User user);

    @Query("SELECT * FROM users WHERE id = :userId")
    User findUserById(long userId);

    @Update
    void updateUser(User user);

    @Query("DELETE FROM users")
    void deleteAllUsers();
}
