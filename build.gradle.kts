import xyz.jpenilla.resourcefactory.bukkit.BukkitPluginYaml

plugins {
  java
  `java-library`

  id("io.papermc.paperweight.userdev") version "1.7.1"
  id("xyz.jpenilla.resource-factory-bukkit-convention") version "1.1.1"
  id("xyz.jpenilla.run-paper") version "2.3.0"

  id("io.github.goooler.shadow") version "8.1.7"
}

val groupStringSeparator = "."
val kebabcaseStringSeparator = "-"
val snakecaseStringSeparator = "_"

fun capitalizeFirstLetter(string: String): String {
  return string.first().uppercase() + string.slice(IntRange(1, string.length - 1))
}

fun snakecase(string: String): String {
  return string.lowercase().replace(kebabcaseStringSeparator, snakecaseStringSeparator).replace(" ", snakecaseStringSeparator)
}

fun pascalcase(kebabcaseString: String): String {
  var pascalCaseString = ""

  val splitString = kebabcaseString.split(kebabcaseStringSeparator)

  for (part in splitString) {
    pascalCaseString += capitalizeFirstLetter(part)
  }

  return pascalCaseString
}

description = "The Minecraft plugin to run Slime Bot and synchronise The Slimy Swamp Minecraft server data to the Discord server."

val mainProjectAuthor = "Esoteric Organisation"
val projectAuthors = listOfNotNull(mainProjectAuthor, "Esoteric Enderman")

val topLevelDomain = "org"

group = topLevelDomain + groupStringSeparator + "esoteric"
version = "1.0.0-SNAPSHOT"

val javaVersion = 21
val paperApiVersion = "1.21"

java {
  toolchain.languageVersion = JavaLanguageVersion.of(javaVersion)
}

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
  compileOnly("com.github.EsotericOrganisation:tss-core-plugin:0.2.1:dev-all")
  paperweight.paperDevBundle("$paperApiVersion-R0.1-SNAPSHOT")

  implementation("dev.jorel" , "commandapi-bukkit-shade-mojang-mapped" , "9.5.1")
}

tasks {
  compileJava {
    options.release = javaVersion
  }

  javadoc {
    options.encoding = Charsets.UTF_8.name()
  }
}

bukkitPluginYaml {
  name = "TSSSlimeBot"
  description = project.description
  authors = projectAuthors

  version = project.version.toString()
  apiVersion = paperApiVersion
  depend.add("TSSCore")
  main = project.group.toString() + groupStringSeparator + "tss.minecraft.plugins.discord.bot" + groupStringSeparator + "TSSSlimeBotPlugin"
  load = BukkitPluginYaml.PluginLoadOrder.STARTUP
}
