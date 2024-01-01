package com.andruszkiewiczarturmobiledev.calculator_kmm.presentataion.presentation.screens.main.comp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andruszkiewiczarturmobiledev.calculator_kmm.presentataion.presentation.screens.units.ColorType

@Composable
fun CalculatorButton(
    text: String? = null,
    icon: ImageVector? = null,
    color: ColorType = ColorType.Primary,
    onClick: (String) -> Unit = {  },
    onClickChar: (ImageVector) -> Unit = {  },
    aspectRatio: Float = 1f,
    modifier: Modifier = Modifier
) {
    val contentColor = when(color) {
        ColorType.LightGray -> MaterialTheme.colorScheme.onBackground.copy(alpha = 0.9f)
        else -> Color.White
    }

    val themeColor = when(color) {
        ColorType.LightGray -> MaterialTheme.colorScheme.onBackground.copy(alpha = 0.3f)
        ColorType.Gray -> Color.Gray
        ColorType.Primary -> MaterialTheme.colorScheme.primary
    }

    val fontSize = MaterialTheme.typography.headlineLarge.fontSize

    Button(
        onClick = {
            if (text != null) onClick(text)
            else if (icon != null) onClickChar(icon) },
        colors = ButtonDefaults.buttonColors(
            containerColor = themeColor,
            contentColor = contentColor
        ),
        modifier = modifier
            .aspectRatio(aspectRatio)
            .padding(8.dp),
        shape = CircleShape,
        content = {
            if (text != null) {
                Text(
                    text = text,
                    fontSize = fontSize
                )
            } else if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier
                        .size(fontSize.value.dp)
                )
            }
        }
    )
}