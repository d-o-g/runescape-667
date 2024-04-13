# runescape-667

[![CI](https://github.com/StrongHold/runescape-667/actions/workflows/ci.yaml/badge.svg)](https://github.com/StrongHold/runescape-667/actions/workflows/ci.yaml)

Build [667](https://runescape.wiki/w/Build_number) of [RuneScape 2](https://www.runescape.com/),
originally released on [2011-10-04](https://runescape.wiki/w/Update:Chat_Changes_%26_Camera_Controls).

## Running via Gradle

Single public key for both JS5 and Login protocols.

```bash
./gradlew client:run --args="/path/to/public.key"
```

Separate public keys for JS5 and Login protocols.

```bash
./gradlew client:run --args="/path/to/js5.public.key /path/to/login.public.key"
```
