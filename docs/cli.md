# CLI

The `runescape.jar` can be ran via the command line, with
[parameters](./parameters.md) passed as positional arguments:

|   | Argument                                 | Accepted&nbsp;values                                       |
|--:|:-----------------------------------------|:-----------------------------------------------------------|
| 0 | worldid                                  | The numerical id of the game world to connect to           |
| 1 | lobbyid                                  | The numerical id of the game lobby to connect to           |
| 2 | [`modewhere`](./parameters.md#modewhere) | `live`, `wtrc`, `wtqa`, `wtwip`, `local`, `wti`, `intbeta` |
| 3 | [`modewhat`](./parameters.md#modewhat)   | `live`, `rc`, `wip`                                        |
| 4 | [`language`](./parameters.md#language)   | `english`, `german`                                        |
| 5 | [`game`](./parameters.md#modegame)       | `game0`, `game1`, `game2`, `game3`                         |

For example:

```bash
java --class-path runescape.jar client 1 1000 local live english game0
```
