package replace.with.your.app.package

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape

/**
 * Recreated visual tokens estimated from the supplied screenshot.
 * These are not recovered source values. Tune against a real device screenshot.
 */
object AiShortsVisualTokens {
    val Canvas = Color(0xFF060813)
    val CanvasTop = Color(0xFF0A0B1B)
    val Surface = Color(0xFF0D1225)
    val SurfaceRaised = Color(0xFF11172D)
    val SurfaceDeep = Color(0xFF090E1E)
    val SurfaceBlue = Color(0xFF121C39)

    val TextPrimary = Color(0xFFF2F1FF)
    val TextSecondary = Color(0xFFB0B0CE)
    val TextMuted = Color(0xFF777D9F)

    val Rose = Color(0xFFF16CCB)
    val Pink = Color(0xFFEA62C2)
    val Violet = Color(0xFFA65BFA)
    val Blue = Color(0xFF4E7DFF)
    val Cyan = Color(0xFF39C8FF)
    val BorderQuiet = Color(0xFF252D49)

    val PrimaryAction = Brush.horizontalGradient(
        listOf(Color(0xFF4C83FF), Color(0xFF9A50F3), Color(0xFFEB66CA))
    )

    val BannerFill = Brush.horizontalGradient(
        colorStops = arrayOf(
            0.0f to Color(0xFF24162F),
            0.18f to Color(0xFF11182F),
            0.56f to Color(0xFF0C142B),
            0.82f to Color(0xFF17152F),
            1.0f to Color(0xFF32172F)
        )
    )

    val QuietStroke = Brush.horizontalGradient(
        listOf(Color(0xFF6D315E), Color(0xFF293A63), Color(0xFF5B3B72))
    )

    val SelectedStroke = Brush.linearGradient(
        listOf(Cyan, Blue, Violet, Color(0xFF3BAFF7))
    )

    val SelectedTabStroke = Brush.horizontalGradient(
        listOf(Rose, Violet, Cyan)
    )

    val CardFill = Brush.linearGradient(
        listOf(Color(0xFF14182D), Color(0xFF0B1021), Color(0xFF0D1327))
    )

    val AmbientTop = Brush.radialGradient(
        colors = listOf(Color(0x35E86ACB), Color(0x12A65BFA), Color.Transparent)
    )

    val BannerShape = RoundedCornerShape(23.dp)
    val ModelShape = RoundedCornerShape(22.dp)
    val ReferenceCardShape = RoundedCornerShape(20.dp)
    val PillShape = RoundedCornerShape(100.dp)

    val BannerHeight = 90.dp
    val TabHeight = 46.dp
    val ModelCardHeight = 88.dp
    val ReferenceCardMinHeight = 188.dp
}
