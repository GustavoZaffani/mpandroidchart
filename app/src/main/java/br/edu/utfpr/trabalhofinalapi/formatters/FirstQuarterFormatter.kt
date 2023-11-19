package br.edu.utfpr.trabalhofinalapi.formatters

import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.formatter.ValueFormatter

class FirstQuarterFormatter : ValueFormatter() {

    private val months = arrayOf("Jan", "Fev", "Mar")

    override fun getAxisLabel(value: Float, axis: AxisBase?): String {
        return months.getOrNull(value.toInt()) ?: value.toString()
    }
}