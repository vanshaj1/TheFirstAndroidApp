package com.example.thefirstandroidapp

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color

@Composable
fun ProgressTrackComponent(modifier: Modifier,
                           stopsListSize: Int,
                           distanceTravelled: Int
    ){
    LinearProgressIndicator( progress = if(stopsListSize == 10){
                                            0.0222f * distanceTravelled
                                        }else{
                                            0.0106f * distanceTravelled
                                        },
        modifier = Modifier
            .fillMaxWidth(1f)
            .height(10.dp)
            .clip(RoundedCornerShape(10.dp)),
        color = Color.Cyan
    )
}
// 0.111f * 9 -> when 10 stops -> 1 stop distance 0.111 -> 0.111/5 = 0.0222
// 0.053f * 19 -> when 20 stops -> 1 stop distance 0.053 -> 0.053/ 5 = 0.0106
@Preview
@Composable
fun PreviewProgressTrackComponent(){
    ProgressTrackComponent(Modifier,10,0)
}