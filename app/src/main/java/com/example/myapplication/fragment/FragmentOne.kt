package com.example.myapplication.fragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.myapplication.R

class FragmentOne : Fragment(R.layout.fragment_one) {

    private lateinit var editTextAmount: EditText
    private lateinit var buttonSend: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextAmount = view.findViewById(R.id.editTextTextAmount)
        buttonSend = view.findViewById(R.id.buttonSend)

        val navController = Navigation.findNavController(view)

        buttonSend.setOnClickListener {

            val amountText = editTextAmount.text.toString()

            if (amountText.isEmpty()) {
                return@setOnClickListener
            }

            val amount = amountText.toInt()

            val action = FragmentOneDirections.actionHomeFragmentToDashboardFragment2(amount)

            navController.navigate(action)

        }

    }

}