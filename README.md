# [![RuneScape 667](logo.png)](#)

[![CI](https://github.com/StrongHold/runescape-667/actions/workflows/ci.yaml/badge.svg)](https://github.com/StrongHold/runescape-667/actions/workflows/ci.yaml)

Build [667][build] of [RuneScape 2][rs], originally released on [2011-10-04][update].

## Running via Gradle

Single public key for both JS5 and Login protocols.

```bash
./gradlew client:run --args="/path/to/public.key"
```

Separate public keys for JS5 and Login protocols.

```bash
./gradlew client:run --args="/path/to/js5.public.key /path/to/login.public.key"
```

[rs]: https://www.runescape.com/
[build]: https://runescape.wiki/w/Build_number
[update]: https://runescape.wiki/w/Update:Chat_Changes_%26_Camera_Controls
