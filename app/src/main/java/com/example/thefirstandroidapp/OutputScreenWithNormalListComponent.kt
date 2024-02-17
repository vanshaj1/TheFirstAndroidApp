package com.example.thefirstandroidapp

import androidx.compose.runtime.Composable
import android.widget.ProgressBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items

@Composable
fun OutputScreenWithNormalListComponent(modifier: Modifier,
                                        stopsList: List<Stops>,
                                        distanceTravelled: Int,
                                        distanceInKm: Boolean
){
    Text(text = "Distance in ${
        if(distanceInKm == true){
            "KM: "
        }else{
            "Miles: "
        }
    }", modifier = Modifier
        .background(MaterialTheme.colorScheme.primary)
        .fillMaxWidth()
        .fillMaxHeight(0.03f)
        , textAlign = TextAlign.Center,
        color = Color.White
    )
    Box(modifier = modifier
        .fillMaxWidth()
        .fillMaxHeight(0.6f)
        .background(MaterialTheme.colorScheme.inverseOnSurface)
    ){
        Column(
            Modifier.align(Alignment.TopStart).fillMaxWidth(0.6f)
        ){
            for(task in stopsList){
                Text(text = "Stop ${task.name} at ${
                    if(distanceInKm == true){
                        task.distance
                    }else{
                        task.distance * 0.621371
                    }
                }",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp)
                        .conditional(task.distance == distanceTravelled) {
                            background(Color.Cyan)
                        }
                        .wrapContentHeight(),
                    textAlign = TextAlign.Center
                )
            }
        }
        Column(
            Modifier.align(Alignment.TopEnd)
                .fillMaxWidth(0.4f)
                .height(50.dp)
                .background(Color.White)
        ){
            Text(text = "Covered: ${if(distanceInKm ==  true){
                distanceTravelled
            }else{
                distanceTravelled * 0.621371
            }}")
            Text(text = "Left: ${if(distanceInKm ==  true){
                (stopsList.size - 1) * 5 - distanceTravelled
            }else{
                ((stopsList.size - 1) * 5 - distanceTravelled) * 0.621371
            }}")
        }
        Text(text = "* On one click of Next Stop , you will reach ${
            if(distanceInKm == true){
                "KM "
            }else{
                "Mile "
            }
        } ahead",
            Modifier
                .align(Alignment.CenterEnd)
                .background(MaterialTheme.colorScheme.primary)
                .height(70.dp)
                .fillMaxWidth(0.4f),
            color = Color.White
        )
    }

}


@Preview(showBackground = true, heightDp = 873, widthDp = 393)
@Composable
fun PreviewOutputScreenWithNormalListComponent(){
    OutputScreenWithNormalListComponent(Modifier,List(10){ i -> Stops(name = "$i",distance = (i * 5))},0,true)
}