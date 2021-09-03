package by.vfdev.rickandmorty.UI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.vfdev.rickandmorty.R
import by.vfdev.rickandmorty.RemoteModel.Character
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*

class CharacterAdapter (val character: MutableList<Character>, val fragment: CharacterListFragment):
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name = itemView.findViewById<TextView>(R.id.tvNameCharacter)

        fun image(character: Character) {
            with(itemView) {
                Glide.with(this)
                    .load(character.image)
                    .into(imgCharacter)
                tvName.text = character.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_layout, parent, false)
        val holder = CharacterViewHolder(itemView)

        holder.itemView.setOnClickListener {
            fragment.showDetails(holder.adapterPosition)
        }

        return holder
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = character[position]
        holder.image(character)
    }

    override fun getItemCount(): Int {
        return character.size
    }
}
