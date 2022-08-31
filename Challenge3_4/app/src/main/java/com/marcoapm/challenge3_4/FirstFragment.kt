package com.marcoapm.challenge3_4

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class FirstFragment : Fragment(R.layout.fragment_first) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_next).setOnClickListener {
            val textInfo = view.findViewById<EditText>(R.id.edittext_info).text.toString()

            parentFragmentManager.beginTransaction()
                .add(R.id.fragment_container_view, SecondFragment.newInstance(textInfo))
                .addToBackStack(null)
                .commit()
        }

    }
}