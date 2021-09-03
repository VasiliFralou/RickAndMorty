package by.vfdev.rickandmorty.UI

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import by.vfdev.rickandmorty.R
import by.vfdev.rickandmorty.RemoteModel.Character
import by.vfdev.rickandmorty.ViewModel.CharacterViewModel
import kotlinx.android.synthetic.main.fragment_character_list.*

class CharacterListFragment : Fragment() {

    lateinit var viewModel: CharacterViewModel
    private val character = mutableListOf<Character>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(activity as MainActivity).get(CharacterViewModel::class.java)

        return inflater.inflate(R.layout.fragment_character_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getData()

        viewModel.charactersLive.observe(activity as MainActivity, Observer {
            Log.d("!!!", it.toString())
            character.clear()
            character.addAll(it)
            rvCharacterList.adapter?.notifyDataSetChanged()
        })

        val adapter = CharacterAdapter(character)
        rvCharacterList.adapter = adapter
        rvCharacterList.layoutManager = GridLayoutManager(activity, 1)
    }
}