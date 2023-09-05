package com.zanacademy.drawingsoftware

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DrawingSoftware(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
