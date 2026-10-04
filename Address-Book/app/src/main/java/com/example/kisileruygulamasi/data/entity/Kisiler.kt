package com.example.kisileruygulamasi.data.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "kisiler")
data class Kisiler(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "kisi_id")
    val kisi_id: Int = 0,

    @ColumnInfo(name = "kisi_ad")
    val kisi_ad: String,

    @ColumnInfo(name = "kisi_tel")
    val kisi_tel: String
) : Parcelable
