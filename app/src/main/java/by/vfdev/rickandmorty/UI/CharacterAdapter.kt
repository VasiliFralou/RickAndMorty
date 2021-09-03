package by.vfdev.rickandmorty.UI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.vfdev.rickandmorty.R
import by.vfdev.rickandmorty.RemoteModel.Character

class CharacterAdapter (val character: MutableList<Character>) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = character[position].name
    }

    override fun getItemCount(): Int {
        return character.size
    }

}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name = itemView.findViewById<TextView>(R.id.tvNameCharacter)
}
