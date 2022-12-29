package com.example.appcatatanagil
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class AdapterCatatan(
    val context: Context,
    val noteClickDeleteInterface: NoteClickDeleteInterface,
    val noteClickInterface: NoteClickInterface
) :
    RecyclerView.Adapter<AdapterCatatan.ViewHolder>() {

    //TODO: MEMBUAT VARIABEL UNTUK LIST CATATAN
    private val allNotes = ArrayList<EntityCatatan>()

    // TODO: MEMBUAT CLASS VIEW HOLDER
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //TODO : INISIALISASI VARIABEL DALAM FILE LAYOUT
        val noteTV = itemView.findViewById<TextView>(R.id.idTVNote)
        val dateTV = itemView.findViewById<TextView>(R.id.idTVDate)
        val deleteIV = itemView.findViewById<ImageView>(R.id.idIVDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //TODO: MEMPERBESAR FILE LAYOUT UNTUK SETIAP ITEM RECYCLER VIEW
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.catatan_rv_item,
            parent, false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //TODO: MENYETTING DATA KE ITEM RECYLER VIEW
        holder.noteTV.setText(allNotes.get(position).judulCatatan)
        holder.dateTV.setText("Last Updated : " + allNotes.get(position).timeStamp)
        // TODO: MENAMBAHKAN CLICK LISTENER KE TOMBOL DELETE
        holder.deleteIV.setOnClickListener {
            noteClickDeleteInterface.onDeleteIconClick(allNotes.get(position))
        }

        // TODO: MENAMBAHKAN CLICK LISTENER KE ITEM RECYCLER VIEW
        holder.itemView.setOnClickListener {
            noteClickInterface.onNoteClick(allNotes.get(position))
        }
    }

    override fun getItemCount(): Int {
        //TODO: RETURN LIST SIZE
        return allNotes.size
    }

    // TODO: METHOD UNTUK MENGUPDATE LIST CATATAN
    fun updateList(newList: List<EntityCatatan>) {
        //TODO: MENGHAPUS LIST CATATAN
        allNotes.clear()
        //TODO: MENAMBAH LIST BARU
        allNotes.addAll(newList)
        //TODO: MEMANGGIL NOTIFY DATA UNTUK MENOTIFIKASI ADAPTER
        notifyDataSetChanged()
    }
}

interface NoteClickDeleteInterface {
    //TODO: METHOD UNTUK AKSI KLIK IKON DELETE
    fun onDeleteIconClick(note: EntityCatatan)
}

interface NoteClickInterface {
    //TODO: METHOD UNTUK AKSI KLIK IKON UPDATE
    fun onNoteClick(note: EntityCatatan)
}