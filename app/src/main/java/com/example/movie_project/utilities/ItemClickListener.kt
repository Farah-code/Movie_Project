package com.example.movie_project.utilities

import android.view.View

interface ItemClickListener {

    /*
    *
     * @param view
     * @param position
     * @param isLongClick
     */

    fun onClick (view : View, position : Int, isLongClick : Boolean)

}