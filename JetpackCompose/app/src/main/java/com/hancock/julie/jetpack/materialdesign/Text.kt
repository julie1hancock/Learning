package com.hancock.julie.jetpack.materialdesign

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontFamily.Companion.Cursive
import androidx.compose.ui.text.font.FontFamily.Companion.Default
import androidx.compose.ui.text.font.FontFamily.Companion.Monospace
import androidx.compose.ui.text.font.FontFamily.Companion.SansSerif
import androidx.compose.ui.text.font.FontFamily.Companion.Serif
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.hancock.julie.jetpack.ui.theme.circle
import com.hancock.julie.jetpack.ui.theme.colorsForTesting
import com.hancock.julie.jetpack.ui.theme.diamond
import com.hancock.julie.jetpack.ui.theme.dpSizesForTesting
import com.hancock.julie.jetpack.ui.theme.floatListForTesting
import com.hancock.julie.jetpack.ui.theme.getModifier
import com.hancock.julie.jetpack.ui.theme.purple1
import com.hancock.julie.jetpack.ui.theme.purple2
import com.hancock.julie.jetpack.ui.theme.roundCorners
import com.hancock.julie.jetpack.ui.theme.roundCorners2
import com.hancock.julie.jetpack.ui.theme.shapesForTesting
import com.hancock.julie.jetpack.ui.theme.six_sp
import com.hancock.julie.jetpack.ui.theme.spSizesForTesting
import com.hancock.julie.jetpack.ui.theme.teal1
import com.hancock.julie.jetpack.ui.theme.ten_sp
import com.hancock.julie.jetpack.ui.theme.wonkeyCorners
import com.hancock.julie.jetpack.ui.theme.zero

@Composable
fun MaterialText(
    text: String,
    fontSize: TextUnit = TextUnit.Unspecified,
    color: Color = Color.Unspecified,
    italic: Boolean = false,
    fontWeight: FontWeight = Normal,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    underline: Boolean = false,
    lineThrough: Boolean = false,
    font: FontFamily = FontFamily.Default,

    padding: Dp? = zero,
    backgroundColor: Color? = null,
    width: Dp? = null,
    height: Dp? = null,
    percentWidthFill: Float? = null,
    percentHeightFill: Float? = null,
    opacity: Float? = null, //alpha
    rotateAngle: Float? = null,
    border: Triple<Dp, Color, Shape>? = null,
    clipShape: Shape? = null,
) {
    val modifier = getModifier(
        padding = padding,
        clipShape = clipShape,
        backgroundColor = backgroundColor,
        width = width,
        height = height,
        percentWidthFill = percentWidthFill,
        percentHeightFill = percentHeightFill,
        opacity = opacity,
        rotate = rotateAngle,
        border = border)

    Text(text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontStyle = if (italic) FontStyle.Italic else FontStyle.Normal,
        fontWeight = fontWeight,
        fontFamily = font,
        letterSpacing = letterSpacing,
        textDecoration = if (underline) TextDecoration.Underline else if (lineThrough) TextDecoration.LineThrough else TextDecoration.None,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines)

//
//
//    val modifier = getModifier(
//        size = size,
//        shape = shape,
//        padding = padding
//    )
//
//    Image(
//        painter = painterResource(id = icon),
//        contentDescription = "",
//        modifier = modifier,
//        colorFilter = color?.let {
//            ColorFilter.tint(color = color, blendMode = BlendMode.SrcIn)
//        }
//    )
}

data class MaterialTextInfo(
    val text: String,
    val fontSize: TextUnit = TextUnit.Unspecified,
    val color: Color = Color.Unspecified,
    val italic: Boolean = false,
    val fontWeight: FontWeight = Normal,
    val letterSpacing: TextUnit = TextUnit.Unspecified,
    val textAlign: TextAlign? = null,
    val maxLines: Int = Int.MAX_VALUE,
    val overflow: TextOverflow = TextOverflow.Ellipsis,
    val underline: Boolean = false,
    val lineThrough: Boolean = false,
    val font: FontFamily = FontFamily.Default,
    val padding: Dp? = zero,
    val backgroundColor: Color? = null,
    val width: Dp? = null,
    val height: Dp? = null,
    val percentWidthFill: Float? = null,
    val percentHeightFill: Float? = null,
    val opacity: Float? = null, //alpha
    val rotateAngle: Float? = null,
    val border: Triple<Dp, Color, Shape>? = null,
    val clipShape: Shape? = null,
)

val stringsForTesting: List<String> = listOf(
    "",
    "A",
    "Julie",
    "Hello, World!",
    "Lorem ipsum dolor sit amet,",
    "consectetur adipiscing elit. Nunc viverra fringilla arcu id commodo. ",
    "Integer tristique dignissim nisi, mattis pharetra tellus faucibus sollicitudin. Nam rutrum diam a faucibus viverra. Mauris id mi augue. Quisque ultrices eros nec erat rutrum",
    "In odio erat, suscipit aliquet cursus vel, mattis quis nisi. Cras nec justo consequat, sodales nisi at, scelerisque enim. Aenean sed massa sed enim commodo tristique quis in nunc. ",
    "Aliquam in nibh fermentum, vehicula dui id, elementum purus. Quisque non tempor tellus. Donec sollicitudin mi vitae massa sollicitudin tristique. Maecenas at odio ligula. Nam sit amet risus mi. Nulla finibus et est eu sagittis. Quisque finibus ",
    "vitae pharetra nisi volutpat. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Quisque id justo risus. Sed id tincidunt lorem. Nullam mollis nisi metus, a tempor nulla feugiat vel. Integer at tincidunt mi. Nam euismod orci et ante dapibus, interdum fermentum dolor aliquam.",
    "Nam vulputate dictum magna eleifend molestie. Duis feugiat eget neque eget malesuada. Fusce eu sagittis lorem, eu venenatis arcu. Aenean consequat lectus quis leo suscipit lobortis. Interdum et malesuada fames ac ante ipsum primis in faucibus. Aenean nec auctor nulla. Fusce eget elit eget purus tempor molestie eu tempus nisi. Nullam non tempus turpis. Nulla facilisi. Morbi nec euismod purus.",
    "Cras vel nisl sollicitudin, sagittis sem nec, cursus metus. Curabitur rhoncus nulla non consectetur dapibus. In vitae dapibus sapien. Praesent non hendrerit erat, eu volutpat ex. Nam ornare dignissim felis. Fusce faucibus blandit metus ac pharetra. Aliquam aliquet eget ante convallis imperdiet. Etiam in diam libero. Etiam ac blandit risus. Duis commodo neque sit amet erat convallis, at auctor elit porttitor. Curabitur ac lorem urna. Vivamus nisl nunc, gravida nec nibh vitae, laoreet facilisis velit. Aliquam id augue in arcu bibendum tristique non non velit. Vestibulum commodo ex eget sem rhoncus ullamcorper. Aliquam eget risus sit amet massa lacinia sollicitudin. Ut vestibulum molestie lacus, at varius diam lobortis in. Quisque feugiat vulputate elit vitae cursus. Ut tempus risus non pulvinar mollis. Nulla facilisi. Etiam dapibus nibh magna, consectetur malesuada metus eleifend ac. Duis nibh quam, scelerisque id arcu vitae, imperdiet rhoncus dolor. Ut sollicitudin nulla quam, et dapibus neque laoreet eu. Ut ac ipsum pulvinar, elementum ex non, sodales turpis. Nulla facilisi. Ut congue odio quis mauris dignissim, non rutrum lorem sollicitudin.",
)


//
//////////// FOR TESTING:
class MaterialTextInfoProvider : PreviewParameterProvider<MaterialTextInfo> {
    private val text = "Hello world"
    private val textLong = "Cras vel nisl sollicitudin, sagittis sem nec, cursus metus. Curabitur rhoncus nulla non consectetur dapibus. In vitae dapibus sapien. Praesent non hendrerit erat, eu volutpat ex. Nam ornare dignissim felis. Fusce faucibus blandit metus ac pharetra. Aliquam aliquet eget ante convallis imperdiet. Etiam in diam libero. Etiam ac blandit risus. Duis commodo neque sit amet erat convallis, at auctor elit porttitor. Curabitur ac lorem urna. Vivamus nisl nunc, gravida nec nibh vitae, laoreet facilisis velit. Aliquam id augue in arcu bibendum tristique non non velit. Vestibulum commodo ex eget sem rhoncus ullamcorper. Aliquam eget risus sit amet massa lacinia sollicitudin. Ut vestibulum molestie lacus, at varius diam lobortis in. Quisque feugiat vulputate elit vitae cursus. Ut tempus risus non pulvinar mollis. Nulla facilisi. Etiam dapibus nibh magna, consectetur malesuada metus eleifend ac. Duis nibh quam, scelerisque id arcu vitae, imperdiet rhoncus dolor. Ut sollicitudin nulla quam, et dapibus neque laoreet eu. Ut ac ipsum pulvinar, elementum ex non, sodales turpis. Nulla facilisi. Ut congue odio quis mauris dignissim, non rutrum lorem sollicitudin."


    private val textTest: List<MaterialTextInfo> = stringsForTesting.map {
        MaterialTextInfo(text = it)
    }

    private val fontSizeTest: List<MaterialTextInfo> = spSizesForTesting.map {
        MaterialTextInfo(text = text, fontSize = it)
    }

    private val letterSpacingTest: List<MaterialTextInfo> = spSizesForTesting.map {
        MaterialTextInfo(text = text, letterSpacing = it)
    }

    private val textColorTest: List<MaterialTextInfo> = colorsForTesting.filterNotNull().map {
        MaterialTextInfo(text = text, color = it)
    }

    private val backgroundColorTest: List<MaterialTextInfo> = colorsForTesting.filterNotNull().map {
        MaterialTextInfo(text = text, backgroundColor = it, padding = 8.dp)
    }

    //TODO
    private val alignTest: List<MaterialTextInfo> = TextAlign.values().map {
        MaterialTextInfo(text = text, textAlign = it)
    }

    private val stylingTest: List<MaterialTextInfo> = listOf(
        MaterialTextInfo(text = text, italic = true),
        MaterialTextInfo(text = text, italic = false),
        MaterialTextInfo(text = text, underline = true),
        MaterialTextInfo(text = text, underline = false),
        MaterialTextInfo(text = text, lineThrough = true),
        MaterialTextInfo(text = text, lineThrough = false)
    )

    private val boldTest: List<MaterialTextInfo> = listOf(
        MaterialTextInfo(text = text, fontWeight = FontWeight.Thin),
        MaterialTextInfo(text = text, fontWeight = FontWeight.ExtraLight),
        MaterialTextInfo(text = text, fontWeight = FontWeight.Light),
        MaterialTextInfo(text = text, fontWeight = FontWeight.Normal),
        MaterialTextInfo(text = text, fontWeight = FontWeight.Medium),
        MaterialTextInfo(text = text, fontWeight = FontWeight.SemiBold),
        MaterialTextInfo(text = text, fontWeight = FontWeight.Bold),
        MaterialTextInfo(text = text, fontWeight = FontWeight.ExtraBold),
        MaterialTextInfo(text = text, fontWeight = FontWeight.Black),
    )

    private val fontFamilyTest: List<MaterialTextInfo> = listOf(
        MaterialTextInfo(text = text, font = Default),
        MaterialTextInfo(text = text, font = SansSerif),
        MaterialTextInfo(text = text, font = Serif),
        MaterialTextInfo(text = text, font = Monospace),
        MaterialTextInfo(text = text, font = Cursive),
    )

    private val rotateTest: Sequence<MaterialTextInfo> = floatListForTesting.map {
        MaterialTextInfo(text = text, rotateAngle = it)
    }.asSequence()

    //TODO
    private val opacityTest: List<MaterialTextInfo> = floatListForTesting.map {
        MaterialTextInfo(text = text, opacity = it)
    }

    private val paddingTest: List<MaterialTextInfo> = dpSizesForTesting.map {
        MaterialTextInfo(text = text, padding = it)
    }

    private val widthHeightTest: List<MaterialTextInfo> = dpSizesForTesting.mapIndexed { index, dp ->
        MaterialTextInfo(text = text, width = dp, height = dpSizesForTesting[dpSizesForTesting.size-index-1], backgroundColor = purple2)
    }

    private val clipTest: List<MaterialTextInfo> = colorsForTesting.filterNotNull().map {
        MaterialTextInfo(text = text, clipShape = shapesForTesting.random(), backgroundColor = it, fontSize = ten_sp)
    }

    //TODO:
    private val borderTest: List<MaterialTextInfo> = listOf(
        MaterialTextInfo(text = text, fontSize = ten_sp, border = Triple(2.dp, purple1, wonkeyCorners)),
        MaterialTextInfo(text = text, fontSize = ten_sp, border = Triple(4.dp, purple2, circle)),
        MaterialTextInfo(text = text, fontSize = ten_sp, border = Triple(9.dp, purple1, diamond)),
        MaterialTextInfo(text = text, fontSize = ten_sp, border = Triple(12.dp, purple2, roundCorners2)),
        MaterialTextInfo(text = text, fontSize = ten_sp, border = Triple(16.dp, teal1, roundCorners)),
    )

    private val longStringTest: List<MaterialTextInfo> = listOf(
        MaterialTextInfo(text = "1 "+textLong, fontSize = six_sp, maxLines = 2, overflow = TextOverflow.Clip),
        MaterialTextInfo(text = "2 "+textLong, fontSize = six_sp, maxLines = 2, overflow = TextOverflow.Visible),
        MaterialTextInfo(text = "3 "+textLong, fontSize = six_sp, maxLines = 2, overflow = TextOverflow.Ellipsis),
        MaterialTextInfo(text = "6 "+textLong, fontSize = six_sp, maxLines = 1),
    )

    override val values: Sequence<MaterialTextInfo> = (longStringTest).asSequence()
}

@Preview
@Composable
fun PreviewMaterialText(@PreviewParameter(MaterialTextInfoProvider::class) info: MaterialTextInfo) {
    MaterialText(
        text = info.text,
        fontSize = info.fontSize,
        color = info.color,
        italic = info.italic,
        fontWeight = info.fontWeight,
        letterSpacing = info.letterSpacing,
        textAlign = info.textAlign,
        maxLines = info.maxLines,
        overflow = info.overflow,
        underline = info.underline,
        lineThrough = info.lineThrough,
        font = info.font,
        padding = info.padding,
        backgroundColor = info.backgroundColor,
        width = info.width,
        height = info.height,
        percentWidthFill = info.percentWidthFill,
        percentHeightFill = info.percentHeightFill,
        opacity = info.opacity,
        rotateAngle = info.rotateAngle,
        border = info.border,
        clipShape = info.clipShape,
    )
}

