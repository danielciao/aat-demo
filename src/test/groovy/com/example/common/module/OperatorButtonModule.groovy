package com.example.common.module

import geb.Module
import geb.navigator.Navigator

class OperatorButtonModule extends Module {

    String text

    static final textToIdMap = [
        '=': 45,
        '+': 46,
        '-': 36,
        '*': 26,
        '/': 16
    ]

    static content = {
        button(wait: true) { $("""div.vk_c div#cwbt${textToIdMap.get text} span""") }
    }

    Navigator click() {
        button.click()
    }
}
