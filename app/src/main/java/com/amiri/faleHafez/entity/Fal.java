package com.amiri.faleHafez.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "poem_table")
public class Fal {

    @ColumnInfo(name = "poem")

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    private String Poems;



    public Fal(@NonNull String poems) {
        this.Poems = poems;
    }

    public String getPoems() {
        return this.Poems;
    }

}
