package com.opensource.rateus

import android.content.Context
import android.view.LayoutInflater
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.opensource.rateus.databinding.RateUsDialogBinding

class RateUsDialog(context: Context) : AppCompatDialog(context) {

    // Declare variables
    private var binding: RateUsDialogBinding

    init {
        // Initialize views using ViewBinding
        binding = RateUsDialogBinding.inflate(LayoutInflater.from(context))
        setContentView(binding.root)

        binding.apply {
            btnClose.setOnClickListener {
                dismiss()
            }

            btnSubmit.setOnClickListener {
                showFeedbackToast()
            }

            // Play animation
            playAnim(ivEmoRating)
        }
    }

    private fun showFeedbackToast() {
        val rating = binding.ratingBar.rating
        val message = binding.etMessage.text

        val feedbackMessage = "Rating $rating\n Message: $message"
        Toast.makeText(context, feedbackMessage, Toast.LENGTH_SHORT).show()

        dismiss()
    }

    private fun playAnim(ratingEmo: ImageView) {
        val scaleAnim = ScaleAnimation(
            0f,
            1f,
            0f,
            1f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )

        scaleAnim.fillAfter = true
        scaleAnim.duration = 200
        ratingEmo.startAnimation(scaleAnim)
    }
}