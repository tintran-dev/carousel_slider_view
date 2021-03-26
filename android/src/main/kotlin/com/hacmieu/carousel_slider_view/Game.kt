package com.hacmieu.carousel_slider_view

class Game(private var imageSource: Int = 0, private var name: String? = null) {

    fun Game(imageSource: Int, name: String?) {
        this.name = name
        this.imageSource = imageSource
    }

    fun getName(): String? {
        return name
    }

    fun getImageSource(): Int {
        return imageSource
    }
}