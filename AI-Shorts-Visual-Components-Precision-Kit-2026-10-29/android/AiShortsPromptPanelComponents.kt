package replace.with.your.app.package

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val PromptTokens get() = AiShortsVisualTokens

/**
 * Recreated prompt editor panel from the supplied crop.
 * Uses a real editable BasicTextField; caller owns the text state and behavior.
 * The screenshot's exact font and source dimensions were not available, so tune against device captures.
 */
@Composable
fun AiShortsPromptEditor(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "قم بتحميل صورة/فيديو مرجعي، وأدخل نصًا، واصف الفيديو الذي تريد إنشاءه...",
    characterLimit: Int = 5000,
    leadingActionLabel: String = "توليد تلقائي",
    leadingAction: (@Composable () -> Unit)? = null,
    trailingEditIcon: (@Composable () -> Unit)? = null,
    onLeadingActionClick: () -> Unit = {},
    minHeight: Dp = 194.dp
) {
    val shape = RoundedCornerShape(24.dp)
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(minHeight)
            .clip(shape)
            .background(
                Brush.linearGradient(
                    listOf(Color(0xFF101528), Color(0xFF0B1020), Color(0xFF0D1326))
                )
            )
            .border(BorderStroke(1.dp, Color(0xFF252D49)), shape)
            .padding(horizontal = 14.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(Modifier.fillMaxWidth().weight(1f)) {
            if (value.isEmpty()) {
                Text(
                    text = placeholder,
                    color = Color(0xFF9298BA),
                    fontSize = 16.sp,
                    lineHeight = 25.sp,
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth().align(Alignment.TopEnd).padding(top = 2.dp)
                )
            }
            BasicTextField(
                value = value,
                onValueChange = { if (it.length <= characterLimit) onValueChange(it) },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(
                    color = PromptTokens.TextPrimary,
                    fontSize = 16.sp,
                    lineHeight = 25.sp,
                    textAlign = TextAlign.Start
                ),
                cursorBrush = Brush.verticalGradient(listOf(PromptTokens.Cyan, PromptTokens.Violet))
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(100.dp))
                    .background(Brush.horizontalGradient(listOf(Color(0xFF22243F), Color(0xFF252743))))
                    .clickable(onClick = onLeadingActionClick)
                    .padding(horizontal = 12.dp, vertical = 9.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                if (leadingAction != null) Box(Modifier.size(20.dp), contentAlignment = Alignment.Center) { leadingAction() }
                Text(leadingActionLabel, color = PromptTokens.TextSecondary, fontSize = 13.sp)
            }
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    "${value.length}/$characterLimit",
                    color = PromptTokens.TextMuted,
                    fontSize = 13.sp
                )
                if (trailingEditIcon != null) Box(Modifier.size(20.dp), contentAlignment = Alignment.Center) { trailingEditIcon() }
            }
        }
    }
}

/** Compact matte option chip used for aspect ratio, style and advanced settings. */
@Composable
fun AiShortsSettingChip(
    title: String,
    value: String? = null,
    modifier: Modifier = Modifier,
    icon: (@Composable () -> Unit)? = null,
    trailingChevron: (@Composable () -> Unit)? = null,
    onClick: () -> Unit = {},
    minHeight: Dp = 66.dp
) {
    val shape = RoundedCornerShape(19.dp)
    Row(
        modifier = modifier
            .height(minHeight)
            .clip(shape)
            .background(
                Brush.linearGradient(
                    listOf(Color(0xFF1A1D35), Color(0xFF11162B), Color(0xFF151A31))
                )
            )
            .border(BorderStroke(1.dp, Color(0xFF252D49)), shape)
            .clickable(onClick = onClick)
            .padding(horizontal = 10.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        if (icon != null) Box(Modifier.size(28.dp), contentAlignment = Alignment.Center) { icon() }
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                title,
                color = PromptTokens.TextSecondary,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center
            )
            if (value != null) {
                Spacer(Modifier.height(2.dp))
                Text(
                    value,
                    color = PromptTokens.TextPrimary,
                    fontSize = 14.sp,
                    lineHeight = 17.sp,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
            }
        }
        if (trailingChevron != null) Box(Modifier.size(14.dp), contentAlignment = Alignment.Center) { trailingChevron() }
    }
}

/** Three-option row matching the compact setting controls in the reference. */
@Composable
fun AiShortsGenerationSettingsRow(
    modifier: Modifier = Modifier,
    aspectRatio: String = "9:16",
    style: String = "واقعي",
    aspectIcon: (@Composable () -> Unit)? = null,
    styleIcon: (@Composable () -> Unit)? = null,
    advancedIcon: (@Composable () -> Unit)? = null,
    chevron: (@Composable () -> Unit)? = null,
    onAspectRatioClick: () -> Unit = {},
    onStyleClick: () -> Unit = {},
    onAdvancedClick: () -> Unit = {}
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AiShortsSettingChip(
            title = "نسبة العرض",
            value = aspectRatio,
            modifier = Modifier.weight(1f),
            icon = aspectIcon,
            trailingChevron = chevron,
            onClick = onAspectRatioClick
        )
        AiShortsSettingChip(
            title = "الأسلوب",
            value = style,
            modifier = Modifier.weight(1f),
            icon = styleIcon,
            trailingChevron = chevron,
            onClick = onStyleClick
        )
        AiShortsSettingChip(
            title = "الإعدادات المتقدمة",
            modifier = Modifier.weight(1f),
            icon = advancedIcon,
            trailingChevron = chevron,
            onClick = onAdvancedClick
        )
    }
}

/** Large primary creation action. It deliberately has no outer glow or drop shadow. */
@Composable
fun AiShortsCreateButton(
    label: String = "إنشاء",
    modifier: Modifier = Modifier,
    icon: (@Composable () -> Unit)? = null,
    chevron: (@Composable () -> Unit)? = null,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
    height: Dp = 74.dp
) {
    val shape = RoundedCornerShape(100.dp)
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .clip(shape)
            .background(
                if (enabled) PromptTokens.PrimaryAction
                else Brush.horizontalGradient(listOf(Color(0xFF55566C), Color(0xFF4C4D68)))
            )
            .border(BorderStroke(1.dp, Color(0x55F4B8FF)), shape)
            .clickable(enabled = enabled, onClick = onClick)
            .padding(horizontal = 22.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        if (icon != null) {
            Box(Modifier.size(28.dp), contentAlignment = Alignment.Center) { icon() }
            Spacer(Modifier.width(12.dp))
        }
        Text(
            label,
            color = Color.White,
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1
        )
        if (chevron != null) {
            Spacer(Modifier.width(12.dp))
            Box(Modifier.size(18.dp), contentAlignment = Alignment.Center) { chevron() }
        }
    }
}

/** Label header for the prompt panel. Icon remains caller-supplied to use the app's icon family. */
@Composable
fun AiShortsPromptSectionHeader(
    title: String = "المطالبة",
    modifier: Modifier = Modifier,
    sparkle: (@Composable () -> Unit)? = null
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Text(title, color = PromptTokens.TextPrimary, fontSize = 19.sp, fontWeight = FontWeight.Bold)
        if (sparkle != null) {
            Spacer(Modifier.width(9.dp))
            Box(Modifier.size(25.dp), contentAlignment = Alignment.Center) { sparkle() }
        }
    }
}
