package com.andruszkiewiczarturmobiledev.calculator_kmm.presentataion.presentation.screens.main.comp

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Backspace
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Exposure
import androidx.compose.material.icons.filled.Percent
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
            icon = Icons.Filled.Percent,
            color = ColorType.LightGray,
            onClickChar = { viewModel.onEvent(MainEvent.ClickPercent) },
            modifier = Modifier.weight(1f)
        )

        LandscapeCalculatorButton(
            text = "/",
            color = ColorType.Primary,
            onClick = { viewModel.onEvent(MainEvent.AddOption("/")) },
            modifier = Modifier.weight(1f,)
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
            icon = Icons.Filled.Percent,
            color = ColorType.LightGray,
            onClickChar = { viewModel.onEvent(MainEvent.ClickPercent) },
            modifier = Modifier.weight(1f)
        )

        LandscapeCalculatorButton(
            text = "/",
            color = ColorType.Primary,
            onClick = { viewModel.onEvent(MainEvent.AddOption("/")) },
            modifier = Modifier.weight(1f,)
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
            icon = Icons.Filled.Percent,
            color = ColorType.LightGray,
            onClickChar = { viewModel.onEvent(MainEvent.ClickPercent) },
            modifier = Modifier.weight(1f)
        )

        LandscapeCalculatorButton(
            text = "/",
            color = ColorType.Primary,
            onClick = { viewModel.onEvent(MainEvent.AddOption("/")) },
            modifier = Modifier.weight(1f,)
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