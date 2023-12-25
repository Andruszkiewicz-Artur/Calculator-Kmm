package com.andruszkiewiczarturmobiledev.calculator_kmm.presentataion.screens.main.comp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Backspace
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Exposure
import androidx.compose.material.icons.filled.Percent
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.andruszkiewiczarturmobiledev.calculator_kmm.presentataion.screens.main.MainEvent
import com.andruszkiewiczarturmobiledev.calculator_kmm.presentataion.screens.main.MainViewModel
import com.andruszkiewiczarturmobiledev.calculator_kmm.presentataion.screens.units.ColorType
import moe.tlaster.precompose.viewmodel.viewModel

@Composable
fun MainPresentation() {
    val viewModel = remember {
        MainViewModel()
    }
    val state = viewModel.state.collectAsState().value

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Text(
                text = state.values.toString()
            )

            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = state.presentedValue,
                    style = MaterialTheme.typography.displayMedium
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                //First Row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    CalculatorButton(
                        icon = Icons.Filled.Backspace,
                        color = ColorType.LightGray,
                        onClickChar = { viewModel.onEvent(MainEvent.RemoveLast) },
                        isClickable = state.isClearClickable,
                        modifier = Modifier.weight(1f)
                    )

                    CalculatorButton(
                        icon = Icons.Filled.Exposure,
                        color = ColorType.LightGray,
                        onClickChar = { viewModel.onEvent(MainEvent.SetUpPlusMinus) },
                        isClickable = state.isPlusMinusClickable,
                        modifier = Modifier.weight(1f)
                    )

                    CalculatorButton(
                        icon = Icons.Filled.Percent,
                        color = ColorType.LightGray,
                        onClickChar = { viewModel.onEvent(MainEvent.AddOption("%")) },
                        isClickable = state.isCharClickable,
                        modifier = Modifier.weight(1f)
                    )

                    CalculatorButton(
                        text = "/",
                        color = ColorType.Primary,
                        onClick = { viewModel.onEvent(MainEvent.AddOption("/")) },
                        isClickable = state.isCharClickable,
                        modifier = Modifier.weight(1f, )
                    )
                }

                //Second Row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    CalculatorButton(
                        text = "9",
                        color = ColorType.Gray,
                        onClick = { viewModel.onEvent(MainEvent.AddNumber("9")) },
                        modifier = Modifier.weight(1f)
                    )

                    CalculatorButton(
                        text = "8",
                        color = ColorType.Gray,
                        onClick = { viewModel.onEvent(MainEvent.AddNumber("8")) },
                        modifier = Modifier.weight(1f)
                    )

                    CalculatorButton(
                        text = "7",
                        color = ColorType.Gray,
                        onClick = { viewModel.onEvent(MainEvent.AddNumber("7")) },
                        modifier = Modifier.weight(1f)
                    )

                    CalculatorButton(
                        icon = Icons.Filled.Close,
                        color = ColorType.Primary,
                        onClickChar = { viewModel.onEvent(MainEvent.AddOption("x")) },
                        isClickable = state.isCharClickable,
                        modifier = Modifier.weight(1f)
                    )
                }

                //Third Row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    CalculatorButton(
                        text = "6",
                        color = ColorType.Gray,
                        onClick = { viewModel.onEvent(MainEvent.AddNumber("6")) },
                        modifier = Modifier.weight(1f)
                    )

                    CalculatorButton(
                        text = "5",
                        color = ColorType.Gray,
                        onClick = { viewModel.onEvent(MainEvent.AddNumber("5")) },
                        modifier = Modifier.weight(1f)
                    )

                    CalculatorButton(
                        text = "4",
                        color = ColorType.Gray,
                        onClick = { viewModel.onEvent(MainEvent.AddNumber("4")) },
                        modifier = Modifier.weight(1f)
                    )

                    CalculatorButton(
                        icon = Icons.Filled.Remove,
                        color = ColorType.Primary,
                        onClickChar = { viewModel.onEvent(MainEvent.AddOption("-")) },
                        isClickable = state.isCharClickable,
                        modifier = Modifier.weight(1f)
                    )
                }

                //Fourth Row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    CalculatorButton(
                        text = "3",
                        color = ColorType.Gray,
                        onClick = { viewModel.onEvent(MainEvent.AddNumber("3")) },
                        modifier = Modifier.weight(1f)
                    )

                    CalculatorButton(
                        text = "2",
                        color = ColorType.Gray,
                        onClick = { viewModel.onEvent(MainEvent.AddNumber("2")) },
                        modifier = Modifier.weight(1f)
                    )

                    CalculatorButton(
                        text = "1",
                        color = ColorType.Gray,
                        onClick = { viewModel.onEvent(MainEvent.AddNumber("1")) },
                        modifier = Modifier.weight(1f)
                    )

                    CalculatorButton(
                        icon = Icons.Filled.Add,
                        color = ColorType.Primary,
                        onClickChar = { viewModel.onEvent(MainEvent.AddOption("+")) },
                        isClickable = state.isCharClickable,
                        modifier = Modifier.weight(1f)
                    )
                }

                //Last Row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    CalculatorButton(
                        text = "0",
                        color = ColorType.Gray,
                        onClick = { viewModel.onEvent(MainEvent.AddNumber("0")) },
                        isClickable = state.isClearClickable,
                        aspectRatio = 2f,
                        modifier = Modifier.weight(2f)
                    )

                    CalculatorButton(
                        text = ".",
                        color = ColorType.LightGray,
                        onClick = { viewModel.onEvent(MainEvent.AddDote) },
                        isClickable = state.isDoteClickable,
                        modifier = Modifier.weight(1f)
                    )

                    CalculatorButton(
                        text = "=",
                        color = ColorType.Primary,
                        onClick = { viewModel.onEvent(MainEvent.SetUpResult) },
                        isClickable = state.isEqualClickable,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}