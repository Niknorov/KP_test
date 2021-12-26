package com.example.sequenia_test_task.feature.filmInfo.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.sequenia_test_task.R
import com.example.sequenia_test_task.databinding.FragmentFilmInfoBinding
import com.squareup.picasso.Picasso


class FilmInfoFragment : Fragment() {

    private val args by navArgs<FilmInfoFragmentArgs>()
    private lateinit var binding: FragmentFilmInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFilmInfoBinding.inflate(layoutInflater)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        binding.toolbar.setNavigationOnClickListener{ requireActivity().onBackPressed() }

        binding.description.text = args.filmModel.description
        binding.name.text = args.filmModel.name
        binding.rating.text = args.filmModel.rating.toString()
        binding.rating.text = getString(R.string.rating, args.filmModel.rating)
        binding.year.text = getString(R.string.year, args.filmModel.year)
        binding.toolbar.title = args.filmModel.localizedName

        Picasso.get().load(args.filmModel.imageUrl).into(binding.filmImage)

    }
}