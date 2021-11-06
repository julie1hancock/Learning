package com.hancock.julie.jetpack

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hancock.julie.jetpack.ui.theme.JetpackTheme

//Buttons
//Buttons: floating action button


@Composable
fun Text1(text: String?) {
    text?.let {
        Text(
            text = it,
            modifier = Modifier.padding(all = 4.dp),
            style = MaterialTheme.typography.body2,
        )
    }
}


@Composable
fun Button1(message: String?, image: Int?) {

//
//
//    when {
//        message != null && image != null -> ;
//        message != null -> ;
//        image != null -> ;
//        else -> Spacer(modifier = Modifier.padding(0.dp))
//    }
}

