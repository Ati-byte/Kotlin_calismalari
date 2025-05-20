package com.example.odev7.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.odev7.model.ToDoModel


class ToDoDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "todo.db"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "toDos"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = """
            CREATE TABLE $TABLE_NAME (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_NAME TEXT
            );
        """.trimIndent()
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun getAll(): List<ToDoModel> {
        val list = mutableListOf<ToDoModel>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID))
                val name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME))
                list.add(ToDoModel(id, name))
            } while (cursor.moveToNext())
        }
        cursor.close()
        return list
    }

    fun search(query: String): List<ToDoModel> {
        val list = mutableListOf<ToDoModel>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME WHERE $COLUMN_NAME LIKE ?", arrayOf("%$query%"))

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID))
                val name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME))
                list.add(ToDoModel(id, name))
            } while (cursor.moveToNext())
        }
        cursor.close()
        return list
    }

    fun add(name: String) {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NAME, name)
        }
        db.insert(TABLE_NAME, null, values)
    }

    fun delete(id: Int) {
        val db = writableDatabase
        db.delete(TABLE_NAME, "$COLUMN_ID=?", arrayOf(id.toString()))
    }

    fun update(id: Int, name: String) {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NAME, name)
        }
        db.update(TABLE_NAME, values, "$COLUMN_ID=?", arrayOf(id.toString()))
    }
}
