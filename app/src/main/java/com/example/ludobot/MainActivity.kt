package com.example.ludobot

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.provider.Settings
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(60, 60, 60, 60)
            setBackgroundColor(Color.parseColor("#0F172A"))
        }

        val title = TextView(this).apply {
            text = "LUDO BOT PRO"
            textSize = 24f
            setTextColor(Color.parseColor("#10B981"))
            gravity = Gravity.CENTER
            setPadding(0, 20, 0, 50)
        }
        layout.addView(title)

        val statusText = TextView(this).apply {
            text = "حالة البوت: في انتظار التفعيل 🔴"
            textSize = 16f
            setTextColor(Color.parseColor("#E2E8F0"))
            setPadding(0, 20, 0, 40)
        }
        layout.addView(statusText)

        val btnAccessibility = Button(this).apply {
            text = "تفعيل صلاحيات الأوامر التلقائية"
            setBackgroundColor(Color.parseColor("#3B82F6"))
            setTextColor(Color.parseColor("#FFFFFF"))
            setPadding(20, 30, 20, 30)
            setOnClickListener {
                val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
                startActivity(intent)
            }
        }
        layout.addView(btnAccessibility)

        val switchAuto = Switch(this).apply {
            text = "تشغيل محرك اللعب التلقائي"
            setTextColor(Color.parseColor("#FFFFFF"))
            textSize = 18f
            setPadding(0, 60, 0, 40)
            setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    statusText.text = "حالة البوت: يعمل بنجاح وكفاءة 🟢"
                    Toast.makeText(this@MainActivity, "تم تفعيل الأوامر بنجاح!", Toast.LENGTH_SHORT).show()
                } else {
                    statusText.text = "حالة البوت: متوقف 🔴"
                    Toast.makeText(this@MainActivity, "تم إيقاف البوت.", Toast.LENGTH_SHORT).show()
                }
            }
        }
        layout.addView(switchAuto)

        setContentView(layout)
    }
}
