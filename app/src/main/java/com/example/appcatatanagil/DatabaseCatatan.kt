package com.example.appcatatanagil
import android.content.Context
import android.content.Entity
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = arrayOf(EntityCatatan::class), version = 1, exportSchema = false)
abstract class DatabaseCatatan : RoomDatabase() {
    abstract fun getNotesDao(): DaoCatatan

    companion object {
        //TODO: SINGLETON BERFUNGSI MENCEGAH MEMBUKANYA LEBIH DARI 1 INSTANSI PADA WAKTU YANG SAMA
        @Volatile
        private var INSTANCE: DatabaseCatatan? = null

        fun getDatabase(context: Context): DatabaseCatatan {
            //TODO: MENGAMBIL DATABASE YANG SUDAH ADA ATAU JIKA BELUM ADA, MEMBUAT SEBUAH DATABASE
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseCatatan::class.java,
                    "note_database"
                ).build()
                INSTANCE = instance
                //TODO: MERETURN INSTANCE
                instance
            }
        }
    }
}