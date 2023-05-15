package com.anypli.roadtriip.base

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.anypli.roadtriip.global.helper.BaseStateContent
import com.anypli.roadtriip.global.helper.Navigation
import com.anypli.roadtriip.global.helper.TypeMessage
import com.anypli.roadtriip.global.helper.dialog.ChooseDialog
import com.anypli.roadtriip.global.helper.dialog.SimpleDialog
import com.anypli.roadtriip.global.utilities.convertToString
import com.anypli.roadtriip.ui.shared.theme.RoadtriipTheme
import com.anypli.roadtriip.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch





@Composable
fun <T : BaseViewModel> BaseScreen(
    viewModel: T,
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() },
    navigationCallback: (Navigation) -> Unit,
    body: @Composable (Modifier) -> Unit,

) {
    val coroutineScope = rememberCoroutineScope()
    RoadtriipTheme {
        // Collecter le StateFlow de BaseViewModel
        val progressBar by viewModel.progressBar.collectAsState()
     val simpleDialog by viewModel.simpleDialog.collectAsState()
         val chooseDialog by viewModel.chooseDialog.collectAsState()
        val navigateTo by viewModel.navigation.collectAsState()
        val snackbarMessage by viewModel.snackBarMessage.collectAsState()


        // Composer le contenu de l'écran
        Box(modifier = Modifier.fillMaxSize()) {
            body(Modifier)
            if (progressBar) {
                LoaderProgressBar()
            }
            simpleDialog?.let { SimpleDialogObserver (it) }
            chooseDialog?.let { ChooseDialogObserver (it) }
            navigateTo?.let { NavigationObserver (it,navigationCallback)}
            snackbarMessage?.let { SnackBarObserver (it,coroutineScope,snackbarHostState, onSnackBarDisplayed = {viewModel.onSnackBarDisplayed(it)}) }


        }

    }
}

@Composable
fun SnackBarObserver(baseStateContent: BaseStateContent<TypeMessage> , coroutineScope: CoroutineScope ,snackbarHostState: SnackbarHostState ,onSnackBarDisplayed :(Long) -> Unit) {

    baseStateContent.let {
        val message = it.content.convertToString()
        LaunchedEffect(key1 = baseStateContent) {
            // Show snackbar using a coroutine, when the coroutine is cancelled the
            // snackbar will automatically dismiss. This coroutine will cancel whenever
            // `snackBarMessage.isNotEmpty()` is false, and only start when `snackBarMessage.isNotEmpty()` is true
            // (due to the above if-check), or if `scaffoldState.snackbarHostState` changes.
            coroutineScope.launch {
                onSnackBarDisplayed(it.id)
                snackbarHostState.currentSnackbarData?.dismiss()
                snackbarHostState.showSnackbar(
                    message = message,
                    duration = SnackbarDuration.Short
                )
            }
        }
    }

}

@Composable
fun NavigationObserver(navigation: BaseStateContent<Navigation>,navigationCallback: (Navigation) -> Unit) {
    LaunchedEffect(navigation) {

        navigationCallback.invoke(navigation.content)


    }

}


@Composable
fun LoaderProgressBar() {
        BackHandler(enabled = true) {
            return@BackHandler
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .clickable { return@clickable },
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }

}
@Composable
fun SimpleDialogObserver( simpleDialog:SimpleDialog ) {
        AlertDialog(
            onDismissRequest = {
                 simpleDialog.dismissActionBlock?.invoke()

            },
            title = { Text(simpleDialog.message.convertToString()) },
            text = { Text(simpleDialog.message.convertToString()) },
            confirmButton = {
                Button(onClick = {
                    simpleDialog.okActionBlock?.invoke()

                }) {
                    Text(stringResource(id = R.string.global_ok))
                }
            },
        )
    }
@Composable
fun ChooseDialogObserver(simpleDialog: ChooseDialog) {
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {

                openDialog.value = false
            },
            title = {
                 Text(simpleDialog.title?.convertToString()?:"")
            },
            text = {
                Text(simpleDialog.message.convertToString())
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        simpleDialog.okActionBlock?.invoke()
                    }
                ) {
                    Text(simpleDialog.ok.convertToString())
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        simpleDialog.cancelActionBlock?.invoke()
                    }
                ) {
                    Text(simpleDialog.cancel.convertToString())
                }
            }
        )
    }

}



//@Preview
//@Composable
//fun button () {
//    var count by remember { mutableStateOf(0) }
//    //var isLoading by remember { mutableStateOf(false) }
//
//    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//        Button(
//            onClick = {
//
//                // Simulate long operation
//
//                    count += 1
//
//
//            },
//            modifier = Modifier
//                .align(Alignment.BottomCenter)
//                .padding(16.dp)
//        ) {
//            Text(text = count.toString())
//        }
//        LoaderProgressBar()
//
//    }
//}











