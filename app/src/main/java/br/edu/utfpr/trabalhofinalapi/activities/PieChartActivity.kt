package br.edu.utfpr.trabalhofinalapi.activities

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.utfpr.trabalhofinalapi.R
import br.edu.utfpr.trabalhofinalapi.formatters.PieFormatter
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate

class PieChartActivity : AppCompatActivity() {

    private lateinit var pieChart: PieChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pie_chart)

        pieChart = findViewById(R.id.pieChart)

        createPieChart()
    }

    private fun createPieChart() {
        val pieDataSet = PieDataSet(getPieEntryValues(), "Composição")
        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS, 255)
        pieDataSet.valueTextColor = Color.BLACK
        pieDataSet.valueTextSize = 18f
        pieDataSet.valueFormatter = PieFormatter()
        pieDataSet.label = ""

        pieChart.data = PieData(pieDataSet)

        pieChart.description = getDescriptionChart()
        pieChart.animateY(1500)
        buildLegend(pieChart.legend)

        pieChart.invalidate()
    }

    private fun buildLegend(legend: Legend) {
        legend.textColor = Color.BLACK
        legend.textSize = 16f
        legend.form = Legend.LegendForm.CIRCLE
        legend.isWordWrapEnabled = true
    }

    private fun getPieEntryValues(): MutableList<PieEntry> {
        return mutableListOf(
            PieEntry(9500f, "Salário líquido"),
            PieEntry(2000f, "Impostos"),
            PieEntry(1000f, "Outros descontos")
        )
    }

    private fun getDescriptionChart(): Description {
        val description = Description()
        description.text = "Composição salarial"
        description.textSize = 22f
        description.textColor = Color.BLACK

        return description
    }
}