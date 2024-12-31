<p align="center">
    <a href="https://github.com/StrongHold/runescape-667?tab=readme-ov-file#readme" rel="noopener noreferrer">
        <img src="https://github.com/StrongHold/runescape-667/raw/master/logo.png" alt="RuneScape Logo" />
    </a>
    <br />
    <a href="https://github.com/StrongHold/runescape-667?tab=readme-ov-file#readme" rel="noopener noreferrer">
        <img src="https://github.com/StrongHold/runescape-667/raw/master/preview.png" alt="Preview" />
    </a>
</p>

# runescape-667

Client build [667][build] of [RuneScape 2][rs2], originally released on [2011-10-04][update].

## Getting Started

Run the client either directly via Gradle:

```bash
./gradlew client:run --args="--js5 '/path/to/js5.public.key' --login '/path/to/login.public.key'"
```

Or via the built distributable:

```bash
./gradlew installDist
./client/build/install/client/bin/client --js5 "/path/to/js5.public.key" --login "/path/to/login.public.key"
```

## Naming

Where possible, Jagex's canonical naming scheme is used for naming and packaging. These are sourced from various leaks
such as the partially-obfuscated Transformers Universe client and the NXT Beta client that contained debug symbols.

Original exception messages from these leaks have been restored, often shedding light on original naming schemes.

Native libraries are stored in the cache, which prevents various classes from being repackaged from the root or renamed.
These are classes that typically have `native` methods and one or two letter classnames.

## Noteworthy

Below is a list of noteworthy parts of the client that have been refactored.

### CS2

The CS2 [`ScriptRunner`](runescape/src/main/java/ScriptRunner.java) is almost fully refactored, with most
[`ClientScriptOpcodes`](runescape/src/main/java/com/jagex/core/constants/ClientScriptOpCode.java) identified.

### JS5

The JS5 [networking layer](runescape/src/main/java/com/jagex/js5) is fully refactored, alongside all
major [JS5 config groups](runescape/src/main/java/com/jagex/game/runetek6/config).

### Audio

Both the [MIDI](runescape/src/main/java/com/jagex/sound/midi) & [Vorbis](runescape/src/main/java/com/jagex/sound/vorbis)
audio layers are fully refactored.

### Protocol

The [`ClientProt`](runescape/src/main/java/com/jagex/ClientProt.java),
[`ServerProt`](runescape/src/main/java/com/jagex/ServerProt.java), and
[`ZoneProt`](runescape/src/main/java/com/jagex/ZoneProt.java) are all refactored, identifying all packets sent across
the networking protocol.

### Path-finding and Collision

The [`PathFinder`](runescape/src/main/java/com/jagex/game/PathFinder.java) is fully refactored, with all
[`CollisionFlags`](runescape/src/main/java/com/jagex/game/collision/CollisionFlag.java) that affect path-finding
identified and utilised in the [`CollisionMap`](runescape/src/main/java/com/jagex/game/collision/CollisionMap.java).

### Updating Procedures

The player & npc updating procedures are refactored in [`PlayerList`](runescape/src/main/java/PlayerList.java) &
[`NpcList`](runescape/src/main/java/NPCList.java) respectively.

### UI

The [`Component`](runescape/src/main/java/Component.java) &
[`InterfaceManager`](runescape/src/main/java/InterfaceManager.java) are almost fully refactored.

Standalone components of the UI are also refactored:

- [`ClientInventory`](runescape/src/main/java/ClientInventory.java)
- [`debugconsole`](runescape/src/main/java/debugconsole.java)
- [`MiniMenu`](runescape/src/main/java/MiniMenu.java)
- [`Minimap`](runescape/src/main/java/Minimap.java)
- [`WorldMap`](runescape/src/main/java/WorldMap.java)

## Docs

1. [Command-line Interface](docs/cli.md)
2. [Applet](docs/applet.md)
3. [Parameters](docs/parameters.md)

## Credits

- The [Openrs2 Team](https://github.com/openrs2).
- Pazaz for fixing Openrs2's deobfuscator for 667, providing the basis of the deobfuscated client, and helping to fix
  various issues.
- Method for a refactored 666 client.
- Kris for various canonical Jagex terminology.
- Polar for various canonical Jagex terminology.

[rs2]: https://www.runescape.com/

[build]: https://runescape.wiki/w/Build_number

[update]: https://runescape.wiki/w/Update:Chat_Changes_%26_Camera_Controls
