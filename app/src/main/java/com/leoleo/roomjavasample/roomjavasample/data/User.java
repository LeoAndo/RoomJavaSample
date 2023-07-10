package com.leoleo.roomjavasample.roomjavasample.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    @NonNull
    @Override
    public String toString() {
        return uid + " : " + firstName + " : " + lastName;
    }
}