# Font inventory and status

No original font files were supplied with the reference screenshot or found as verifiable source assets for this screen. This reconstruction therefore does not claim to restore an original font.

The CSS requests these fonts in order when they are already installed on the device:
1. Noto Sans Arabic
2. Noto Kufi Arabic
3. Segoe UI
4. Tahoma
5. Arial
6. Generic sans-serif

The interface remains usable with system fallbacks and does not download any font at runtime. If an exact font is later identified from the original app, place its licensed webfont in a dedicated assets/fonts folder and update css/design-tokens.css. No font binaries are bundled in this package.
