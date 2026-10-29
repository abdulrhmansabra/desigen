package replace.with.your.app.package

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val T = AiShortsVisualTokens

/**
 * Reusable Pro banner. Supply original decorative artwork and crown icon using slots.
 * No drop shadow is added; edge color is a thin gradient border.
 */
@Composable
fun AiShortsProBanner(
    title: String,
    subtitle: String,
    actionLabel: String,
    modifier: Modifier = Modifier,
    onAction: () -> Unit = {},
    crown: (@Composable () -> Unit)? = null,
    decorativeArt: (@Composable BoxScope.() -> Unit)? = null
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(T.BannerHeight)
            .clip(T.BannerShape)
            .background(T.BannerFill)
            .border(BorderStroke(1.dp, T.QuietStroke), T.BannerShape)
            .padding(horizontal = 14.dp, vertical = 10.dp)
    ) {
        decorativeArt?.invoke(this)
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    title,
                    color = T.TextPrimary,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(Modifier.height(5.dp))
                Text(
                    subtitle,
                    color = T.TextSecondary,
                    fontSize = 12.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Box(
                modifier = Modifier
                    .clip(T.PillShape)
                    .background(T.PrimaryAction)
                    .padding(horizontal = 14.dp, vertical = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(actionLabel, color = Color.White, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
            }
            if (crown != null) {
                Box(Modifier.size(20.dp), contentAlignment = Alignment.Center) { crown() }
            }
        }
    }
}

/** One tab in the generation-type selector. The caller controls selection and actions. */
@Composable
fun AiShortsGenerationTab(
    label: String,
    selected: Boolean,
    modifier: Modifier = Modifier,
    icon: (@Composable () -> Unit)? = null,
    onClick: () -> Unit = {}
) {
    val shape = T.PillShape
    Column(
        modifier = modifier
            .height(T.TabHeight)
            .clip(shape)
            .background(if (selected) Brush.horizontalGradient(listOf(Color(0xFF251A38), Color(0xFF172A4C))) else Brush.horizontalGradient(listOf(T.Surface, T.SurfaceDeep)))
            .border(
                BorderStroke(1.dp, if (selected) T.SelectedTabStroke else T.QuietStroke),
                shape
            )
            .padding(horizontal = 12.dp, vertical = 7.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            if (icon != null) Box(Modifier.size(21.dp), contentAlignment = Alignment.Center) { icon() }
            Text(
                label,
                color = T.TextPrimary,
                fontSize = 12.sp,
                fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Medium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        if (selected) {
            Spacer(Modifier.height(4.dp))
            Box(
                Modifier
                    .width(66.dp)
                    .height(2.dp)
                    .clip(T.PillShape)
                    .background(T.SelectedTabStroke)
            )
        }
    }
}

/** Featured model card with caller-provided original artwork. */
@Composable
fun AiShortsFeaturedModelCard(
    modelName: String,
    badge: String,
    description: String,
    modifier: Modifier = Modifier,
    artwork: Painter? = null,
    chevron: (@Composable () -> Unit)? = null,
    badgeContent: (@Composable () -> Unit)? = null
) {
    val shape = T.ModelShape
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(T.ModelCardHeight)
            .clip(shape)
            .background(T.CardFill)
            .border(BorderStroke(1.dp, T.QuietStroke), shape)
    ) {
        if (artwork != null) {
            Image(
                painter = artwork,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape)
            )
            Box(
                Modifier
                    .fillMaxSize()
                    .background(
                        Brush.horizontalGradient(
                            0.0f to Color.Transparent,
                            0.28f to Color(0x3310182E),
                            0.48f to Color(0xE6090D1C),
                            1.0f to Color(0xFF0D1225)
                        )
                    )
            )
        }
        Row(
            Modifier.fillMaxSize().padding(horizontal = 14.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Spacer(Modifier.weight(1f))
            Column(
                modifier = Modifier.weight(2.8f),
                verticalArrangement = Arrangement.Center
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(7.dp)) {
                    Text(modelName, color = T.TextPrimary, fontSize = 15.sp, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis)
                    Box(
                        Modifier.clip(T.PillShape).background(Brush.horizontalGradient(listOf(Color(0xFF422052), Color(0xFF75418A)))).padding(horizontal = 8.dp, vertical = 3.dp)
                    ) {
                        if (badgeContent != null) badgeContent()
                        else Text(badge, color = T.TextPrimary, fontSize = 9.sp, maxLines = 1)
                    }
                }
                Spacer(Modifier.height(5.dp))
                Text(description, color = T.TextSecondary, fontSize = 11.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
            }
            if (chevron != null) Box(Modifier.size(18.dp), contentAlignment = Alignment.Center) { chevron() }
        }
    }
}

/** Section heading; intentionally has no surrounding card/surface. */
@Composable
fun AiShortsReferenceHeading(
    title: String,
    modifier: Modifier = Modifier,
    infoIcon: (@Composable () -> Unit)? = null
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        if (infoIcon != null) Box(Modifier.size(20.dp), contentAlignment = Alignment.Center) { infoIcon() }
        Text(title, color = T.TextPrimary, fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
    }
}

/**
 * Reusable reference-image count card. Pass actual thumbnail painters; the original screenshot art
 * is not included because its source files were not available.
 */
@Composable
fun AiShortsReferenceCountCard(
    count: Int,
    badge: String,
    caption: String,
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    icon: (@Composable () -> Unit)? = null,
    thumbnails: List<Painter> = emptyList(),
    onAdd: () -> Unit = {}
) {
    val shape = T.ReferenceCardShape
    val stroke = if (selected) T.SelectedStroke else T.QuietStroke
    Column(
        modifier = modifier
            .height(T.ReferenceCardMinHeight)
            .clip(shape)
            .background(T.CardFill)
            .border(BorderStroke(1.dp, stroke), shape)
            .padding(horizontal = 10.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(7.dp)
    ) {
        Box(Modifier.fillMaxWidth().height(25.dp)) {
            if (icon != null) {
                Box(
                    Modifier.align(Alignment.CenterStart).size(39.dp).clip(CircleShape)
                        .background(Brush.linearGradient(listOf(Color(0xFF1B2341), Color(0xFF10152B))))
                        .border(1.dp, T.QuietStroke, CircleShape),
                    contentAlignment = Alignment.Center
                ) { icon() }
            }
            Box(
                Modifier.align(Alignment.TopEnd)
                    .clip(T.PillShape)
                    .background(if (selected) Brush.horizontalGradient(listOf(T.Cyan, Color(0xFF4D9EFF))) else Brush.horizontalGradient(listOf(Color(0xFF302049), Color(0xFF66417D))))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(badge, color = if (selected) Color(0xFF091126) else T.TextPrimary, fontSize = 9.sp, fontWeight = FontWeight.SemiBold, maxLines = 1)
            }
        }
        Text("إضافة $count", color = T.TextPrimary, fontSize = 16.sp, fontWeight = FontWeight.Bold, maxLines = 1)
        Row(
            modifier = Modifier.fillMaxWidth().height(39.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            thumbnails.take(count).forEach { painter ->
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier.weight(1f).height(37.dp).clip(RoundedCornerShape(7.dp))
                )
            }
            if (thumbnails.isEmpty()) {
                repeat(count.coerceIn(1, 3)) {
                    Box(
                        Modifier.weight(1f).height(37.dp).clip(RoundedCornerShape(7.dp))
                            .background(Brush.linearGradient(listOf(Color(0xFF202A47), Color(0xFF10172A))))
                            .border(1.dp, T.QuietStroke, RoundedCornerShape(7.dp))
                    )
                }
            }
            Box(
                Modifier.size(37.dp).clip(CircleShape)
                    .background(T.SurfaceBlue)
                    .border(1.dp, T.QuietStroke, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text("+", color = T.TextSecondary, fontSize = 23.sp, fontWeight = FontWeight.Light)
            }
        }
        Spacer(Modifier.weight(1f))
        Text(
            caption,
            color = T.TextMuted,
            fontSize = 9.sp,
            lineHeight = 12.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}
