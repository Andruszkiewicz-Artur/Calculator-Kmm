package com.andruszkiewiczarturmobiledev.calculator_kmm.presentataion.screens.main

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import moe.tlaster.precompose.viewmodel.ViewModel

class MainViewModel: ViewModel() {

    private val _state: MutableStateFlow<MainState> = MutableStateFlow(MainState())
    val state = _state.asStateFlow()

    fun onEvent(event: MainEvent) {
        when (event) {
            is MainEvent.AddNumber -> {
                _state.update { it.copy(
                    currentValue = if (it.currentValue != "0") it.currentValue + event.value else event.value,
                    isEqualClickable = it.values.size > 2,
                    isClearClickable = true,
                    isPlusMinusClickable = true,
                    isZeroClickable = true,
                    isCharClickable = true,
                    isDoteClickable = true
                ) }
            }
            is MainEvent.AddOption -> {
                addNextValue(event.value)
            }
            MainEvent.AddDote -> {
                if (!_state.value.currentValue.contains(".")) {
                    _state.update { it.copy(
                        currentValue = it.currentValue + ".",
                        isClearClickable = true,
                        isPlusMinusClickable = true,
                        isEqualClickable = false,
                        isZeroClickable = true,
                        isCharClickable = true,
                        isDoteClickable = false
                    ) }
                }
            }
            MainEvent.RemoveLast -> {
                var newCurrentValue = "0"
                val newListOfValues = _state.value.values
                var isClearClickable = true

                if (_state.value.currentValue == "0") {
                    newListOfValues.removeLast()
                    newCurrentValue = newListOfValues.lastOrNull() ?: "0"
                    if (newListOfValues.lastOrNull() != null) newListOfValues.removeLast()
                } else {
                    val currentValueFromState = _state.value.currentValue.dropLast(1)

                    if (currentValueFromState.isBlank()) {
                        newCurrentValue = "0"
                        if (newListOfValues.size == 0) isClearClickable = false
                    } else {
                        newCurrentValue = currentValueFromState
                    }
                }

                _state.update { it.copy(
                    currentValue = newCurrentValue,
                    values = newListOfValues,
                    isClearClickable = isClearClickable,
                    isPlusMinusClickable = isClearClickable,
                    isEqualClickable = false,
                    isZeroClickable = false,
                    isCharClickable = false,
                    isDoteClickable = false
                ) }
            }
            MainEvent.SetUpPlusMinus -> {
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
            MainEvent.SetUpResult -> {

            }
            MainEvent.ClickPercent -> {
                val currentNumber = _state.value.currentValue.toDoubleOrNull()
                if (currentNumber != null) {
                    _state.update { it.copy(
                        currentValue = "${currentNumber / 100}"
                    ) }
                }
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
            values = newList,
            isClearClickable = true,
            isPlusMinusClickable = false,
            isEqualClickable = newList.size > 2,
            isZeroClickable = false,
            isCharClickable = true
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
}