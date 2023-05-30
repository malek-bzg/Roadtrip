package com.anypli.roadtriip.ui.home

import com.anypli.roadtriip.R
import com.anypli.roadtriip.base.BaseViewModel
import com.anypli.roadtriip.global.helper.Navigation


class HomeViewModel: BaseViewModel() {


   val gridViewItems : List<HomeGridView> = listOf(

         HomeGridView(
     "zaghoun",
     200,
     R.drawable.zaghouane
     ),

         HomeGridView(
     "Bizerte",
     200,
     R.drawable.bizerte
     ),
         HomeGridView(
     "Gabes",
     200,
     R.drawable.gabes
     ),
         HomeGridView(
     "Sfax",
     200,
     R.drawable.sfax
     ),
         HomeGridView(
     "Kairaoun",
     200,
     R.drawable.kairaoun
     ),
         HomeGridView(
     "Sidi Bousaid",
     200,
     R.drawable.sidibou
     ),
         HomeGridView(
     "Monastir",
     200,
     R.drawable.monastir
     ),
         HomeGridView(
     "Beja",
     200,
     R.drawable.beja
     ),
         HomeGridView(
     "Touzer",
     200,
     R.drawable.touzeur
     ),
         HomeGridView(
     "Matmata",
     200,
     R.drawable.matmata
     ),
     )

     fun onItemsClicked(){
         navigate(Navigation.DetailsEventsScreen)
     }
 }