package com.example.to_doapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.versionedparcelable.VersionedParcelize

@VersionedParcelize
@Entity(tableName = "todo_table")
data class Todo(
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    @ColumnInfo(name = "Title")
    val title : String,
    @ColumnInfo(name = "Date")
    val date : String,
    @ColumnInfo(name = "Description")
    val description : String)