# دليل تحويل مكوّنات Vidora AI إلى Android

## أولًا: حدد تقنية مشروعك
- **Jetpack Compose** إذا كان المشروع Compose.
- **XML Views** إذا كان المشروع مبنيًا على Layout XML.
لا تخلط المكونين عشوائيًا داخل الشاشة نفسها. استعمل هذه المكتبة مرجعًا للمكوّنات المستقلة ومظهرها وسلوكها، لا كتصميم لشاشات كاملة.

## خريطة التحويل

| Web reference | Jetpack Compose | XML / Views |
|---|---|---|
| `.btn-primary` | `Button` مخصص مع `Brush.horizontalGradient` | `MaterialButton` + `GradientDrawable` |
| `.icon-btn` | `IconButton` | `ImageButton` / `MaterialButton` |
| `.avatar` | `Box` + `CircleShape` | `ShapeableImageView` أو `TextView` دائري |
| `.credit` | `Row` + `Surface` | `LinearLayout` أفقي + `GradientDrawable` |
| `.promo` | `Button` مخصص بسطح متدرج | `MaterialButton` مخصص بتدرج |
| `.field input` | `OutlinedTextField` مخصص | `TextInputLayout` + `TextInputEditText` |
| `.switch` | `Switch` | `MaterialSwitch` |
| `.chip` | `FilterChip` | `Chip` |
| `.bottom-nav` | `NavigationBar` | `BottomNavigationView` |
| `.alert` | `Card`/`Snackbar` | `MaterialCardView`/`Snackbar` |
| `.progress` | `LinearProgressIndicator` | `LinearProgressIndicator` |
| `.dialog-preview` | `AlertDialog` مخصص | `MaterialAlertDialogBuilder` |
| `.media-card` | `Card` + `AsyncImage`/video player | `MaterialCardView` + `ImageView`/player |
| `.upload` | `ActivityResultContracts` + `Surface` | Activity Result API + container view |

## قواعد التنفيذ
1. استخرج ألوان `tokens/design-tokens.json` إلى `Color.kt` أو `colors.xml`.
2. استخرج أنصاف الأقطار والمسافات إلى قيم موحدة، لا تكرر أرقامًا ثابتة في كل شاشة.
3. أنشئ ملفات مستقلة للمكونات: `PrimaryButton`, `CreditPill`, `PromoButton`, `BottomNav`, `EmptyState`, `PromptField`. لا تربط المكوّنات بتخطيط شاشة مثل `ProfileHeader` إلا إذا احتجت ذلك داخل التطبيق نفسه.
4. عرّف حالات كل عنصر: normal, pressed, focused, disabled, loading, error, success.
5. لا تستخدم إيموجي كأيقونات إنتاجية؛ استبدلها بحزمة Vector/Material icons أو SVG مرخصة.
6. احترم حواف النظام وStatus Bar وNavigation Bar وInsets، خصوصًا على أجهزة Android الحديثة.
7. اختبر RTL والعربية والإنجليزية والأحجام الصغيرة والمتوسطة والكبيرة.
8. اربط عناصر الواجهة بمنطق التطبيق الحقيقي؛ المكتبة الحالية ليست API ولا نظام توليد فيديو.

## مثال Compose مبسط
```kotlin
@Composable
fun GradientActionButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    val gradient = Brush.horizontalGradient(
        listOf(Color(0xFFFF9A58), Color(0xFFED3F82), Color(0xFF7A48F2))
    )
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier,
        shape = RoundedCornerShape(999.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            disabledContainerColor = Color(0xFF29242E)
        ),
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 12.dp)
    ) {
        Box(
            modifier = Modifier
                .background(gradient, RoundedCornerShape(999.dp))
                .padding(horizontal = 4.dp, vertical = 2.dp)
        ) {
            Text(text, color = Color.White, fontWeight = FontWeight.SemiBold)
        }
    }
}
```

## مثال XML للألوان
```xml
<resources>
    <color name="pv_background">#08090B</color>
    <color name="pv_surface">#141318</color>
    <color name="pv_text_primary">#F7F4F8</color>
    <color name="pv_text_secondary">#A19BA7</color>
    <color name="pv_pink">#ED3F82</color>
    <color name="pv_purple">#7A48F2</color>
    <color name="pv_orange">#FF9A58</color>
</resources>
```

## تحذير
الأمثلة التعليمية أعلاه تحتاج مواءمة مع نسخ Android Gradle Plugin وMaterial Components في مشروعك. لا تستبدل ملفات المشروع الحالية مباشرة قبل مراجعة بنيته.
