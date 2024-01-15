package com.andruszkiewiczarturmobiledev.calculator_kmm.presentataion.presentation.screens.main.comp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Backspace
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Exposure
import androidx.compose.material.icons.filled.Percent
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.andruszkiewiczarturmobiledev.calculator_kmm.presentataion.presentation.screens.main.MainEvent
import com.andruszkiewiczarturmobiledev.calculator_kmm.presentataion.presentation.screens.main.MainViewModel
import com.andruszkiewiczarturmobiledev.calculator_kmm.presentataion.presentation.screens.units.ColorType

@Composable
fun LandscapeView(
    viewModel: MainViewModel
) {
    //First Row
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        LandscapeCalculatorButton(
            text = "mc",
            color = ColorType.LightGray,
            onClick = { viewModel.onEvent(MainEvent.ClearMemoryResult) },
            modifier = Modifier.weight(1f)
        )
        LandscapeCalculatorButton(
            text = "m+",
            color = ColorType.LightGray,
            onClick = { viewModel.onEvent(MainEvent.AddFromMemoryResult) },
            modifier = Modifier.weight(1f,)
        )
        LandscapeCalculatorButton(
            text = "m-",
            color = ColorType.LightGray,
            onClick = { viewModel.onEvent(MainEvent.SubtractFromMemoryResult) },
            modifier = Modifier.weight(1f)
        )
        LandscapeCalculatorButton(
            text = "mr",
            color = ColorType.LightGray,
            onClick = { viewModel.onEvent(MainEvent.ShowFromMemoryResult) },
            modifier = Modifier.weight(1f)
        )
        LandscapeCalculatorButton(
            icon = Icons.Filled.Backspace,
            color = ColorType.LightGray,
            onClickChar = { viewModel.onEvent(MainEvent.RemoveLast) },
            modifier = Modifier.weight(1f)
        )

        LandscapeCalculatorButton(
            icon = Icons.Filled.Exposure,
            color = ColorType.LightGray,
            onClickChar = { viewModel.onEvent(MainEvent.SetUpPlusMinus) },
            modifier = Modifier.weight(1f)
        )

        LandscapeCalculatorButton(
            icon = Icons.Filled.Percent,
            color = ColorType.LightGray,
            onClickChar = { viewModel.onEvent(MainEvent.ClickPercent) },
            modifier = Modifier.weight(1f)
        )

        LandscapeCalculatorButton(
            text = "/",
            color = ColorType.Primary,
            onClick = { viewModel.onEvent(MainEvent.AddOption("/")) },
            modifier = Modifier.weight(1f)
        )
    }

    //Second Row
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        LandscapeCalculatorButton(
            text = "(",
            color = ColorType.LightGray,
            onClickChar = { viewModel.onEvent(MainEvent.AddNumber("(")) },
            modifier = Modifier.weight(1f)
        )
        LandscapeCalculatorButton(
            text = ")",
            color = ColorType.LightGray,
            onClick = { viewModel.onEvent(MainEvent.AddNumber(")")) },
            modifier = Modifier.weight(1f,)
        )
        LandscapeCalculatorButton(
            text = "√",
            color = ColorType.LightGray,
            onClickChar = { viewModel.onEvent(MainEvent.AddNumber("√")) },
            modifier = Modifier.weight(1f)
        )
        LandscapeCalculatorButton(
            text = "ln",
            color = ColorType.LightGray,
            onClickChar = { viewModel.onEvent(MainEvent.AddNumber("ln")) },
            modifier = Modifier.weight(1f)
        )
        LandscapeCalculatorButton(
            text = "9",
            color = ColorType.Gray,
            onClick = { viewModel.onEvent(MainEvent.AddNumber("9")) },
            modifier = Modifier.weight(1f)
        )

        LandscapeCalculatorButton(
            text = "8",
            color = ColorType.Gray,
            onClick = { viewModel.onEvent(MainEvent.AddNumber("8")) },
            modifier = Modifier.weight(1f)
        )

        LandscapeCalculatorButton(
            text = "7",
            color = ColorType.Gray,
            onClick = { viewModel.onEvent(MainEvent.AddNumber("7")) },
            modifier = Modifier.weight(1f)
        )

        LandscapeCalculatorButton(
            icon = Icons.Filled.Close,
            color = ColorType.Primary,
            onClickChar = { viewModel.onEvent(MainEvent.AddOption("x")) },
            modifier = Modifier.weight(1f)
        )
    }

    //Third Row
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        LandscapeCalculatorButton(
            text = "x/y",
            color = ColorType.LightGray,
            onClickChar = { viewModel.onEvent(MainEvent.AddNumber("x/y")) },
            modifier = Modifier.weight(1f)
        )
        LandscapeCalculatorButton(
            textView = {
                Row {
                    Text(
                        text = "x",
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                    ) {
                        Text(
                            text = "y",
                            fontSize = MaterialTheme.typography.bodyMedium.fontSize / 2
                        )
                    }
                }
            },
            color = ColorType.LightGray,
            onClick = { viewModel.onEvent(MainEvent.AddNumber("xy")) },
            modifier = Modifier.weight(1f,)
        )
        LandscapeCalculatorButton(
            text = "e",
            color = ColorType.LightGray,
            onClickChar = { viewModel.onEvent(MainEvent.AddNumber("e")) },
            modifier = Modifier.weight(1f)
        )
        LandscapeCalculatorButton(
            text = "pi",
            color = ColorType.LightGray,
            onClickChar = { viewModel.onEvent(MainEvent.AddNumber("pi")) },
            modifier = Modifier.weight(1f)
        )
        LandscapeCalculatorButton(
            text = "6",
            color = ColorType.Gray,
            onClick = { viewModel.onEvent(MainEvent.AddNumber("6")) },
            modifier = Modifier.weight(1f)
        )

        LandscapeCalculatorButton(
            text = "5",
            color = ColorType.Gray,
            onClick = { viewModel.onEvent(MainEvent.AddNumber("5")) },
            modifier = Modifier.weight(1f)
        )

        LandscapeCalculatorButton(
            text = "4",
            color = ColorType.Gray,
            onClick = { viewModel.onEvent(MainEvent.AddNumber("4")) },
            modifier = Modifier.weight(1f)
        )

        LandscapeCalculatorButton(
            icon = Icons.Filled.Remove,
            color = ColorType.Primary,
            onClickChar = { viewModel.onEvent(MainEvent.AddOption("-")) },
            modifier = Modifier.weight(1f)
        )
    }

    //Fourth Row
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        LandscapeCalculatorButton(
            text = "sin",
            color = ColorType.LightGray,
            onClickChar = { viewModel.onEvent(MainEvent.AddNumber("sin")) },
            modifier = Modifier.weight(1f)
        )
        LandscapeCalculatorButton(
            text = "cos",
            color = ColorType.LightGray,
            onClick = { viewModel.onEvent(MainEvent.AddNumber("cos")) },
            modifier = Modifier.weight(1f,)
        )
        LandscapeCalculatorButton(
            text = "tan",
            color = ColorType.LightGray,
            onClickChar = { viewModel.onEvent(MainEvent.AddNumber("tan")) },
            modifier = Modifier.weight(1f)
        )
        LandscapeCalculatorButton(
            text = "cot",
            color = ColorType.LightGray,
            onClickChar = { viewModel.onEvent(MainEvent.AddNumber("cot")) },
            modifier = Modifier.weight(1f)
        )
        LandscapeCalculatorButton(
            text = "3",
            color = ColorType.Gray,
            onClick = { viewModel.onEvent(MainEvent.AddNumber("3")) },
            modifier = Modifier.weight(1f)
        )

        LandscapeCalculatorButton(
            text = "2",
            color = ColorType.Gray,
            onClick = { viewModel.onEvent(MainEvent.AddNumber("2")) },
            modifier = Modifier.weight(1f)
        )

        LandscapeCalculatorButton(
            text = "1",
            color = ColorType.Gray,
            onClick = { viewModel.onEvent(MainEvent.AddNumber("1")) },
            modifier = Modifier.weight(1f)
        )

        LandscapeCalculatorButton(
            icon = Icons.Filled.Add,
            color = ColorType.Primary,
            onClickChar = { viewModel.onEvent(MainEvent.AddOption("+")) },
            modifier = Modifier.weight(1f)
        )
    }

    //Last Row
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        LandscapeCalculatorButton(
            text = "sinh",
            color = ColorType.LightGray,
            onClickChar = { viewModel.onEvent(MainEvent.AddNumber("sinh")) },
            modifier = Modifier.weight(1f)
        )
        LandscapeCalculatorButton(
            text = "cosh",
            color = ColorType.LightGray,
            onClick = { viewModel.onEvent(MainEvent.AddNumber("cosh")) },
            modifier = Modifier.weight(1f,)
        )
        LandscapeCalculatorButton(
            text = "tanh",
            color = ColorType.LightGray,
            onClickChar = { viewModel.onEvent(MainEvent.AddNumber("tanh")) },
            modifier = Modifier.weight(1f)
        )
        LandscapeCalculatorButton(
            text = "coth",
            color = ColorType.LightGray,
            onClickChar = { viewModel.onEvent(MainEvent.AddNumber("coth")) },
            modifier = Modifier.weight(1f)
        )
        LandscapeCalculatorButton(
            text = "0",
            color = ColorType.Gray,
            onClick = { viewModel.onEvent(MainEvent.AddNumber("0")) },
            aspectRatio = 4f,
            modifier = Modifier.weight(2f)
        )

        LandscapeCalculatorButton(
            text = ".",
            color = ColorType.LightGray,
            onClick = { viewModel.onEvent(MainEvent.AddDote) },
            modifier = Modifier.weight(1f)
        )

        LandscapeCalculatorButton(
            text = "=",
            color = ColorType.Primary,
            onClick = { viewModel.onEvent(MainEvent.SetUpResult) },
            modifier = Modifier.weight(1f)
        )
    }
}