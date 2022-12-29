package com.example.appcatatanagil

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import java.util.concurrent.Flow

class RepositoryCatatan(private val notesDao: DaoCatatan) {

    //TODO: MEMBUAT VARIABEL UNTUK LIST, SERTA MENGAMBIL CATATAN DARI CLASS DAO
    val allNotes: LiveData<List<EntityCatatan>> = notesDao.getAllNotes()

    //TODO: UNTUK MENAMBAHKAN SEBUAH CATATAN KE DATABASE
    suspend fun insert(note: EntityCatatan) {
        notesDao.insert(note)
    }

    //TODO: METHOD UNTUK MENGHAPUS CATATAN DARI DATABASE
    suspend fun delete(note: EntityCatatan){
        notesDao.delete(note)
    }

    //TODO: MENGUPDATE CATATAN YANG ADA DALAM DATABASE
    suspend fun update(note: EntityCatatan){
        notesDao.update(note)
    }
}