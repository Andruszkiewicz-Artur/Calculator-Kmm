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
                if (event.value == "delete") {
                    _state.update { it.copy(
                        currentValue = "0",
                        values = mutableListOf(),
                        isClearClickable = false,
                        isPlusMinusClickable = false,
                        isEqualClickable = false,
                        isZeroClickable = false,
                        isCharClickable = false,
                        isDoteClickable = false
                    ) }
                } else if (event.value == ".") {
                    _state.update { it.copy(
                        currentValue = it.currentValue + ".",
                        isClearClickable = true,
                        isPlusMinusClickable = true,
                        isEqualClickable = false,
                        isZeroClickable = true,
                        isCharClickable = false,
                        isDoteClickable = true
                    ) }
                } else if (event.value == "+/-") {
                    if (_state.value.values.size < 2) {
                        _state.update { it.copy(
                            currentValue = if(it.currentValue.first() == '-') it.currentValue.replace("-", "") else "-" + it.currentValue
                        ) }
                    } else {
                        if (_state.value.values.last() == "+" || _state.value.values.last() == "-") {
                            val newList = _state.value.values

                            newList.removeLast()
                            if (_state.value.values.last() == "+") newList.add("-")
                            else newList.add("+")

                            _state.update { it.copy(
                                values = newList
                            ) }
                        } else {
                            _state.update { it.copy(
                                currentValue = if(it.currentValue.first() == '-') it.currentValue.replace("-", "") else "-" + it.currentValue
                            ) }
                        }
                    }
                } else if (event.value == "%") {

                } else {
                    addNextValue(event.value)
                }
            }
        }
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
}