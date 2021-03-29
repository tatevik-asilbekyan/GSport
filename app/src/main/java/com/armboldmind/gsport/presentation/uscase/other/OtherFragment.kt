package com.armboldmind.gsport.presentation.uscase.other

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.armboldmind.gsport.R

class OtherFragment : Fragment() {

    private lateinit var otherViewModel: OtherViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        otherViewModel =
                ViewModelProvider(this).get(OtherViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_other, container, false)
        val textView: TextView = root.findViewById(R.id.text_other)
        otherViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        return root
    }
}