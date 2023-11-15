package br.edu.utfpr.trabalhofinalapi.formatters

import com.github.mikephil.charting.formatter.ValueFormatter
import java.text.NumberFormat

class PieFormatter : ValueFormatter() {

    override fun getFormattedValue(value: Float): String {
        return NumberFormat.getCurrencyInstance().format(value)
    }
}