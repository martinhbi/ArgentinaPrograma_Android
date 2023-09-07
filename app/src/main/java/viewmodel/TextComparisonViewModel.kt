package com.example.comparador
import androidx.lifecycle.ViewModel;



class TextComparisonViewModel : ViewModel() {
    fun compararTextos(text1: String, text2: String): String {
        return if (text1 == text2) {
            "Los textos son iguales."
        } else {
            "Los textos son diferentes."
        }
    }
}
