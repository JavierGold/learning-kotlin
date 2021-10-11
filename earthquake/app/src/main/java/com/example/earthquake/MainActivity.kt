package com.example.earthquake

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.earthquake.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.eqRecycler.layoutManager = LinearLayoutManager(this)

        val eqList = mutableListOf<Earthquake>()

        eqList.add(Earthquake("1","57 km E of NY",4.3,273845126,-102.4756,28.47365))
        eqList.add(Earthquake("2","80 km E of NJ",4.6,273845126,-102.4756,28.47365))
        eqList.add(Earthquake("3","78 km E of YN",4.4,273845126,-102.4756,28.47365))

        val adapter = EqAdapter()
        binding.eqRecycler.adapter = adapter
        adapter.submitList(eqList)
    }
}