package com.example.common.module

import geb.Module
import geb.navigator.Navigator

class NumberButtonModule extends Module {

    String text

    static content = {
        button(wait: true) { $("div.vk_c div.cwbd span", text: text) }
    }

    Navigator click() {
        button.click()
    }
}
