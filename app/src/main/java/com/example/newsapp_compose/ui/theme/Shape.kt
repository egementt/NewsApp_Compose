package com.example.newsapp_compose.ui.theme

import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = AbsoluteCutCornerShape(topLeft = 2f),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(8.dp)
)