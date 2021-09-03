package by.vfdev.rickandmorty.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import by.vfdev.rickandmorty.R
import by.vfdev.rickandmorty.ViewModel.CharacterViewModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_details.*
import kotlinx.android.synthetic.main.item_layout.*
import kotlinx.android.synthetic.main.item_layout.view.*

class DetailsFragment : Fragment() {

    lateinit var viewModel: CharacterViewModel
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        viewModel = ViewModelProvider(activity as MainActivity).get(CharacterViewModel::class.java)

        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()

        Glide.with(this)
                .load(viewModel.characterList?.image)
                .into(imgCharacterDetails)

        tvNameCharacter.text = viewModel.characterList?.name ?: "Unknown"
        tvGender.text = viewModel.characterList?.gender ?: "Unknown"
        tvSpecies.text = viewModel.characterList?.species ?: "Unknown"
        tvStatus.text = viewModel.characterList?.status ?: "Unknown"
        tvType.text = viewModel.characterList?.type ?: "Unknown"
    }
}