package com.example.likemypost

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.prefs.AbstractPreferences

class MainActivity : AppCompatActivity() {

    var up:Int= 0
    var down:Int = 0
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = this.getPreferences(Context.MODE_PRIVATE)
        Log.d("MainActivity", "onCreate")



        imageView.setOnClickListener {
            up++;
            textViewLike.text = up.toString()
        }

        imageView2.setOnClickListener {
            down++;
            textViewDislike.text = down.toString()
        }


    }

    override fun onPause() {
        Log.d("MainActivity", "onPause")
        with(sharedPreferences.edit()){
            putInt(getString(R.string.up), up)
            putInt(getString(R.string.down), down)
            apply()
        }
        super.onPause()

    }

    override fun onDestroy() {
        Log.d("MainActivity","onDestroy")
        super.onDestroy()
    }

    override fun onResume() {
        Log.d("MainActivity","onResume")
        //Retrieve counters from the shared preference
        up = sharedPreferences.getInt(getString(R.string.up), 0)
        down = sharedPreferences.getInt(getString(R.string.down), 0)

        textViewLike.text = up.toString()
        textViewDislike.text = down.toString()
        super.onResume()
    }

    override fun onStop() {
        Log.d("MainActivity","onStop")
        super.onStop()
    }

    override fun onStart() {
        Log.d("MainActivity","onStart")
        super.onStart()
    }
}
