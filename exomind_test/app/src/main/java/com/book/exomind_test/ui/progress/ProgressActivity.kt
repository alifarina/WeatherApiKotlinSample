package com.book.exomind_test.ui.progress

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.book.exomind_test.R

class ProgressActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ProgressFragment.newInstance())
                    .commitNow()
        }
    }
}