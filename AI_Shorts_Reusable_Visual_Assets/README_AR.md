# AI Shorts — أصول بصرية قابلة لإعادة الاستخدام

تم إعداد هذه الحزمة كأصول SVG متجهية قابلة للتحرير، مستوحاة من الصورة المرجعية المرفقة في المحادثة. الهوية: خلفية فحمية/كحلية، أسطح داكنة مطفية، وتدرجات بنفسجية ووردية وزرقاء. لا تتضمن الحزمة تأثيرات زجاجية أو ظلالًا خارجية ثقيلة.

## الملف المركب والمواصفات
- `SVG/reference_screen_composite.svg`: معاينة SVG مركّبة للشاشة كاملة، مرتبة من شريط الحالة حتى التنقل السفلي. تحتوي على رسوم توضيحية مبسطة بدل بعض الصور الأصلية.
- `REFERENCE_SCREEN_SPEC_AR.md`: ترتيب الشاشة ومواصفات الهوية البصرية وحدود المطابقة.
- `PALETTE.txt`: ألوان الهوية الأساسية.

## الخلفية والأصول
- `SVG/screen_background.svg`: خلفية شاشة داكنة مع إضاءة بنفسجية/زرقاء خفيفة أعلى الشاشة.
- `SVG/status_bar.svg` و`SVG/bottom_navigation_bar.svg`: عناصر توضيحية لشريط الحالة والتنقل السفلي.
- `SVG/credits_pill.svg`: كبسولة رصيد/نقاط.
- `SVG/top_bar_controls.svg`: عناصر التحكم العلوية.
- `SVG/video_mode_tabs.svg`: تبويبات أوضاع إنشاء الفيديو.
- `SVG/pro_banner_panel.svg`: سطح بانر Pro.
- `SVG/model_selector_panel.svg` و`SVG/model_selector_card.svg`: أسطح وبطاقة اختيار النموذج؛ الرسم المتجهي توضيحي وليس صورة فوتوغرافية أصلية.
- `SVG/reference_slot_required.svg` و`SVG/reference_slot_optional.svg`: إطارات مرجعية أساسية.
- `SVG/reference_card_standard.svg`: بطاقة مرجعية مع صور مصغرة توضيحية.
- `SVG/required_badge.svg` و`SVG/optional_badge.svg`: شارات الحالة.
- `SVG/image_reference_heading.svg`: عنوان قسم الصور/الفيديو المرجعي.
- `SVG/info_strip.svg`: شريط معلومات/تنبيه.
- `SVG/prompt_panel.svg` و`SVG/prompt_panel_header.svg` و`SVG/prompt_input_inner.svg`: لوحة المطالبة وعناصرها.
- `SVG/auto_generate_pill.svg`: زر التوليد التلقائي.
- `SVG/setting_chip.svg` و`SVG/settings_option.svg` و`SVG/aspect_ratio_option.svg` و`SVG/style_option.svg` و`SVG/advanced_settings_option.svg`: خيارات الإعدادات.
- `SVG/gradient_cta_button.svg` و`SVG/create_button.svg`: أزرار التدرج.
- `SVG/sparkle_icon.svg` و`SVG/image_add_icon.svg` و`SVG/plus_icon.svg`: رموز متجهية.

## حدود المطابقة
الملف المركب هو إعادة بناء بصرية تقريبية قابلة للتعديل، وليس نسخة مطابقة بكسلًا ببكسل. صورة المرأة والصور المصغرة الأصلية غير متوفرة كملفات منفصلة، لذا استُخدمت رسوم متجهية مبسطة. كذلك قد تختلف بعض الأبعاد والتفاصيل عن لقطة الهاتف الأصلية. للحصول على مطابقة أعلى، يلزم توفير الصور الأصلية المنفصلة ثم مراجعة النسخة المركبة مقابل المرجع.

## الاستخدام
- افتح ملفات SVG في محرر متوافق مثل Inkscape أو Figma لاستعراضها وتعديلها.
- هذه الحزمة أصول بصرية ومرجع مركّب فقط، وليست مكونات Jetpack Compose جاهزة ولا ملف PSD متعدد الطبقات.
- تمت إضافة الملفات إلى مجلد الأصول دون تعديل ملفات التطبيق الحالية.
