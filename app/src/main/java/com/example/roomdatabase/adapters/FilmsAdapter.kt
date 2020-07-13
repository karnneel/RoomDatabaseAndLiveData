package com.example.roomdatabase.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.BR
import com.example.roomdatabase.Films
import com.example.roomdatabase.R
import com.example.roomdatabase.databinding.AllFilmRowItemLayoutBinding

class FilmsAdapter(
    private val mContext: Context,
    private var mFilmsList: MutableList<Films>
) : RecyclerView.Adapter<FilmsAdapter.AllFilmsListMainDataHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllFilmsListMainDataHolder {
        val holder: FilmsHolder
        val binding: AllFilmRowItemLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.all_film_row_item_layout, parent, false
        )
        holder = FilmsHolder(binding)
        return holder
    }

    override fun getItemCount(): Int {
        return mFilmsList.size
    }

    override fun onBindViewHolder(holder: AllFilmsListMainDataHolder, position: Int) {
        val filmsHolder = holder as FilmsHolder
        filmsHolder.bindData(mFilmsList[position])
    }

    open inner class AllFilmsListMainDataHolder(v: View?) : RecyclerView.ViewHolder(v!!)

    inner class FilmsHolder(var rowItemLayoutBinding: AllFilmRowItemLayoutBinding) :
        AllFilmsListMainDataHolder(rowItemLayoutBinding.root) {
        fun bindData(films: Films) {
            rowItemLayoutBinding.setVariable(BR.filmItem, films)
            rowItemLayoutBinding.executePendingBindings()
        }

    }
}