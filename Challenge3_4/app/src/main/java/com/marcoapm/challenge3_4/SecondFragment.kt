package com.marcoapm.challenge3_4

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class SecondFragment : Fragment(R.layout.fragment_second) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textInfo = arguments?.getString(EXTRA_INFO)
        val textView = view.findViewById<TextView>(R.id.textview_info)
        textView.text = textInfo

view.findViewById<Button>(R.id.button_previous).setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    companion object {
        private const val EXTRA_INFO = "extra_info"

        fun newInstance(text: String): SecondFragment {
            val fragment = SecondFragment()
            val bundle = Bundle().apply { putString(EXTRA_INFO, text) }
            fragment.arguments = bundle
            return fragment
        }
    }
}