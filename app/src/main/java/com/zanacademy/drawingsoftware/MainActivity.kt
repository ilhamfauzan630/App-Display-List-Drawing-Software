package com.zanacademy.drawingsoftware

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvDrawingSorftware: RecyclerView
    private val list = ArrayList<DrawingSoftware>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvDrawingSorftware = findViewById(R.id.rv_DrawingSoftware)
        rvDrawingSorftware.setHasFixedSize(true)

        list.addAll(getListDrawingSoftware())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_profile -> {
                val moveIntent = Intent(this@MainActivity, Profile::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListDrawingSoftware(): ArrayList<DrawingSoftware> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

        val listDrawingSoftware = ArrayList<DrawingSoftware>()
        for (i in dataName.indices) {
            val drawingSoftware = DrawingSoftware(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listDrawingSoftware.add(drawingSoftware)
        }
        return listDrawingSoftware
    }

    private fun showRecyclerList() {
        rvDrawingSorftware.layoutManager = LinearLayoutManager(this)
        val listDrawingSoftwareAdapter = ListDrawingSoftwareAdapter(list)
        rvDrawingSorftware.adapter = listDrawingSoftwareAdapter

        listDrawingSoftwareAdapter.setOnItemClickCallback(object : ListDrawingSoftwareAdapter.OnItemClickCallback {
            override fun onItemClicked(data: DrawingSoftware) {
                showSelectedDrawingSoftware(data)
            }
        })
    }

    private fun showSelectedDrawingSoftware(drawingSoftware: DrawingSoftware) {
        Toast.makeText(this, "Kamu memilih " + drawingSoftware.name, Toast.LENGTH_SHORT).show()
    }
}