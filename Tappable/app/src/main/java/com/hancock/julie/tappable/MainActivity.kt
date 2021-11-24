package com.hancock.julie.tappable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import com.hancock.julie.tappable.ui.theme.Purple500
import com.hancock.julie.tappable.ui.theme.TappableTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ClickableBackground()
//            TappableTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(color = MaterialTheme.colors.background) {
//                    Greeting("Android")
//                }
//            }
        }


    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TappableTheme {
        Greeting("Android")
    }
}

data class Point(var x: Float, var y: Float) {
    override fun toString() = "($x,$y)"
}

sealed class Gesture(val start: Point, var timeAfterStart: Long) {
    override fun toString(): String = "$start : $timeAfterStart"
}
class Tap(start: Point, timeAfterStart: Long): Gesture(start, timeAfterStart) {
    override fun toString(): String = "{${super.toString()}}"
}
//class LongPress(start: Point, length: String): Gesture(start)
//class DoubleTap(start: Point): Gesture(start)
//class Drag(start: Point, offset: Point): Gesture(start)
////class VerticalScroll(start: Point, yOffset: Float): Gesture(start)
////class HorizontalScroll(start: Point, xOffset: Float): Gesture(start)
//class Transformation(start: Point, centroid: Point, pan: Point, zoom: Float, rotation: Float): Gesture(start)

//enum class Gesture { Tap, LongPress, DoubleTap, Drag, VerticalScroll, HorizontalScroll, Transformation}
//https://developer.android.com/jetpack/compose/gestures?authuser=2
@Composable
fun ClickableBackground() {
    TappableTheme {
        val startTime: Long = remember { System.nanoTime() }
        val list = remember { mutableListOf<Gesture>()}
        var lastOnPress = remember { Point(0f,0f) }
        Column(
            Modifier
                .fillMaxSize()
                .background(color = Purple500)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onPress = {
                            lastOnPress = Point(it.x, it.y)
                        },
                        onDoubleTap = {},
                        onTap = {
                            list.add(Tap(start = lastOnPress, timeAfterStart = System.nanoTime() - startTime))
                        },
                        onLongPress = {},
                    )
                }
        ){}}



//                .pointerInput(Unit) {
////                    detectTransformGestures { centroid, pan, zoom, rotation ->
////                        println("transform: centroid:$centroid -- pan:$pan -- zoom:$zoom -- rotation:$rotation")
////                    }
//                    detectTapGestures(
//                        onPress = {
////                            println("onPress: $this + ${it.x}, ${it.y}")
//                            lastOnPress = Point(it.x, it.y)
//                        },
//                        onDoubleTap = {
////                            println("onDoubleTap: $it")
//                        },
//                        onTap = {
//                            println("onTap: $it ${System.nanoTime()}")
//                            list.add(
//                                Tap(
//                                    start = lastOnPress,
//                                    timeAfterStart = System.nanoTime() - startTime
//                                )
//                            )
//                            println("$startTime -- after tap list: $list")
//                        },
//                        onLongPress = {
////                            println("onLongPress: $it")
//                        },
//                    )
////                    detectDragGestures { change, dragAmount ->
////                        change.consumeAllChanges()
////                        println("onDrag: offset-(${dragAmount.x},${dragAmount.y}")
////                    }
//
//                }
////                .scrollable(
////                    orientation = Orientation.Vertical,
////                    state = rememberScrollableState { delta ->
////                        println("vertical scroll: $delta")
////                        delta
////                    }
////                )
////                .scrollable(
////                    orientation = Orientation.Horizontal,
////                    state = rememberScrollableState { delta ->
////                        println("horizontal scroll: $delta")
////                        delta
////                    }
////                )
//
//        //swiping
//        //multitouch (panning, zooming, rotating)

//    }
}


fun replay(list: MutableList<Gesture>) {
    TODO("Not yet implemented")
}
