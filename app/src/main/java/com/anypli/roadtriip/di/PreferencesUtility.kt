package com.anypli.roadtriip.di


import com.anypli.roadtriip.RoadTripApplication
import com.anypli.roadtriip.data.preferences.impl.PreferencesImpl
import com.anypli.roadtriip.data.preferences.abs.Prefrences


object PreferencesUtility {
    private val preferences: PreferencesImpl = PreferencesImpl(context = RoadTripApplication.getInstance())


    fun getPreferences(): Prefrences {
        return preferences
    }
}





































//val preferences = PreferencesUtility.getPreferences()