package com.amiri.faleHafez.service;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.amiri.faleHafez.entity.Fal;

import java.util.List;

@Dao
public interface FalDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Fal fal);

    @Query("DELETE FROM poem_table")
    void deleteAll();

    @Query("SELECT * FROM poem_table ORDER BY Poem ASC")
    LiveData<List<Fal>> getRandomPoems();

}
