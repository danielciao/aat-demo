package com.example.common.page

import geb.Page

class GoogleSearchPage extends Page {

    static url = "http://www.google.co.uk"
    static at = { title: "Google" }

    static content = {
        searchInput { $("input", title: "Search") }
        searchBtn { $("button", name: "btnG") }

        expandDiv(required: false) { $("div.xpdns") }
        locationDiv(required: false) { $("div.xpdns div._eF") }
        locationDivText(required: false) { locationDiv?.text() }
    }

}
