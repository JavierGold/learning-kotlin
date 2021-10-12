package com.example.earthquake.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.earthquake.R
import com.example.earthquake.api.ApiResponseStatus
import com.example.earthquake.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.eqRecycler.layoutManager = LinearLayoutManager(this)

        val sortType = getSortType()

        viewModel = ViewModelProvider(this,
            MainViewModelFactory(application,sortType)).get(MainViewModel::class.java)

        val adapter = EqAdapter()
        binding.eqRecycler.adapter = adapter

        viewModel.eqList.observe(this, Observer {
            eqList->
            adapter.submitList(eqList)

            if (eqList.isEmpty()){
                binding.eqEmptyView.visibility = View.VISIBLE
            }else{
                binding.eqEmptyView.visibility = View.GONE
            }
        })


        viewModel.status.observe(this, Observer {
            apiResponseStatus ->
            if (apiResponseStatus == ApiResponseStatus.LOADING){
                binding.loadingWheel.visibility= View.VISIBLE
            }else if(apiResponseStatus == ApiResponseStatus.DONE){
                binding.loadingWheel.visibility= View.GONE
            }else if(apiResponseStatus == ApiResponseStatus.ERROR){
                binding.loadingWheel.visibility= View.GONE
            }
        })

        adapter.onItemClickListener = {
            Toast.makeText(this, it.place, Toast.LENGTH_SHORT).show()
        }

    }

    private fun getSortType(): Boolean {
        val prefs = getPreferences(MODE_PRIVATE)
        return prefs.getBoolean("sort_type", false)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val itemId = item.itemId
        if(itemId== R.id.main_menu_sort_magnitude){
            viewModel.reloadEarthquakesFromDb(true)
            saveSortType(true)
        }else if(itemId== R.id.main_menu_sort_time){
            viewModel.reloadEarthquakesFromDb(false)
            saveSortType(false)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun saveSortType(sortByMagnitude:Boolean){
        val prefs = getPreferences(MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putBoolean("sort_type" , sortByMagnitude)
        editor.apply()
    }
}