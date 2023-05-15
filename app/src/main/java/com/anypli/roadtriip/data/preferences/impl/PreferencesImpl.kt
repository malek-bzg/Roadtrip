package com.anypli.roadtriip.data.preferences.impl

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.anypli.roadtriip.RoadTripApplication
//import com.anypli.roadtriip.RoadTripApplication
import com.anypli.roadtriip.data.preferences.abs.Prefrences


class PreferencesImpl(private val context: Context) : Prefrences {

    private val mainKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
    private val sharedPreferences = EncryptedSharedPreferences.create(
        "myEncryptedPrefs",
        mainKeyAlias,
        context ,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

}


