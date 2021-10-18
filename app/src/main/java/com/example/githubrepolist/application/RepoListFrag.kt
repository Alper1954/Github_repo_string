package com.example.githubrepolist.application

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.githubrepolist.R
import com.example.githubrepolist.databinding.FragmentRepoListBinding

class RepoListFrag : Fragment() {

    private val viewModel: RepoModel by viewModels()

    private lateinit var binding:FragmentRepoListBinding
    private var user:String? = null


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        arguments?.let{
            user = it.getString("user")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRepoListBinding.inflate(inflater, container, false)
        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel

        viewModel.getUserRepositoriesPhotos(user as String)

        return binding.root
    }


}