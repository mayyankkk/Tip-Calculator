package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        val stringInTextField=binding.costOfService.text.toString()
        val cost=stringInTextField.toDouble()
        val tipPercentage= when(binding.tipOptions.checkedRadioButtonId){
            R.id.option_20_percent->.20
            R.id.option_18_percent->.18
            else->.15
        }
        var tip=tipPercentage*cost
        val roundUp=binding.roundUpSwitch.isChecked
        if(roundUp){
            tip= kotlin.math.ceil(tip)
        }
        val formattedTip=NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text=getString(R.string.tip_amount, formattedTip)
    }
}