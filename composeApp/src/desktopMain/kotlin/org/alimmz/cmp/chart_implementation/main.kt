package org.alimmz.cmp.chart_implementation

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "CmpChartImplementation",
    ) {
        App()
    }
}