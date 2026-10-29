# Prompt panel and generation controls — visual specification

## Reference

Based on the user-supplied close crop showing the prompt header, large text-entry surface, auto-generate action, character counter, three settings controls, and primary Create button.

## Provenance and accuracy

This is a new reconstruction based on a rendered screenshot. No original Kotlin/XML/CSS source, font files, exact color values, original icons, or original dp dimensions were recovered. The values are estimates and should be tuned against screenshots from the actual target device.

## Prompt section heading

- Right aligned Arabic title "المطالبة".
- Small sparkle icon to the right, with a violet-to-blue fill.
- No separate container behind the heading.
- Clear vertical gap between the header and input area.

## Prompt editor

- Large rounded rectangular dark navy surface.
- Thin cool blue-violet border, approximately 1 dp.
- Rounded corners approximately 23–25 dp.
- Interior is matte dark navy, with subtle top-to-bottom tonal variation.
- Placeholder is muted lavender-grey, aligned to the right and allowed to wrap into two lines.
- Text editor must remain editable, not a static mock.
- Bottom-left action is a dark plum/blue pill with a small icon and the label "توليد تلقائي".
- Bottom-right area contains the character count and edit/pencil icon.
- The count format is current character count / maximum (example 0/5000).
- Keep a generous blank writing area between placeholder and bottom controls.

## Three setting controls

- Single horizontal row of three rounded dark matte chips.
- Each chip uses a subtle navy/violet gradient and a thin blue-grey border.
- Left chip: device/aspect icon, label "نسبة العرض", value "9:16", chevron.
- Middle chip: magic wand icon, label "الأسلوب", value "واقعي", chevron.
- Right chip: settings/gear icon, label "الإعدادات المتقدمة", chevron.
- Maintain equal visual heights and balanced widths.
- Allow labels to scale or ellipsize on narrow screens; do not let icons overlap text.
- No drop shadows, no glass blur, no thick neon outlines.

## Primary Create button

- Wide pill button with generous radius.
- Horizontal gradient moves from rose pink at the left through violet to vivid blue at the right.
- White sparkle icon, bold Arabic label "إنشاء", and right-facing chevron centered as a group.
- Thin subtle edge only; no external glow or drop shadow.
- Disabled state, if needed, should reduce saturation rather than changing the layout.

## Integration notes

- Reuse the shared `AiShortsVisualTokens` from the same folder.
- Supply icon composables from the existing app icon family; do not replace original icons with emoji.
- Keep app behavior outside this component library. Wire `onClick` callbacks to existing actions.
- Confirm text alignment and RTL ordering using actual device screenshots.
- This file documents a reconstructed reference, not recovered source values.
