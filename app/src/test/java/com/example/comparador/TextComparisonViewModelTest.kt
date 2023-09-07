package com.example.comparador

import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class MainActivityTest {

    @Mock
    private lateinit var viewModel: TextComparisonViewModel

    private lateinit var activity: MainActivity
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var compareButton: Button
    private lateinit var resultTextView: TextView

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        activity = MainActivity()

        editText1 = activity.findViewById(R.id.editText1)
        editText2 = activity.findViewById(R.id.editText2)
        compareButton = activity.findViewById(R.id.compareButton)
        resultTextView = activity.findViewById(R.id.resultTextView)

        activity.viewModel = viewModel // Asignar el viewModel a la actividad
    }

    @Test
    fun testCompararTextos() {
        val texto1 = "Hola"
        val texto2 = "Hola Mundo"
        val expectedResult = "Los textos son diferentes."

        `when`(viewModel.compararTextos(texto1, texto2)).thenReturn(expectedResult)

        editText1.setText(texto1)
        editText2.setText(texto2)

        compareButton.performClick()

        val actualResult = resultTextView.text.toString()

        assert(actualResult == expectedResult)
    }
}
