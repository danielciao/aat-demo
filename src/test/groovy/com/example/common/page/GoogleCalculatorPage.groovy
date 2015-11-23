package com.example.common.page

import com.example.common.module.NumberButtonModule
import com.example.common.module.OperatorButtonModule
import geb.Page

class GoogleCalculatorPage extends Page {

    static at = { waitFor { calcDiv } }

    static content = {
        calcDiv { $("div.vk_c") }
        numberBtn { text -> module(new NumberButtonModule(text: text)) }
        operatorBtn { text -> module(new OperatorButtonModule(text: text)) }

        equalsBtn(wait: true) { operatorBtn("=") }
        totalOutput(wait: true) { $("span.cwcot") }
    }

}
