package com.example.movie_project

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import biz.filmeroo.premier.mywork.model.Movie_Model
import com.example.movie_project.adapter.MovieAdapter
import com.example.movie_project.api.movie_api
import com.example.movie_project.api.movie_interface
import com.example.movie_project.utilities.RxUtils
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription

class MainActivity : AppCompatActivity() {

    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: MovieAdapter? = null
    private var pDialog: ProgressDialog? = null
    private var _subscriptions = CompositeSubscription()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_main)

        initialRecyclerView()
        intialaizeProgress()
        displayMovieList()
    }

    fun displayMovieList() {
        val apiService: movie_interface = movie_api.getMovi_Services().create(movie_interface::class.java)
        apiService.getTopRated(movie_api.APIKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Movie_Model> {
                    override fun onSubscribe(d: Disposable) {}
                    override fun onNext(movie_model: Movie_Model) {
                        if (mRecyclerView != null) {
                            val allMovies: List<Movie_Model> = movie_model.getResults()
                            mAdapter = MovieAdapter(allMovies, R.layout.card_row, applicationContext)
                            mRecyclerView!!.setAdapter(mAdapter)
                            hidePDialog()
                        }
                    }

                    override fun onError(e: Throwable) {
                        hidePDialog()
                        Log.d("Error", e.message!!)
                    }

                    override fun onComplete() {}
                })
    }

    override fun onResume() {
        super.onResume()
        _subscriptions = RxUtils.getNewCompositeSubIfUnsubscribed(_subscriptions)
    }

    override fun onPause() {
        super.onPause()
        RxUtils.unsubscribeIfNotNull(_subscriptions)
    }

    override fun onDestroy() {
        super.onDestroy()
        hidePDialog()
    }

    fun initialRecyclerView() {
        mRecyclerView = findViewById<View>(R.id.list) as RecyclerView
        mRecyclerView!!.setLayoutManager(LinearLayoutManager(this))
        mRecyclerView!!.setItemAnimator(DefaultItemAnimator())
    }

    fun intialaizeProgress() {
        pDialog = ProgressDialog(this)
        pDialog!!.setMessage("Loading...")
        pDialog!!.show()
    }

    private fun hidePDialog() {
        if (pDialog != null) {
            pDialog!!.dismiss()
            pDialog = null
        }
    }
}