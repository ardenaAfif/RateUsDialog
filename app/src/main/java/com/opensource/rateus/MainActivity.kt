package com.opensource.rateus

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.opensource.rateus.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRateUs.setOnClickListener {
            showRatingDialog()
        }

    }

    private fun showRatingDialog() {
        val rateUsDialog = RateUsDialog(this)
        rateUsDialog.window?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.transparant)))
        rateUsDialog.setCancelable(false)
        rateUsDialog.show()
    }
}