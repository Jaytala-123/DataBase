package com.jaytala.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class Database(context: Context?) : SQLiteOpenHelper(context, "MyDatabase", null, 1) {
    var context = context
    override fun onCreate(p0: SQLiteDatabase?) {

        var que =
            "CREATE TABLE students(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,surname TEXT)"
        p0?.execSQL(que)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun insertData(name: String, surname: String) {
        var db = writableDatabase
        var value = ContentValues()
        value.put("name", name)
        value.put("surname", surname)

        var iss: Long = db.insert("STUDENTS", null, value)
        if (iss.toInt() == -1) {
            Toast.makeText(context, "DATA insert Failed", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "DATA insert Success", Toast.LENGTH_SHORT).show()
        }

    }

    fun Retrivedata(): ArrayList<StudentModel> {
        var dataList = ArrayList<StudentModel>()
        var db = readableDatabase
        var que = "SELECT * FROM students"
        var cursor: Cursor = db.rawQuery(que, null)
        if (cursor.moveToFirst())
            do {
                var id = cursor.getInt(0)
                var name = cursor.getString(1)
                var surname = cursor.getString(2)
                var model = StudentModel(id, name, surname)
                dataList.add(model)
            } while (cursor.moveToNext())

        return dataList
    }

    fun updateData(id: Int, name: String, surname: String) {
        var db = writableDatabase
        var value = ContentValues()
        value.put("name", name)
        value.put("surname", surname)

        var iss = db.update("STUDENTS", value, "id=$id", null)
        if (iss.toInt()==-1){
            Toast.makeText(context, "DATA is Not Updated", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "DATA is Update Success", Toast.LENGTH_SHORT).show()
        }
    }
    
    fun DeleteData(id:Int){
        var db =writableDatabase
        db.delete("STUDENTS","id="+id,null)
    }
}

