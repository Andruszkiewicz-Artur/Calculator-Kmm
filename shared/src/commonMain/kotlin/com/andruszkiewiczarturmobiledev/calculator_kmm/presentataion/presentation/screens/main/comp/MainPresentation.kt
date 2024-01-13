package com.andruszkiewiczarturmobiledev.calculator_kmm.presentataion.presentation.screens.main.comp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
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
import androidx.compose.material.icons.filled.Exposure
import androidx.compose.material.icons.filled.Percent
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalViewConfiguration
import androidx.compose.ui.unit.dp
import com.andruszkiewiczarturmobiledev.calculator_kmm.presentataion.presentation.screens.main.MainEvent
import com.andruszkiewiczarturmobiledev.calculator_kmm.presentataion.presentation.screens.main.MainViewModel
import com.andruszkiewiczarturmobiledev.calculator_kmm.presentataion.presentation.screens.units.ColorType
import org.koin.compose.koinInject

@Composable
fun MainPresentation(
    viewModel: MainViewModel = koinInject()
) {
    val state = viewModel.state.collectAsState().value

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        BoxWithConstraints(
            contentAlignment = Alignment.BottomEnd
        ) {
            Column (
                verticalArrangement = Arrangement.Bottom
            ) {
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

                if(this@BoxWithConstraints.maxWidth < this@BoxWithConstraints.maxHeight) {
                    PortraitView(
                        viewModel = viewModel
                    )
                } else {
                    LandscapeView(
                        viewModel = viewModel
                    )
                }
            }
        }

    }
}