# Islands-Enet

Mod para Minecraft **1.16.5** (Fabric) que transforma el servidor en un mundo de islas flotantes, con estructuras especiales, bloques y entidades propias del universo de Islands-Enet.

> 🚧 Proyecto en desarrollo activo — avances diarios documentados en [Issues](../../issues) y [Projects](../../projects).

## Estado del proyecto

En construcción. Roadmap de 5 meses, actualmente en fase de **cimientos técnicos**.

## Requisitos

- Minecraft 1.16.5
- [Fabric Loader](https://fabricmc.net/)
- [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api)

## Instalación (jugador)

> ⚠️ Todavía no hay releases disponibles.

## Desarrollo

Requisitos:
- JDK 8
- Git

```bash
git clone https://github.com/tu-usuario/islands-enet.git
cd islands-enet
./gradlew genSources
./gradlew vscode   # si usás VS Code
```

Correr el cliente de desarrollo: `./gradlew runClient`.

## Estructura del proyecto

- `src/main/java/` — código del mod (bloques, entidades, worldgen)
- `src/main/resources/data/` — datapack (funciones, loot tables, estructuras)
- `src/main/resources/assets/` — texturas, modelos, sonidos
- `docs/` — documentación de diseño (lore, roadmap, registro de contenido)

## Licencia

MIT — ver [LICENSE](LICENSE) para más detalles.