sbt-about-plugins
=================

SBT plugin to show some details about plugins loaded

Requirements
------------

* sbt 0.12.x

Installation
------------

Only a SNAPSHOT version available at this time

To use the **latest snapshot** version, add Sonatype snapshots repository resolver into **plugins.sbt** file:

    resolvers += "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

    addSbtPlugin("com.github.jozic" % "sbt-about-plugins" % "0.1.0-SNAPSHOT")

Usage
-----

```
> about
[info] This is sbt 0.12.3
[info] The current project is {file:/home/jozic/projects/sbt-idea/}sbt-idea
[info] The current project is built against Scala 2.9.2
[info] Available Plugins: com.typesafe.sbt.SbtPgp, org.sbtidea.SbtIdeaPlugin, com.github.sbt.aboutplugins.AboutPluginsPlugin, com.timushev.sbt.updates.UpdatesPlugin, sbt.ScriptedPlugin
[info] sbt, sbt plugins, and build definitions are using Scala 2.9.2
> 
> about-plugins
[info] The following plugins are loaded with this build:
[info]   com.typesafe.sbt.SbtPgp in module 
[info] 		com.typesafe.sbt:sbt-pgp:0.8 (sbtVersion=0.12, scalaVersion=2.9.2)
[info] 	org.sbtidea.SbtIdeaPlugin in module 
[info] 		com.github.mpeltonen:sbt-idea:1.6.0-SNAPSHOT (sbtVersion=0.12, scalaVersion=2.9.2)
[info] 	com.github.sbt.aboutplugins.AboutPluginsPlugin in module 
[info] 		com.github.jozic:sbt-about-plugins:0.1.0-SNAPSHOT (sbtVersion=0.12, scalaVersion=2.9.2)
[info] 	com.timushev.sbt.updates.UpdatesPlugin in module 
[info] 		com.timushev.sbt:sbt-updates:0.1.2 (sbtVersion=0.12, scalaVersion=2.9.2)
[info] 	sbt.ScriptedPlugin in module 
[info] 		org.scala-sbt:scripted-plugin:0.12.3
> 
```
