package com.example.kisileruygulamasi.data.datasource

import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.room.KisilerDao
import kotlinx.coroutines.flow.Flow

class KisilerDataSource(private val kdao: KisilerDao) {

    // Kisileri yüklemek için Flow kullanıyoruz
    fun kisileriYukle(): Flow<List<Kisiler>> = kdao.kisileriYukle()

    // Arama fonksiyonunu Flow yerine doğrudan List döndürebiliriz
    fun ara(aramakelimesi: String): Flow<List<Kisiler>> {
        return kdao.ara(aramakelimesi)
    }


    suspend fun kaydet(kisi_ad: String, kisi_tel: String) {
        // Veri kaydetme işlemi
        val yeniKisi=Kisiler(0,kisi_ad,kisi_tel)
        kdao.kaydet(yeniKisi)
    }

    suspend fun guncelle(kisi_id: Int, kisi_ad: String, kisi_tel: String) {
        val guncellenenKisi=Kisiler(kisi_id,kisi_ad,kisi_tel)
        kdao.guncelle(guncellenenKisi)// Veri güncelleme işlemi
    }

    suspend fun sil(kisi_id: Int) {
       val silinenkisi=Kisiler(kisi_id,"","")
        kdao.sil(silinenkisi)// Kişi silme işlemi
    }
}
