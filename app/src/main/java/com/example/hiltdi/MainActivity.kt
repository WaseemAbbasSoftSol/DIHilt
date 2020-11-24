package com.example.hiltdi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mAdapter: SampleAdapter

    private val mViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val count = mAdapter.getItemsCount().toString()
        Log.d(APP_TAG, count)
        val field = findViewById<TextView>(R.id.txt)
        field.text = "adapter count = ${mViewModel.getCount()}"

        mViewModel.data.observe(this, {
            Toast.makeText(this, it.title, Toast.LENGTH_SHORT).show()
            field.text = it.toString()
        })

    }
}