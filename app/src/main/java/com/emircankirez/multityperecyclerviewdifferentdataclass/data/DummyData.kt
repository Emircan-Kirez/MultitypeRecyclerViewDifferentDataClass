package com.emircankirez.multityperecyclerviewdifferentdataclass.data

import com.emircankirez.multityperecyclerviewdifferentdataclass.R
import com.emircankirez.multityperecyclerviewdifferentdataclass.model.Model

object DummyData {
    fun getData() : ArrayList<Model>{
        val data = ArrayList<Model>()
        data.add(Model.Film("The Call of the Wild", "A sled dog struggles for survival in the wilds of the Yukon.", 6.5f))
        data.add(Model.Film("The Godfather", "Don Vito Corleone, head of a mafia family, decides to hand over his empire to his youngest son Michael. However, his decision unintentionally puts the lives of his loved ones in grave danger.", 9.5f))
        data.add(Model.Ad(R.drawable.ad2))
        data.add(Model.Film("Taxi Driver", "A mentally unstable veteran works as a nighttime taxi driver in New York City, where the perceived decadence and sleaze fuels his urge for violent action.", 8f))
        data.add(Model.Ad(R.drawable.ad1))
        data.add(Model.Film("Honor Society", "Honor's sole focus is getting into Harvard. Willing to do whatever it takes, Honor concocts a plan to take down her top three competitors, until things take a turn when she unexpectedly falls for her biggest competition.", 6.5f))
        return data
    }
}