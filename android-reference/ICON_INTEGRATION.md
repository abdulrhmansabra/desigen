# Android resource handoff for ICON/

The `ICON/` directory in this repository is the canonical source of truth. This folder contains reusable Android integration guidance, not a second source of artwork.

- `VidoraIcon.kt.txt`: reusable Jetpack Compose wrapper accepting a real Android drawable resource ID.
- `icon-registry.json` (repository root): inventory of every supported image asset, its original path, format, and a suggested Android resource name.

## Important
Android cannot load a repository URL or a web path using `painterResource`. Copy the desired assets into the Android app's `res/drawable-nodpi` directory, normalize filenames to Android resource rules, and convert SVG files to Android VectorDrawable XML where appropriate. Keep originals in `ICON/` unchanged. This repository is a design-system source/reference; it does not claim the assets have been installed into a separate Android application.
