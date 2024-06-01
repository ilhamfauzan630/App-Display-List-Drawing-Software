package com.zanacademy.drawingsoftware

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zanacademy.drawingsoftware.databinding.ActivityDetailSoftwareBinding
import com.zanacademy.drawingsoftware.databinding.ActivityMainBinding

class DetailSoftware : AppCompatActivity() {
    private lateinit var binding: ActivityDetailSoftwareBinding

    companion object {
        const val EXTRA_DRAWING_SOFTWARE = "key_drawing_software"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_software)

        binding = ActivityDetailSoftwareBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val drawing = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<DrawingSoftware>(EXTRA_DRAWING_SOFTWARE, DrawingSoftware::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<DrawingSoftware>(EXTRA_DRAWING_SOFTWARE)
        }

        if (drawing != null) {
            binding.imgItemPhoto.setImageResource(drawing.photo)
            binding.tvItemName.text = drawing.name
            binding.tvItemDescription.text = drawing.description
            binding.device.text = drawing.device
            binding.screenshotImg.setImageResource(drawing.dataScreenshot1)
            binding.screenshotImg2.setImageResource(drawing.dataScreenshot2)
            binding.screenshotImg3.setImageResource(drawing.dataScreenshot3)
        }
    }
}