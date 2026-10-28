# AI Shorts — Screen Recreation Source

A new, self-contained workspace recreating the AI Shorts screen from the screenshot supplied on 2026-10-28.

## Files
- `REFERENCE_SOURCE/ORIGINAL_IMAGE_NOTE.md` — explains the role and handling of the original reference image.
- `SOURCE/screen_recreation.svg` — hand-authored editable vector recreation of the layout, controls, Arabic labels, gradients, borders and icons.
- `SOURCE/index.html` and `SOURCE/styles.css` — browser preview.
- `SOURCE/design-tokens.txt` — palette and design constraints.
- `DOCS/RECONSTRUCTION_NOTES_AR.md` — Arabic layer order and fidelity checklist.
- `MANIFEST.md` — file inventory.

## Preview
Open `SOURCE/index.html` or `SOURCE/screen_recreation.svg`.

## Fidelity
The vector recreation is an independent drawing and does not use the screenshot as its background. It is not claimed to be pixel-perfect: the portrait and thumbnails are stylized vector illustrations, and Arabic font rendering can differ by platform. The original reference image is retained in the downloadable project ZIP for side-by-side comparison.

## Style constraints
Dark matte surfaces; no glassmorphism; no drop shadows; restrained pink/violet/blue gradients; RTL Arabic layout.