package com.example.thefirstandroidapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun UtilitiesComponent(modifier: Modifier,
                       onConvert: () -> Unit,
                       onNextStop: () -> Unit,
                       onLoadStops: () -> Unit
    ){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.primary)
    ) {
            Button( modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 20.dp, top = 30.dp),
                colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = MaterialTheme.colorScheme.primary)
                ,
                onClick = { onConvert() }
            ) {
                Text(text = "Coverter")
            }
            Button( modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = 20.dp, top = 30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = MaterialTheme.colorScheme.primary)
                ,
                onClick = { onNextStop() }
            ) {
                Text(text = "NEXT Stop")
            }
            Button(modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 40.dp),
                colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = MaterialTheme.colorScheme.primary)
                ,
                onClick = { onLoadStops() }
            ) {
                Text(text = "Load Stops")
            }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewUtilitiesComponent(){
    UtilitiesComponent(Modifier,{}, {},{})
}