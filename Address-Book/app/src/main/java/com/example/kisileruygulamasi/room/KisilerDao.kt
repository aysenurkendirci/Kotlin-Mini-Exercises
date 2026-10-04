package com.example.kisileruygulamasi.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.kisileruygulamasi.data.entity.Kisiler
import kotlinx.coroutines.flow.Flow

@Dao
interface KisilerDao {
    @Query("SELECT * FROM kisiler")
    fun kisileriYukle(): Flow<List<Kisiler>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun kaydet(kisi: Kisiler): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun guncelle(kisi: Kisiler): Int

    @Delete
    suspend fun sil(kisi: Kisiler): Int

    @Query("SELECT * FROM kisiler WHERE kisi_ad like '%' || :aramaKelimesi || '%'")
    fun ara(aramaKelimesi:String): Flow<List<Kisiler>>

}


