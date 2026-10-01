# anubis addon template

empty addon for [Anubis](https://github.com/horuscommand/Anubis-Client). theres one category and one module in it, the module doesnt do anything it just turns on and off lol. clone it and build your stuff on top

## setup

anubis isnt on any public maven so you have to build it yourself first:

```
git clone https://github.com/horuscommand/Anubis-Client
cd Anubis-Client
gradlew publishToMavenLocal
```

that puts `net.anubis:anubis-client:<mod_version>` in your local maven. then set `anubis_version` in this repos `gradle.properties` to that version, and keep the minecraft / fabric versions the same as the ones in anubis's `gradle.properties`

## making it yours

- rename the `com.example.addon` package and change it in `getPackage()`, the `anubis` entrypoint in `fabric.mod.json` and the `package` in the mixins json too. every addon needs its own package, if two addons share one anubis skips the second one
- change `id`, `name` and `authors` in `fabric.mod.json` and rename the mixins json
- set `maven_group` and `archives_base_name` in `gradle.properties`

**categories:** `ModuleCategory.register("MY_ID", "Title")` in `onRegisterCategories()`. ids are uppercase and have to be unique

**modules:** `ModuleRegistry.add(new MyModule())` in `onInitialize()`, MyModule just extends `ClientModule`

if you need the modules saved settings or want to add modules later on use `onConfigLoaded()`, it runs after anubis has loaded the module config

## building

- `gradlew runClient` opens the game with anubis + your addon
- `gradlew build` gives you `build/libs/<archives_base_name>-<version>.jar`, put it in your `mods` folder next to anubis

thats it, have fun
