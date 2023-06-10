package com.emircankirez.multityperecyclerviewdifferentdataclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.emircankirez.multityperecyclerviewdifferentdataclass.adapter.ItemAdapter
import com.emircankirez.multityperecyclerviewdifferentdataclass.data.DummyData
import com.emircankirez.multityperecyclerviewdifferentdataclass.model.Model
import com.emircankirez.multityperecyclerviewdifferentdataclass.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ItemAdapter.OnItemClickListener {
    private lateinit var binding : ActivityMainBinding
    private lateinit var itemList : ArrayList<Model>
    private lateinit var adapter : ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemList = DummyData.getData()
        binding.rvItems.layoutManager = LinearLayoutManager(this)
        adapter = ItemAdapter(itemList, this)
        binding.rvItems.adapter = adapter
    }

    override fun onItemClick(position: Int) {
        val item = itemList[position]
        when(item){
            is Model.Film -> {
                Toast.makeText(this@MainActivity, item.content, Toast.LENGTH_LONG).show()
            }

            is Model.Ad -> {
                Toast.makeText(this@MainActivity, "You clicked an ad!", Toast.LENGTH_LONG).show()
            }
        }
    }
}