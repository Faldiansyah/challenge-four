package com.cowok.hijrah.challenge4.notes
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import android.widget.Toast
//import androidx.recyclerview.widget.RecyclerView
//import com.cowok.hijrah.challenge4.MainActivity
//import com.cowok.hijrah.challenge4.databinding.ItemNoteBinding
//import com.cowok.hijrah.challenge4.fragmentscreen.HomeFragment
//import com.cowok.hijrah.challenge4.notes.NoteData
//import com.cowok.hijrah.challenge4.notes.NoteDatabase
//import kotlinx.coroutines.GlobalScope
//import kotlinx.coroutines.async
//
//class NoteAdapter(var listNote : List<NoteData>): RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
//
//    var DBNote: NoteDatabase? = null
//
//    class ViewHolder(var binding: ItemNoteBinding): RecyclerView.ViewHolder(binding.root) {
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        var view = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.binding.textJudulNote.text = listNote[position].title.toString()
//        holder.binding.textIsiNote.text = listNote[position].content
//
//        holder.binding.imageDelete.setOnClickListener{
//            DBNote = NoteDatabase.getInstance(it.context)
//
//            GlobalScope.async {
//                val del = DBNote?.noteDAO()?.deleteNote(listNote[position])
//                (holder.itemView.context as HomeFragment).getAllNote()
////                        kalau ga pake ini pas hapus bisa, data ga ke update langsung tapi, ga ada note berhasil atau ga
//                (holder.itemView.context as HomeFragment).runOnUiThread {
//                    if (del != 0){
//                        Toast.makeText(it.context, "Data ${listNote[position].id} Success Deleted", Toast.LENGTH_SHORT).show()
////                                ga pake ini data ga ke update
//                        (holder.itemView.context as HomeFragment).getAllNote()
//                    } else {
//                        Toast.makeText(it.context, "Data ${listNote[position].id} Failed to Delete ", Toast.LENGTH_SHORT).show()
//                    }
//                }
//            }
//
//        }
//
//    }
//
//    override fun getItemCount(): Int {
//        return listNote.size
//    }
//}