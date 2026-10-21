# Cheat Menu (Fabric, Minecraft 1.21.x)

A client-side mod with a click GUI and HUD.

## Modules
- **Movement:** Fly, Speed, Sprint, Step, NoFall
- **Visuals:** Fullbright, EntityGlow
- **Utility:** AutoRespawn, AutoTool

## Controls
- Right Shift opens the click GUI (rebind under Controls > Misc).
- Left-click a module to toggle it. Active modules show on the HUD.

## Build
1. Install JDK 21.
2. Check https://fabricmc.net/develop and set `minecraft_version`, `yarn_mappings`,
   `loader_version` and `fabric_version` in `gradle.properties` to match your game version.
3. Add the Gradle wrapper (`gradle wrapper`) or open the folder in IntelliJ IDEA.
4. Run `./gradlew build`. The jar is in `build/libs/`.
5. Drop the jar (not the `-sources` one) plus Fabric API into your `mods` folder.

## Notes
- Written against 1.21.4 Yarn mappings. If you use another 1.21.x version, a few
  names (e.g. `selectedSlot`, `OnGroundOnly`) may need small adjustments.
- Use it in singleplayer, on your own server, or where the server rules allow it.
  Most public servers ban these features.
