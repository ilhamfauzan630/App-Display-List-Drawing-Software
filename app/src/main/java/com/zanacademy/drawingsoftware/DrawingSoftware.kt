package com.zanacademy.drawingsoftware

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DrawingSoftware(
    val name: String,
    val description: String,
    val photo: Int,
    val device: String,
    val dataScreenshot1: Int,
    val dataScreenshot2: Int,
    val dataScreenshot3: Int
) : Parcelable
