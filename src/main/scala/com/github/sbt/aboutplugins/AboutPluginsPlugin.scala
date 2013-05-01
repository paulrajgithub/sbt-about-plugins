package com.github.sbt.aboutplugins

import sbt._
import collection.Seq

object AboutPluginsPlugin extends Plugin {
  override lazy val settings = Seq(
    Keys.commands += aboutPluginsCommand
  )

  private lazy val aboutPluginsCommand = Command.command("about-plugins")(doCommand)

  def doCommand(state: State): State = {
    val structure = Project.extract(state).structure

    state.log.info("The following plugins are loaded with this build:")

    val pluginNamesAndLoaders = structure.units.values.map(un => (un.unit.plugins.pluginNames, un.unit.plugins.loader)).toSeq
    val pluginArtifactPaths: Seq[(String, String)] = for {
      (names, loader) <- pluginNamesAndLoaders
      name <- names
      source <- Option(Class.forName(name, true, loader).getProtectionDomain.getCodeSource)
      location <- Option(source.getLocation)
    } yield (name, location.getPath)

    val reports: Seq[UpdateReport] = structure.units.values.flatMap(un => un.unit.plugins.pluginData.report).toSeq
    reports.foreach {
      report =>
        val moduleReports: Map[ModuleID, Seq[(Artifact, File)]] = (for {
          configReport <- report.configurations
          moduleReport <- configReport.modules
        } yield moduleReport.module -> moduleReport.artifacts).toMap

        val plugins: Seq[(String, ModuleID)] = for {
          (name, artifactPath) <- pluginArtifactPaths
          (module, artifacts) <- moduleReports if artifacts.exists {
            case (_, file) => artifactPath == file.getPath
          }
        } yield (name, module)

        plugins foreach {
          case (name, module) =>
            state.log.info("\t" + name + " in module ")
            state.log.info("\t\t" + module)
        }
    }
    state
  }
}