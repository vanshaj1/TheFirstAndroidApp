package com.example.thefirstandroidapp

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import java.util.stream.IntStream.range
import kotlin.math.round

@Composable
fun App(modifier: Modifier) {
    var stopsList = getTenStops()
    var distanceTravelled by rememberSaveable{mutableStateOf(0)}
    var distanceInKm by rememberSaveable{mutableStateOf(true)}
    if(distanceTravelled > (stopsList.size - 1) * 5){
       distanceTravelled = 0
    }
    Column{
        ProgressTrackComponent(modifier,stopsList.size,distanceTravelled)
//        OutputScreenComponent(modifier,stopsList,distanceTravelled,distanceInKm)
        OutputScreenWithNormalListComponent(modifier,stopsList,distanceTravelled,distanceInKm)
        UtilitiesComponent(modifier,
                            onConvert = {distanceInKm = !distanceInKm},
                            onNextStop = {distanceTravelled++},
                            onLoadStops = {distanceTravelled = 0}
        )
    }
}

private fun getTenStops() = List(10){ i -> Stops(name = "$i",distance = (i * 5))}
private fun getTwentyStops() = List(20){ i -> Stops(name = "$i",distance = (i * 5))}

@Preview(heightDp = 873, widthDp = 393)
@Composable
fun PreviewApp(){
    App(Modifier)
}