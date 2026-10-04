package com.example.hesapmakinesi

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var SonucGoster: TextView

    var operator = "*"
    var eskiSayi = ""
    var yeniOperator = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SonucGoster = findViewById(R.id.sayiGoster)
    }

    fun btnSayiTik(view: View) {
        if (yeniOperator) {
            SonucGoster.text = ""
        }
        yeniOperator = false
        val btnSec = view as Button
        var btnTikDeger = SonucGoster.text.toString()

        when (btnSec.id) {
            R.id.btn0 -> btnTikDeger += "0"
            R.id.btn1 -> btnTikDeger += "1"
            R.id.btn2 -> btnTikDeger += "2"
            R.id.btn3 -> btnTikDeger += "3"
            R.id.btn4 -> btnTikDeger += "4"
            R.id.btn5 -> btnTikDeger += "5"
            R.id.btn6 -> btnTikDeger += "6"
            R.id.btn7 -> btnTikDeger += "7"
            R.id.btn8 -> btnTikDeger += "8"
            R.id.btn9 -> btnTikDeger += "9"
            R.id.btnArtıEksı -> {
                btnTikDeger = if (btnTikDeger.startsWith("-")) {
                    btnTikDeger.substring(1)
                } else {
                    "-$btnTikDeger"
                }
            }
        }

        SonucGoster.text = btnTikDeger
    }

    fun btnOptik(view: View) {
        val btnSec = view as Button
        when (btnSec.id) {
            R.id.btnBolme -> operator = "/"
            R.id.btnCarpma -> operator = "*"
            R.id.btnCıkarma -> operator = "-"
            R.id.btnToplama -> operator = "+"
        }
        eskiSayi = SonucGoster.text.toString()
        yeniOperator = true
    }

    fun btnEsittirTik(view: View) {
        val yeniSayi = SonucGoster.text.toString()
        var sonucSayisi: Double? = null

        if (yeniSayi.isNotEmpty() && eskiSayi.isNotEmpty()) {
            when (operator) {
                "/" -> sonucSayisi = eskiSayi.toDouble() / yeniSayi.toDouble()
                "*" -> sonucSayisi = eskiSayi.toDouble() * yeniSayi.toDouble()
                "-" -> sonucSayisi = eskiSayi.toDouble() - yeniSayi.toDouble()
                "+" -> sonucSayisi = eskiSayi.toDouble() + yeniSayi.toDouble()
            }
            SonucGoster.text = sonucSayisi.toString()
            yeniOperator = true
        }
    }

    fun btnAC(view: View) {
        SonucGoster.text = "0"
        eskiSayi = ""
        yeniOperator = true
    }

    fun btnYuzdeTik(view: View) {
        val mevcutSayi = SonucGoster.text.toString()
        if (mevcutSayi.isNotEmpty()) {
            val sayi = mevcutSayi.toDouble()
            val yuzdeSonucu = sayi / 100
            SonucGoster.text = yuzdeSonucu.toString()
        }
    }
}