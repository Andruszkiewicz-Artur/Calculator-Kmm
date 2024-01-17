package com.andruszkiewiczarturmobiledev.calculator_kmm.presentataion.presentation.screens.main.comp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.andruszkiewiczarturmobiledev.calculator_kmm.presentataion.presentation.screens.units.ColorType

@Composable
fun LandscapeCalculatorButton(
    text: String? = null,
    icon: ImageVector? = null,
    textView: @Composable () -> Unit = { },
    color: ColorType = ColorType.Primary,
    onClick: () -> Unit = {  },
    aspectRatio: Float = 2f,
    modifier: Modifier = Modifier
) {
    CalculatorButton(
        text = text,
        icon = icon,
        textView = textView,
        color = color,
        onClick = onClick,
        aspectRatio = aspectRatio,
        modifier = modifier,
        fontSize = MaterialTheme.typography.bodyMedium.fontSize
    )
}