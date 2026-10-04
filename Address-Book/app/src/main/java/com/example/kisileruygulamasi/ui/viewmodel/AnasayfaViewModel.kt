package com.example.kisileruygulamasi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor (var krepo:KisilerRepository): ViewModel() {

    var kisilerListesi = MutableLiveData<List<Kisiler>>()

    init {
        kisileriYukle()
    }

    fun sil(kisi_id: Int) {
        viewModelScope.launch(Dispatchers.Main) {
            krepo.sil(kisi_id)
        }
    }

    fun kisileriYukle() {
        viewModelScope.launch {
            // Kisileri yüklemek için Flow'dan verileri alıyoruz
            krepo.kisileriYukle().collect { kisiler ->
                kisilerListesi.value = kisiler
            }
        }
    }

    fun ara(aramaKelimesi: String) {
        viewModelScope.launch {
            // Arama sonuçlarını almak için Flow'dan verileri alıyoruz
            krepo.ara(aramaKelimesi).collect { kisiler ->
                kisilerListesi.value = kisiler
            }
        }
    }

}