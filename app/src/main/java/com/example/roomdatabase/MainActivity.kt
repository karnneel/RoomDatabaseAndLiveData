package com.example.roomdatabase

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.LinearLayout.VERTICAL
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.roomdatabase.adapters.FilmsAdapter
import com.example.roomdatabase.databinding.ActivityMainBinding
import com.example.roomdatabase.viewmodel.FilmsViewModel


class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding
    private lateinit var filmsViewModel: FilmsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        filmsViewModel = ViewModelProvider(this).get(FilmsViewModel::class.java)
        mainBinding.progressBar.visibility = View.VISIBLE
        val itemDecor = DividerItemDecoration(this, VERTICAL)
        mainBinding.facilities.addItemDecoration(itemDecor)
        filmsViewModel.getAllFilms(this@MainActivity).observe(this@MainActivity, Observer { films ->
            if (null != films) {

                Handler().postDelayed({
                    mainBinding.progressBar.visibility = View.GONE
                    mainBinding.allFilmAdapter = FilmsAdapter(
                        this@MainActivity,
                        films as MutableList<Films>
                    )
                }, 5000)

            }
        })
    }
}