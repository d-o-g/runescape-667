<p align="center">
    <a href="https://github.com/StrongHold/runescape-667" rel="noopener noreferrer">
        <img src="https://github.com/StrongHold/runescape-667/raw/master/logo.png" alt="RuneScape Logo" />
    </a>
    <br />
    <a href="https://github.com/StrongHold/runescape-667" rel="noopener noreferrer">
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

## Docs

1. [Command-line Interface](docs/cli.md)
2. [Applet](docs/applet.md)
3. [Parameters](docs/parameters.md)

[rs2]: https://www.runescape.com/
[build]: https://runescape.wiki/w/Build_number
[update]: https://runescape.wiki/w/Update:Chat_Changes_%26_Camera_Controls
