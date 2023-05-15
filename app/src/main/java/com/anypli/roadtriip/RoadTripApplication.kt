package com.anypli.roadtriip
import android.os.Bundle
import androidx.activity.ComponentActivity

class RoadTripApplication: ComponentActivity() {
    companion object {
          private var instance: RoadTripApplication ? = null
        fun getInstance(): RoadTripApplication{
            return instance !!
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        instance = RoadTripApplication()



    }
}