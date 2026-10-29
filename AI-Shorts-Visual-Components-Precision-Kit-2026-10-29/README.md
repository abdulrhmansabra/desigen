# AI Shorts — Precision Visual Component Kit

This folder is a **newly reconstructed component reference** based on the user-provided cropped screenshot showing the Pro banner, generation tabs, featured model card, and reference-image count cards.

## Provenance

- **Recovered originals:** None of the original design source files for this exact screenshot were available to verify.
- **Recreated:** Compose component patterns, design tokens, measurements/specification, and SVG icon references in this folder.
- **Not included as originals:** The model portrait, miniature reference thumbnails, original font files, and any proprietary app assets. Supply the real assets from the Android project when available.
- **Precision status:** Measurements are visual estimates from the supplied screenshot crop, not recovered source values. Compare on the target device and refine.

## Contents

- `docs/REFERENCE-COMPONENT-SPEC.md` — element-by-element visual analysis and approximate geometry.
- `docs/ASSET-PROVENANCE.md` — explicit distinction between recreated and unavailable assets.
- `android/AiShortsVisualTokens.kt` — central Compose colors, gradients, shapes, and sizing guidance.
- `android/AiShortsVisualComponents.kt` — reusable Compose components for the visible elements.
- `assets/visual-icons.svg` — editable vector reference sheet for the small line icons.
- `preview/component-reference.html` — browser preview/reference for the visual system.

## Integration

Copy/adapt the Kotlin files into the package structure of the existing AI Shorts app. Replace the package declaration with the app's existing package. The components intentionally accept content slots or text parameters where app-specific assets and labels are needed; they do not invent the unavailable original photos.

The Kotlin files use Jetpack Compose Foundation and UI APIs. Add them to the existing app's source set; this kit does not replace the application, navigation, or screen logic.

## Visual rules captured

- Near-black navy base with a restrained violet/pink ambient wash.
- Dark matte surfaces with controlled gradient borders.
- Soft rose/violet/blue edge accents, not thick neon outlines.
- A brighter cyan-blue selected reference card.
- Primary upgrade action gradient from blue through violet to pink.
- No added drop shadows; no glass blur.
- Arabic-first RTL layout.
