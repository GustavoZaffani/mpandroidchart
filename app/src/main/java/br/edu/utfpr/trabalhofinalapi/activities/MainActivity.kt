package br.edu.utfpr.trabalhofinalapi.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import br.edu.utfpr.trabalhofinalapi.R

class MainActivity : AppCompatActivity() {

    private lateinit var btLineChart: Button
    private lateinit var btBarChart: Button
    private lateinit var btPieChart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btLineChart = findViewById(R.id.btLineChart)
        btBarChart = findViewById(R.id.btBarChart)
        btPieChart = findViewById(R.id.btPieChart)

        btLineChart.setOnClickListener { onClickLineChartButton() }
        btBarChart.setOnClickListener { onClickBarChartButton() }
        btPieChart.setOnClickListener { onClickPieChartButton() }
    }

    private fun onClickLineChartButton() {
        startActivity(Intent(this, LineChartActivity::class.java))
    }

    private fun onClickBarChartButton() {
        startActivity(Intent(this, BarChartActivity::class.java))
    }

    private fun onClickPieChartButton() {
        startActivity(Intent(this, PieChartActivity::class.java))
    }
}