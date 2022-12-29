package com.example.appcatatanagil

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel (application: Application) :AndroidViewModel(application) {

    //TODO: MENGINISIALISASI LIST CATATAN DAN REPOSITORY
    val allNotes : LiveData<List<EntityCatatan>>
    val repository : RepositoryCatatan

    //TODO: MENGINISIALISASI DAO, REPOSITORY BESERTA SEMUA CATATAN DI DATABASE
    init {
        val dao = DatabaseCatatan.getDatabase(application).getNotesDao()
        repository = RepositoryCatatan(dao)
        allNotes = repository.allNotes
    }

    //TODO: MEMBUAT METHOD BARU UNTUK MENGHAPUS SEBUAH CATATAN DARI DATABASE
    fun deleteNote (note: EntityCatatan) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(note)
    }

    //TODO: MEMBUAT METHOD BARU UNTUK MENGUPDATE SEBUAH CATATAN DIDALAM DATABASE
    fun updateNote(note: EntityCatatan) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(note)
    }

    //TODO: MEMBUAT METHOD BARU UNTUK MENAMBAHKAN SEBUAH CATATAN KEDATABASE
    fun addNote(note: EntityCatatan) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(note)
    }
}