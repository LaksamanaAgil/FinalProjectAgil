package com.example.appcatatanagil
import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.room.*

// annotation for dao class.
@Dao
interface DaoCatatan {
    // below is the insert method for
    // adding a new entry to our database.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note :EntityCatatan)

    // below is the delete method
    // for deleting our note.
    @Delete
    suspend fun delete(note: EntityCatatan)

    // below is the method to read all the notes
    // from our database we have specified the query for it.
    // inside the query we are arranging it in ascending
    // order on below line and we are specifying
    // the table name from which
    // we have to get the data.
    @Query("Select * from TabelCatatan order by id ASC")
    fun getAllNotes(): LiveData<List<EntityCatatan>>

    // below method is use to update the note.
    @Update
    suspend fun update(note: EntityCatatan)
}