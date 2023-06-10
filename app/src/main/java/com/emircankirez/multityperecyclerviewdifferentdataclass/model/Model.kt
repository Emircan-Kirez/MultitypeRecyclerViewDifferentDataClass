package com.emircankirez.multityperecyclerviewdifferentdataclass.model

sealed class Model{
    data class Film(
        val title : String,
        val content : String,
        val rate : Float
    ) : Model()

    data class Ad(
        val image : Int
    ) : Model()
}
