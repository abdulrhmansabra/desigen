# Reference component specification

## Source and confidence

Reference: user-provided cropped screenshot (the visible crop contains the Pro banner, generation-type tabs, featured model card, section heading, and three reference-image cards).

This document is a visual reconstruction brief. The screenshot does not expose original dp values, density, source vectors, font files, or image assets. All numeric values below are estimates normalized to a 390 dp-wide conceptual content area. Recalibrate after taking a screenshot from the target device.

## Shared visual language

- **Canvas:** near-black navy, approximately `#050711` to `#090D1C`.
- **Surface:** dark blue-black, approximately `#0D1225` / `#10162B`; slight tonal variation rather than a flat grey fill.
- **Text primary:** cool near-white, approximately `#F2F1FF`.
- **Text secondary:** muted lavender-grey, approximately `#A9AAC8`.
- **Pink accent:** approximately `#F06CCB`.
- **Violet accent:** approximately `#A65BFA`.
- **Blue accent:** approximately `#4D78FF`.
- **Cyan selected accent:** approximately `#39C8FF`.
- **Stroke:** thin, low-alpha cool blue or violet; selected surfaces may have a stronger blue-to-violet edge.
- **Lighting:** local radial/linear washes with low alpha. Do not apply one global neon halo to every component.
- **Shadows:** no generic drop shadows. The visible edge light is a gradient stroke/inner tint, not a black elevation shadow.
- **Corners:** generous rounded corners; use 20–26 dp for the banner and model card, 18–22 dp for reference cards, and pill shapes for tabs/actions.
- **Typography:** bold compact title, medium supporting text, muted small captions. Original font is unknown; use the app's existing Arabic-capable font if available.
- **Direction:** RTL for Arabic labels. Keep icon/text order faithful to the screenshot; do not rely blindly on RTL mirroring for every decorative element.

## 1. Pro upgrade banner

Approximate layout:
- Wide horizontal banner, near full content width.
- Estimated height: 82–94 dp.
- Corner radius: 22–25 dp.
- Background: deep navy gradient with subtle blue centre and plum/rose at both ends.
- Border: thin gradient rose/violet at the left and upper edge, fading into blue and pink.
- Left decorative art: abstract folded/ribbon-like violet shape; original asset unavailable.
- Main content: bold title on first line, muted subtitle below.
- Action: rounded pill, blue → violet → pink gradient; white label and chevron.
- Crown icon near the top-right.
- Keep generous inner padding; avoid compressing title into the action button.

## 2. Generation-type tabs

Three horizontal choices:
- The selected first tab is a pill with a more visible pink-to-blue outline and blue-violet inner tint.
- Selected tab has a short luminous underline at the bottom, transitioning pink → violet → cyan.
- Unselected tabs use dark matte navy fills with subtle blue-grey strokes.
- Each tab combines a simple line icon and Arabic label.
- Use equal visual height and stable baselines; allow text to remain readable.
- Avoid thick outlines, outer glow, glass blur, and heavy shadows.

## 3. Featured model card

- Wide landscape card, estimated height 80–94 dp.
- Radius around 22–24 dp; dark navy content region.
- Portrait/landscape artwork occupies roughly the left 38–43% of the card, clipped to the card shape.
- Artwork transitions into the content region with a dark overlay/fade, preserving text contrast.
- Text content is right-aligned: model name, compact “latest” badge, description line, and a right-facing chevron.
- Border is subtle, with rose light near the left/top and cool blue toward the right.
- The screenshot's portrait is a reference asset, not recreated in this kit. Pass the actual app asset through the content slot.

## 4. Reference section heading

- Heading sits on the right and uses primary text, medium-to-bold weight.
- Small information icon sits toward the opposite side.
- Maintain separation from the model card above and image cards below.
- Do not add a container card around the heading.

## 5. Reference image count cards

Three cards displayed side by side in the screenshot:
- Cards share the same basic structure, but selected/required card is visually emphasized.
- Estimated card radius: 19–22 dp.
- Dark navy surface with subtle internal tonal gradient.
- Each card has a top badge (advanced / premium / required), a circular icon well, a bold count label, thumbnail strip, circular plus affordance, and a small muted helper caption.
- The rightmost required card has the strongest edge treatment: cyan/blue on the left/top and violet/blue on the right/bottom.
- Non-selected cards use quieter plum/blue strokes.
- Thumbnail strip should use real supplied thumbnails, clipped with small corner radii; don't use repeated placeholder art in a production integration.
- Keep labels and thumbnail strip from colliding at narrow widths. If the actual device width differs, test the three-column row against the original target screenshot before deciding whether to scale or scroll.

## 6. Reusable lighting recipe

Use separate layers for:
1. matte surface fill,
2. low-opacity local radial tint where visible,
3. thin gradient stroke,
4. selected-state edge accent only where required.

Do not add a large blur halo around every card. Keep the light close to the edge, soft, and asymmetrical. Avoid broad white highlights, excessive bloom, and glass-like translucent surfaces.

## Pixel-comparison checklist

- Match screenshot crop and device width before judging.
- Compare card x/y positions and widths.
- Compare radii and border thickness.
- Compare edge hue placement (rose left/top, blue right, selected cyan).
- Compare portrait crop and fade.
- Compare Arabic baseline and line spacing.
- Compare thumbnail count, crop, and spacing.
- Compare pill/button gradient direction.
- Keep original source art separate from recreated vectors.
