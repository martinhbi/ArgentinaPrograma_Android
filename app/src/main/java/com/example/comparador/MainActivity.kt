package com.example.comparador

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private var editText1: EditText? = null
    private var editText2: EditText? = null
    private var compareButton: Button? = null
    private var resultTextView: TextView? = null
    internal var viewModel: TextComparisonViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText1 = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)
        compareButton = findViewById(R.id.compareButton)
        resultTextView = findViewById(R.id.resultTextView)
        viewModel = ViewModelProvider(this).get(TextComparisonViewModel::class.java)
        compareButton?.setOnClickListener(View.OnClickListener {
            val text1 = editText1?.getText().toString()
            val text2 = editText2?.getText().toString()

            // Llama al método en el ViewModel para comparar los textos
            val resultado: String = viewModel?.compararTextos(text1, text2) ?: ""

            // Muestra el resultado en el TextView
            resultTextView?.setText(resultado)
        })
    }
}
