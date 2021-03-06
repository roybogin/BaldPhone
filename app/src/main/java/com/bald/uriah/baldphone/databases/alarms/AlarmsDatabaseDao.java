/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.bald.uriah.baldphone.databases.alarms;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface AlarmsDatabaseDao {
    @Query("SELECT * FROM Alarm")
    List<Alarm> getAll();

    @Query("SELECT * FROM Alarm WHERE enabled = 1")
    List<Alarm> getAllEnabled();

    @Query("UPDATE Alarm SET enabled=:enabled WHERE `key` = :key")
    void update(int key, boolean enabled);

    @Query("SELECT * FROM Alarm WHERE `key` = :key LIMIT 1")
    Alarm getByKey(int key);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(Alarm... alarms);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(Alarm alarm);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long replace(Alarm alarm);

    @Delete
    void delete(Alarm alarm);

    @Query("DELETE FROM Alarm WHERE `key` IN (:keys)")
    void deleteByIds(int... keys);


    @Query("DELETE FROM Alarm")
    void deleteAll();

    @Query("SELECT COUNT(*) FROM Alarm")
    int getNumberOfRows();
}
