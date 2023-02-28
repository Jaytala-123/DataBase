package com.jaytala.database

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.jaytala.database.Adapter.StudentsAdapter
import com.jaytala.database.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    lateinit var database: Database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = Database(applicationContext)

        binding.insert.setOnClickListener {
            database.insertData(binding.name.text.toString(), binding.surname.text.toString())
            RetriveDatas(binding)
        }

        binding.retrive.setOnClickListener {
            var dataList = database.Retrivedata()
            for (data in dataList) {

                Log.e("Tag", "onCreate:============"+data.id)
                Log.e("Tag", "onCreate:============"+data.name)
                Log.e("Tag", "onCreate:============"+data.surname)
                Log.e("Tag", "onCreate:=============--------------")

            }
        }
        binding.update.setOnClickListener {
            database.updateData(binding.id.text.toString().toInt(), binding.name.text.toString(), binding.surname.text.toString())
            RetriveDatas(binding)
        }

        binding.delete.setOnClickListener {
            database.DeleteData(binding.id.text.toString().toInt())
            RetriveDatas(binding)
        }

    }

    private fun RetriveDatas(binding: ActivityMainBinding) {
        var dataList = database.Retrivedata()
        binding.student.layoutManager=LinearLayoutManager(applicationContext)
        binding.student.adapter = StudentsAdapter(dataList)

    }
}





