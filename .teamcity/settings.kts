import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.matrix
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

version = "2023.05"

project {
vcsRoot(customRepo)
    buildType(Build1)
}

object Build1 : BuildType({
    name = "build1"

    vcs {
        root(DslContext.settingsRoot)
  root(customRepo)
    }

    steps {
        script {
            id = "simpleRunner"
            scriptContent = "ls"
        }
    }
})


object customRepo : GitVcsRoot({
    name = "customRepo"
    url = "https://github.com/ChubatovaTiger/mavenJunit"
    branch = "refs/heads/main"
})
