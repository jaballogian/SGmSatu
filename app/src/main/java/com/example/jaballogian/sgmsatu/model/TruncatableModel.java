package com.example.jaballogian.sgmsatu.model;

import android.util.Log;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Cache;
import com.activeandroid.Model;

public abstract class TruncatableModel extends Model {
    public static void truncate(Class<? extends Model> type){
        final String tableName = Cache.getTableName(type);


        // Delete all rows from table
        ActiveAndroid.execSQL(String.format("DELETE FROM %s;", tableName));

        // Reset ids
        ActiveAndroid.execSQL(String.format("DELETE FROM sqlite_sequence WHERE name='%s';", tableName));
    }
}