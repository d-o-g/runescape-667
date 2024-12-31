<p align="center">
    <a href="https://github.com/StrongHold/runescape-667" rel="noopener noreferrer">
        <img src="https://github.com/StrongHold/runescape-667/raw/master/logo.png" alt="RuneScape Logo" width="278" height="90" />
    </a>
    <br />
    <a href="https://github.com/StrongHold/runescape-667/actions/workflows/ci.yaml">
        <img src="https://github.com/StrongHold/runescape-667/actions/workflows/ci.yaml/badge.svg" alt="CI Status" />
    </a>
</p>
<br />

# runescape-667

Client build [667][build] of [RuneScape 2][rs2], originally released on [2011-10-04][update].

## Running via Gradle

Single public key for both JS5 and Login protocols.

```bash
./gradlew client:run --args="/path/to/public.key"
```

Separate public keys for JS5 and Login protocols.

```bash
./gradlew client:run --args="/path/to/js5.public.key /path/to/login.public.key"
```

[rs2]: https://www.runescape.com/
[build]: https://runescape.wiki/w/Build_number
[update]: https://runescape.wiki/w/Update:Chat_Changes_%26_Camera_Controls
