package com.anypli.roadtriip.ui.details

import com.anypli.roadtriip.base.BaseViewModel
import com.anypli.roadtriip.global.helper.Navigation

class DetailsViewModel: BaseViewModel()  {

    fun onBackClicked(){
        navigate(Navigation.Back)
    }
}