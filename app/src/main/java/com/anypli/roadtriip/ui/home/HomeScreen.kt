package com.anypli.roadtriip.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import com.anypli.roadtriip.R
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.anypli.roadtriip.base.BaseScreen
import com.anypli.roadtriip.global.helper.Navigation
import com.anypli.roadtriip.ui.main.AppNavigator
import com.anypli.roadtriip.ui.shared.theme.RoadtriipTheme



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(

    viewModel: HomeViewModel,
    navigator: AppNavigator
) {

    val snackbarHostState = remember { SnackbarHostState() }

    BaseScreen(
        viewModel = viewModel,
        navigationCallback = {
            if (it is Navigation.DetailsEventsScreen)
                navigator.navigateTo(Navigation.DetailsEventsScreen)
        },
        snackbarHostState = snackbarHostState
    ) { modifier ->
        val gridViewItems = viewModel.gridViewItems
        HomeScreen(
            snackbarHostState = snackbarHostState,
            modifier = modifier,
            gridViewItems = gridViewItems ,

            onItemsClicked ={
                viewModel.onItemsClicked()
            }
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun HomeScreen(
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() } ,
    modifier: Modifier ,
    gridViewItems: List<HomeGridView> ,
    onItemsClicked : () -> Unit,

) {

    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Row() {
                        Icon(Icons.Filled.Menu, contentDescription = null)
                        Spacer(modifier = Modifier.width(dimensionResource(R.dimen.margin_global_8dp)))
                        Text(text = stringResource(R.string.events))
                    }
                },
                actions = {
                    Icon(Icons.Filled.Search, contentDescription = null)

                }
            )
        }
    ) {

//        Image(painter = painterResource(id = R.drawable.ic_shape) , contentDescription = "",
//            modifier = Modifier.fillMaxSize(),contentScale = ContentScale.FillBounds
//        )


        LazyVerticalGrid(
            columns = GridCells.Fixed (2),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.margin_global_9dp)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.margin_global_9dp)),
        ){
            items(gridViewItems.size){

                Box(
                    Modifier
                        .fillMaxSize()
                        .clickable {
                            onItemsClicked()
                        }
                ) {
                    Image(painter = painterResource(id = gridViewItems[it].Image) ,
                        contentDescription =null ,
                        contentScale = ContentScale.Crop ,
                        modifier = Modifier.height(dimensionResource(R.dimen.dimen_global_200)),
                    )
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .height(dimensionResource(R.dimen.margin_global_30dp))
                            .align(Alignment.BottomCenter)
                            .background(RoadtriipTheme.colors.black.copy(alpha = 0.4f))
                            .padding(horizontal = dimensionResource(R.dimen.margin_global_5dp)),
                        Arrangement.Center,
                        Alignment.CenterVertically
                    ) {
                        Text(
                            text="${gridViewItems[it].name}",
                            style = TextStyle(
                                color= RoadtriipTheme.colors.white
                            ) ,
                            modifier = Modifier
                                .clickable {

                                }
                                .weight(1f)
                        )

                        Text(
                            text = "${gridViewItems[it].count}",
                            style = TextStyle(
                                color = RoadtriipTheme.colors.white
                            ) ,
                            modifier= Modifier.weight(1f)
                        )

                    }
                }
            }
        }

    }
}

data class  HomeGridView(
    val name: String ,
    val count: Int,
    val Image: Int
)

