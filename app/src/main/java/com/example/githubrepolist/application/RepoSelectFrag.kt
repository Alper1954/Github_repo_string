package com.example.githubrepolist.application

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.githubrepolist.R

class RepoSelectFrag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_repo_select, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val button:Button = view.findViewById(R.id.button)
        val spinner:Spinner = view.findViewById(R.id.spinner)
        button.setOnClickListener{
            val action = RepoSelectFragDirections.actionRepoSelectFragToRepoListFrag(user = spinner.selectedItem as String)
            it.findNavController().navigate(action)
        }
    }
}