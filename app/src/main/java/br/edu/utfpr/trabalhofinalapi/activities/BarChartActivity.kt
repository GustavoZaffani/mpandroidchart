package br.edu.utfpr.trabalhofinalapi.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.utfpr.trabalhofinalapi.R
import br.edu.utfpr.trabalhofinalapi.formatters.WeekFormatter
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate

class BarChartActivity : AppCompatActivity() {

    private lateinit var barChart: BarChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bar_chart)

        barChart = findViewById(R.id.barChart)

        createBarChart()
    }

    private fun createBarChart() {
        val barDataSet = BarDataSet(getBarEntryValues(), "Vendas semanais")
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS, 255)
        barDataSet.valueTextSize = 18f

        barChart.data = BarData(barDataSet)
        barChart.description.isEnabled = false
        barChart.legend.isEnabled = false
        barChart.setFitBars(true)
        barChart.animateY(1500)

        buildXAxis(barChart.xAxis)

        barChart.invalidate()
    }

    private fun buildXAxis(xAxis: XAxis) {
        xAxis.valueFormatter = WeekFormatter()
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.textSize = 12f
    }

    private fun getBarEntryValues(): MutableList<BarEntry> {
        return mutableListOf(
            BarEntry(0f, 15f),
            BarEntry(1f, 1f),
            BarEntry(2f, 10f),
            BarEntry(3f, 18f),
            BarEntry(4f, 7f),
            BarEntry(5f, 6f),
            BarEntry(6f, 12f),
        )
    }
}