package com.example.comparador

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TextComparisonViewModelTest {

    private lateinit var viewModel: TextComparisonViewModel

    @Before
    fun setup() {
        viewModel = TextComparisonViewModel()
    }

    @Test
    fun testCompararTextos() {
        val texto1 = "Hola"
        val texto2 = "Hola Mundo"
        val expectedResult = "Los textos son diferentes."

        val actualResult = viewModel.compararTextos(texto1, texto2)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun testCompararTextosIguales() {
        val texto1 = "Hola"
        val texto2 = "Hola"
        val expectedResult = "Los textos son iguales."

        val actualResult = viewModel.compararTextos(texto1, texto2)

        assertEquals(expectedResult, actualResult)
    }
}