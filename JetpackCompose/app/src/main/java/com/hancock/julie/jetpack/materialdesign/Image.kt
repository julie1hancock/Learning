package com.hancock.julie.jetpack.materialdesign

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.Dp
import com.hancock.julie.jetpack.R
import com.hancock.julie.jetpack.ui.theme.*

@Composable
fun MaterialImage(
    icon: Int,
    size: Dp = three,
    shape: Shape? = null,
    color: Color?,
    padding: Dp = zero
) {
    val modifier = getModifier(
        size = size,
        clipShape = shape,
        padding = padding
    )

    Image(
        painter = painterResource(id = icon),
        contentDescription = "",
        modifier = modifier,
        colorFilter = color?.let {
            ColorFilter.tint(color = color, blendMode = BlendMode.SrcIn)
        }
    )
}

////////// FOR TESTING:
@Preview
@Composable
fun PreviewMaterialImages(@PreviewParameter(MaterialImageInfoProvider::class) info: MaterialImageInfo) {
    MaterialImage(icon = info.icon, size = info.size, shape = info.shape, color = info.color, padding = info.padding)
}

class MaterialImageInfoProvider : PreviewParameterProvider<MaterialImageInfo> {
    val icon = R.drawable.profile_picture

    val sizeTest: Sequence<MaterialImageInfo> = dpSizesForTesting.map {
        MaterialImageInfo(icon = icon, size = it, shape = normal)
    }.asSequence()
    val paddingTest: Sequence<MaterialImageInfo> = dpSizesForTesting.map {
        MaterialImageInfo(icon = icon, size = twenty_five, padding = it, shape = normal)
    }.asSequence()
    val shapeTest = shapesForTesting.map {
        MaterialImageInfo(icon = icon, size = twenty_five, shape = it)
    }.asSequence()
    val colorTest = colorsForTesting.map {
        MaterialImageInfo(icon = icon, size = twenty_five, shape = normal, color = it)
    }.asSequence()
    val randomTest = dpSizesForTesting.map {
        MaterialImageInfo(icon = icon, size = dpSizesForTesting.random(), padding = dpSizesForTesting.random(), shape = shapesForTesting.random(), color = colorsForTesting.random())
    }.asSequence()

    override val values: Sequence<MaterialImageInfo> = sequenceOf(
        MaterialImageInfo(icon = icon, size = six, padding = two, shape = circle, color = teal1),
        MaterialImageInfo(icon = icon, size = twenty_five, padding = eight, shape = circle, color = purple1),
        MaterialImageInfo(icon = icon, size = twenty_five, padding = two, shape = diamond, color = purple2),
        MaterialImageInfo(icon = icon, size = twenty_five, padding = ten, shape = circle, color = null),
        MaterialImageInfo(icon = icon, size = twenty_five, padding = one, color = purple2),
        MaterialImageInfo(icon = icon, size = twenty_five, padding = six, shape = circle, color = purple2),
    )
}

data class MaterialImageInfo(
    val icon: Int,
    val size: Dp = three,
    val shape: Shape? = null,
    val color: Color? = null,
    val padding: Dp = zero
)
