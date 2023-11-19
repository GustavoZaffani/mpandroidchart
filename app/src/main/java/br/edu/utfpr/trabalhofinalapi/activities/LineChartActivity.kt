package br.edu.utfpr.trabalhofinalapi.activities

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.utfpr.trabalhofinalapi.R
import br.edu.utfpr.trabalhofinalapi.formatters.CurrencyFormatter
import br.edu.utfpr.trabalhofinalapi.formatters.FirstQuarterFormatter
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet

class LineChartActivity : AppCompatActivity() {

    private lateinit var lineChart: LineChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_line_chart)

        lineChart = findViewById(R.id.lineChart)

        createLineChart()
    }

    private fun createLineChart() {
        val lineDataSet1 = LineDataSet(getEntryValues1(), "Alfredo")
        lineDataSet1.setColor(Color.BLUE, 255)
        setDefaultConfigsLineDataSet(lineDataSet1)

        val lineDataSet2 = LineDataSet(getEntryValues2(), "Astolfo")
        lineDataSet2.setColor(Color.RED, 255)
        setDefaultConfigsLineDataSet(lineDataSet2)

        lineChart.data = LineData(arrayListOf<ILineDataSet>(lineDataSet1, lineDataSet2))
        lineChart.description = getDescriptionChart()
        buildXAxis(lineChart.xAxis)
        buildLegend(lineChart.legend)

        lineChart.invalidate()
    }

    private fun setDefaultConfigsLineDataSet(lineDataSet: LineDataSet) {
        lineDataSet.valueFormatter = CurrencyFormatter()
        lineDataSet.valueTextSize = 14f
        lineDataSet.circleRadius = 5f
    }

    private fun buildXAxis(xAxis: XAxis) {
        xAxis.valueFormatter = FirstQuarterFormatter()
        xAxis.granularity = 1f
        xAxis.textSize = 12f
    }

    private fun getDescriptionChart(): Description {
        val description = Description()
        description.text = "Comparativo de vendas do trimestre"
        description.textSize = 16f
        description.textColor = Color.BLACK

        return description
    }

    private fun buildLegend(legend: Legend) {
        legend.textColor = Color.BLACK
        legend.textSize = 16f
        legend.form = Legend.LegendForm.LINE
    }

    private fun getEntryValues1(): MutableList<Entry> {
        return mutableListOf(
            Entry(0f, 1500f),
            Entry(1f, 2542f),
            Entry(2f, 1674f)
        )
    }

    private fun getEntryValues2(): MutableList<Entry> {
        return mutableListOf(
            Entry(0f, 2015f),
            Entry(1f, 2365f),
            Entry(2f, 1400f)
        )
    }
}