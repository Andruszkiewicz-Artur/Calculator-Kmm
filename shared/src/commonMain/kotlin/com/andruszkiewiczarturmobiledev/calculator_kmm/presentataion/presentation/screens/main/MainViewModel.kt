package com.andruszkiewiczarturmobiledev.calculator_kmm.presentataion.presentation.screens.main

import io.github.aakira.napier.Napier
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import moe.tlaster.precompose.viewmodel.ViewModel
import org.koin.core.component.KoinComponent

class MainViewModel(

): KoinComponent {

    private val _state: MutableStateFlow<MainState> = MutableStateFlow(MainState())
    val state = _state.asStateFlow()

    private companion object {
        const val TAG = "MainViewModel_TAG"
    }

    fun onEvent(event: MainEvent) {
        when (event) {
            is MainEvent.AddNumber -> {
                if (event.value != "0") {
                    _state.update { it.copy(
                        currentValue = if (it.currentValue != "0") it.currentValue + event.value else event.value
                    ) }
                } else if(_state.value.currentValue != "0") {
                    _state.update { it.copy(
                        currentValue = it.currentValue + event.value
                    ) }
                }
            }
            is MainEvent.AddOption -> {
                if (_state.value.currentValue != "0") {
                    addNextValue(event.value)
                }
            }
            MainEvent.AddDote -> {
                if (!_state.value.currentValue.contains(".") && _state.value.currentValue != "0") {
                    _state.update { it.copy(
                        currentValue = it.currentValue + "."
                    ) }
                }
            }
            MainEvent.RemoveLast -> {
                if (_state.value.currentValue != "0" || _state.value.values.size != 0) {
                    var newCurrentValue: String
                    val newListOfValues = _state.value.values

                    if (_state.value.currentValue == "0") {
                        newListOfValues.removeLast()
                        newCurrentValue = newListOfValues.lastOrNull() ?: "0"
                        if (newListOfValues.lastOrNull() != null) newListOfValues.removeLast()
                    } else {
                        val currentValueFromState = _state.value.currentValue.dropLast(1)

                        newCurrentValue = if (currentValueFromState.isBlank()) "0"
                                            else currentValueFromState
                    }

                    _state.update { it.copy(
                        currentValue = newCurrentValue,
                        values = newListOfValues,
                    ) }
                }
            }
            MainEvent.SetUpPlusMinus -> {
                if (_state.value.currentValue != "0") {
                    val values = _state.value.values

                    if (values.size == 0) {
                        _state.update { it.copy(
                            currentValue = if(it.currentValue.first() == '-') it.currentValue.replace("-", "")
                            else "-${it.currentValue}"
                        ) }
                    } else {
                        val lastChar = values.last()
                        if (lastChar == "+" || lastChar == "-") {

                            values.removeLast()

                            if (lastChar == "-") values.add("+")
                            else values.add("-")

                            _state.update { it.copy(
                                values = values
                            ) }
                        } else {
                            _state.update { it.copy(
                                currentValue = if(it.currentValue.first() == '-') it.currentValue.replace("-", "")
                                else "-${it.currentValue}"
                            ) }
                        }
                    }
                }
            }
            MainEvent.SetUpResult -> {
                if (_state.value.values.size > 2 || (_state.value.currentValue != "0" && _state.value.values.size == 2)) {
                    val listOfNumbers = resultOfExample()

                    _state.update { it.copy(
                        values = mutableListOf(),
                        currentValue = listOfNumbers.first().toString()
                    ) }
                }
            }
            MainEvent.ClickPercent -> {
                if(_state.value.currentValue != "0") {
                    val currentNumber = _state.value.currentValue.toDoubleOrNull()
                    if (currentNumber != null) {
                        _state.update { it.copy(
                            currentValue = "${currentNumber / 100}"
                        ) }
                    }
                }
            }
            MainEvent.ClearMemoryResult-> {
                _state.update { it.copy(
                    memoryValue = "0"
                ) }
            }
            MainEvent.AddFromMemoryResult -> {
                _state.update { it.copy(
                    memoryValue = count(
                        char = "+",
                        number1 = _state.value.memoryValue.toDouble(),
                        number2 = _state.value.currentValue.toDouble()
                    ).toString()
                ) }
            }
            MainEvent.SubtractFromMemoryResult -> {
                _state.update { it.copy(
                    memoryValue = count(
                        char = "-",
                        number1 = _state.value.memoryValue.toDouble(),
                        number2 = _state.value.currentValue.toDouble()
                    ).toString()
                ) }
            }
            MainEvent.ShowFromMemoryResult -> {
                _state.update { it.copy(
                    currentValue = it.memoryValue
                ) }
            }
        }

        setUpPresentedValue()
    }

    private fun addNextValue(char: String) {
        val newList = _state.value.values

        if (_state.value.currentValue == "0") {
            newList.removeLast()
            newList.add(char)
        } else {
            newList.add(_state.value.currentValue)
            newList.add(char)
        }

        _state.update { it.copy(
            currentValue = "0",
            values = newList
        ) }
    }

    private fun setUpPresentedValue() {
        var newPresentedValue = ""

        if (_state.value.values.size > 0) {
            _state.value.values.forEach {
                newPresentedValue = "$newPresentedValue$it "
            }

            if (_state.value.currentValue != "0") newPresentedValue += _state.value.currentValue
        } else {
            newPresentedValue = _state.value.currentValue
        }

        _state.update { it.copy(
            presentedValue = newPresentedValue
        ) }
    }

    private fun count(char: String, number1: Double, number2: Double): Double {
        return when (char) {
            "x" -> number1 * number2
            "/" -> number1 / number2
            "-" -> number1 - number2
            "+" -> number1 + number2
            else -> 0.0
        }
    }

    private fun resultOfExample(): List<Double> {
        val listOfNumbers = mutableListOf<Double>()
        val listOfChars = mutableListOf<String>()
        var listOfQueue = mutableListOf<Int>()

        _state.value.values.forEach {
            val figure = it.toDoubleOrNull()
            if (figure != null) listOfNumbers.add(figure)
            else listOfChars.add(it)
        }

        if (_state.value.currentValue != "0") {
            listOfNumbers.add(_state.value.currentValue.toDouble() )
        } else if (_state.value.currentValue == "0") {
            listOfChars.removeLast()
        }

        listOfChars.forEachIndexed { index, char ->
            if (char == "/" || char == "x") listOfQueue.add(index)
        }

        listOfChars.forEachIndexed { index, char ->
            if (char == "+" || char == "-") listOfQueue.add(index)
        }

        for (value in 0..<listOfQueue.size) {
            val index = listOfQueue.first()

            listOfNumbers[index] = count(
                char = listOfChars[index],
                number1 = listOfNumbers[index],
                number2 = listOfNumbers[index + 1]
            )

            listOfQueue.removeFirst()
            listOfNumbers.removeAt(index + 1)
            listOfChars.removeAt(index)

            listOfQueue = listOfQueue.map {
                if (it > index) it - 1
                else it
            }.toMutableList()
        }

        return listOfNumbers
    }
}