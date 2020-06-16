package com.logapps.tourism_app.maps.model

data class placesmodel(
        val html_attributions: List<Any>,
        val next_page_token: String,
        val results: List<Result>,
        val status: String
)