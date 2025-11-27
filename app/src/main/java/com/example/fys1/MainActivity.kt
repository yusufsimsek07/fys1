package com.example.fys1

import android.content.Context
import android.net.wifi.WifiManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var txtWifi: TextView
    private lateinit var btnOku: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtWifi = findViewById(R.id.txtWifi)
        btnOku = findViewById(R.id.btnOku)

        // Uygulama açıldığında mevcut Wi-Fi durumunu göster
        wifiDurumunuGoster()

        btnOku.setOnClickListener {
            // Butona basıldığında Wi-Fi durumunu yeniden oku
            wifiDurumunuGoster()
        }
    }

    private fun wifiDurumunuGoster() {
        val wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager

        val durum = if (wifiManager.isWifiEnabled) "WiFi AÇIK" else "WiFi KAPALI"

        txtWifi.text = durum
    }
}
