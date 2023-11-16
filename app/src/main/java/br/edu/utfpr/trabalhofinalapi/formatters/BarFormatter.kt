package br.edu.utfpr.trabalhofinalapi.formatters

import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.formatter.ValueFormatter

class BarFormatter : ValueFormatter() {

    private val days = arrayOf("Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab")

    override fun getFormattedValue(value: Float): String {
        return days.getOrNull(value.toInt()) ?: value.toString()
    }
}