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
    color: ColorType = ColorType.Primary,
    onClick: (String) -> Unit = {  },
    onClickChar: (ImageVector) -> Unit = {  },
    aspectRatio: Float = 2f,
    modifier: Modifier = Modifier
) {
    CalculatorButton(
        text = text,
        icon = icon,
        color = color,
        onClick = onClick,
        onClickChar = onClickChar,
        aspectRatio = aspectRatio,
        modifier = modifier,
        fontSize = MaterialTheme.typography.bodyMedium.fontSize
    )
}