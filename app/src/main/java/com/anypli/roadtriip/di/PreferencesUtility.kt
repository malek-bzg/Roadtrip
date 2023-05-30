package com.anypli.roadtriip.di


import com.anypli.roadtriip.RoadTripApplication
import com.anypli.roadtriip.data.preferences.impl.PreferencesImpl
import com.anypli.roadtriip.data.preferences.abs.Preferences


object PreferencesUtility {
    private val preferences: PreferencesImpl = PreferencesImpl(context = RoadTripApplication.getInstance())


    fun getPreferences(): Preferences {
        return preferences
    }
}





































//val preferences = PreferencesUtility.getPreferences()