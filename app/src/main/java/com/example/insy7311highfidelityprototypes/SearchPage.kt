package com.example.insy7311highfidelityprototypes

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class SearchPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search_page)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.selectedItemId = R.id.nav_home // change per activity

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, HomePage::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.nav_search -> true
                R.id.nav_message -> {
                    startActivity(Intent(this, MessagePage::class.java))
                    overridePendingTransition(0, 0)
                    true
                }

                R.id.nav_jobs -> {
                    startActivity(Intent(this, JobsPage::class.java))
                    overridePendingTransition(0, 0)
                    true
                }

                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfilePage::class.java))
                    overridePendingTransition(0, 0)
                    true
                }


                else -> false
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}