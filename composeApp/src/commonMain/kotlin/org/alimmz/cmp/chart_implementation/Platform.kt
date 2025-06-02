package org.alimmz.cmp.chart_implementation

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform