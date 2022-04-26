package com.example.movie_project.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import biz.filmeroo.premier.mywork.model.Movie_Model
import com.bumptech.glide.Glide
import com.example.movie_project.R
import com.example.movie_project.utilities.ItemClickListener

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {


    private var movieList: List<Movie_Model>? = null
    private var rowLayout = 0
    private var context: Context? = null

    fun MovieAdapter(movieList: List<Movie_Model>?, rowLayout: Int, context: Context?) {
        this.movieList = movieList
        this.rowLayout = rowLayout
        this.context = context
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(rowLayout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movieList!![position]
        holder.MovieName.setText(movie.original_title)
        Glide.with(context!!)
            .load(movie.id).load(movie.original_language)
            .into(holder.MovieImage)
        holder.setClickListener(object : ItemClickListener {


            override fun onClick(view: View, position: Int, isLongClick: Boolean) {
                if (isLongClick) {
                    Toast.makeText(
                        context,
                        "#" + position + " - " + movie.original_language + " (Long click)",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        context,
                        "#" + position + " - " + movie.original_title,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }

    override fun getItemCount(): Int {
        return if (movieList == null) 0 else movieList!!.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener, OnLongClickListener {
        var MovieName: TextView
        var MovieImage: ImageView
        var versionName: String? = null
        private var clickListener: ItemClickListener? = null
        fun setClickListener(itemClickListener: ItemClickListener?) {
            clickListener = itemClickListener
        }

        override fun onClick(view: View) {
            clickListener!!.onClick(view, position, false)
        }

        override fun onLongClick(view: View): Boolean {
            clickListener!!.onClick(view, position, true)
            return true
        }

        init {
            MovieName = itemView.findViewById<View>(R.id.name) as TextView
            MovieImage = itemView.findViewById<View>(R.id.img) as ImageView
            itemView.tag = itemView
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
        }
    }
}


