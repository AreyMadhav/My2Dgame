# My2DGame — Quick Update Notes

## **Overview**
- **Summary:** Small runtime and input fixes were applied so the game window runs and the player can move. This is a minimal update to get the game loop, input, and rendering working; assets (sprites/sounds) will be added later.

## **Changes**
- **pom.xml:** Set Java compatibility to 17 and corrected the main class property so packaged classes match typical runtimes.
- **src/main/java/com/rpg/my2dgame/main/GamePanel.java:** Added a simple game loop (`Runnable`), input handling (`KeyListener`), `tick()` method, and repaint logic. Starts a `Thread` that ticks and repaints at ~60 FPS.
- **src/main/java/com/rpg/my2dgame/entities/Player.java:** Added movement API (`move(...)`), sprite resource loading with a fallback to a white rectangle when no sprite is present, and a basic `tick()`/`render()` implementation.

## **How to build & run**
1. Build (from project root):

```powershell
mvn -DskipTests clean package
```

2. Run the app (after successful build):

```powershell
java -cp target/classes com.rpg.my2dgame.main.Main
```

3. If you see a Java version mismatch error, check your runtime:

```powershell
java -version
```

If your `java` runtime is older than 17, either install JDK 17 or change `pom.xml` back to your runtime version and rebuild.

## **Notes & Next Steps**
- **Sprites:** To use an image for the player place `player.png` at `src/main/resources/com/rpg/my2dgame/resources/player.png`. If missing the player renders as a white rectangle.
- **Focus for input:** Click the game window once after it opens to ensure `GamePanel` has keyboard focus.
- **Planned:** Add sprites, animations, collision detection, tilemap support, and sound. I can add a sample sprite and wire it into the resources if you want.

## **If something breaks**
- then idk if i will fix it or not lmfao

---
Updated: January 16, 2026 — applied game loop and input fixes; next: assets.

