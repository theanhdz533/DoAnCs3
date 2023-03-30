package com.example.conquertheexam.offline

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.io.File
import java.io.FileOutputStream

class  ConnectDB(private val context: Context): SQLiteOpenHelper(context, DB_Name,null,1) {
    companion object{
        private val DB_Name = "DB_Exam.db"
    }
    fun openDatabase(): SQLiteDatabase {
        val dbFile = context.getDatabasePath(DB_Name)
        val file = File(dbFile.toString())
        if (file.exists()){
            // neu file ton tai thi khong lam gi het
            Log.e("tag","file exists!")
        }
        else {
            copyDatabase(dbFile)
        }
        return SQLiteDatabase.openDatabase(dbFile.path,null, SQLiteDatabase.OPEN_READWRITE)


    }

    private fun copyDatabase(dbFile: File?) {
        // open database
        val openDB = context.assets.open(DB_Name)


        // open file and put data
        val outputStream = FileOutputStream(dbFile)
        val buffer = ByteArray(1024)

        // read data
        while (openDB.read(buffer)>0){
            outputStream.write(buffer)
            Log.wtf("tag","Writing.....")
        }

        // put data
        outputStream.flush()
//        outputStream.close()
//        openDB.close()
        Log.wtf("tag","Finshed!")

    }

    override fun onCreate(db: SQLiteDatabase?) {

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}