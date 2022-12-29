package com.example.appcatatanagil
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// TODO: MEMBUAT TABEL BARU
@Entity(tableName = "TabelCatatan")

// TODO: MENSPESIFIKASI VARIABEL KOLOM TABEL DAN NAMA VARIABELNYA
class EntityCatatan (@ColumnInfo(name = "judul")val judulCatatan :String,@ColumnInfo(name = "deskripsi")val deskripsiCatatan :String,@ColumnInfo(name = "timestamp")val timeStamp :String) {
    //TODO: MENSPESIFIKASI PRIMARY KEY DAN SET MENJADI AUTOGENERATE/GENERATE OTOMATIS, DAN MENETAPKAN VALUE DEFAULT MENJADI 0
    @PrimaryKey(autoGenerate = true) var id = 0
}