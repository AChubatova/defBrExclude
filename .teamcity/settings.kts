import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.commitStatusPublisher
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.schedule
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2020.2"

project {

    vcsRoot(HttpsGithubComAChubatovaComposite)

    buildType(Vctrig)
    buildType(FilterDefBranch)
    buildType(Trig2)
    buildType(Build3)
}

object Build3 : BuildType({
    name = "build3"

    vcs {
        root(HttpsGithubComAChubatovaComposite)
    }

    steps {
        script {
            scriptContent = "ls"
        }
    }
})

object FilterDefBranch : BuildType({
    name = "filterDefBranch"
})

object Trig2 : BuildType({
    name = "trig2"

    vcs {
        root(HttpsGithubComAChubatovaComposite, "+:100files => 100files")
    }

    steps {
        script {
            scriptContent = "ls"
        }
    }

    triggers {
        schedule {
            triggerBuild = onWatchedBuildChange {
                buildType = "${Trig2.id}"
            }
        }
    }
})

object Vctrig : BuildType({
    name = "vctrig"

    params {
        param("teamcity.vcsTrigger.analyzeFullHistoryForMergeCommits", "false")
    }

    vcs {
        root(HttpsGithubComAChubatovaComposite, "+:fold => fold")
    }

    steps {
        script {
            scriptContent = "ls"
        }
    }

    triggers {
        vcs {
            triggerRules = "+:/fold/**"
            branchFilter = """
                +:changes/*
                +:*
            """.trimIndent()
        }
    }

    features {
        commitStatusPublisher {
            vcsRootExtId = "${HttpsGithubComAChubatovaComposite.id}"
            publisher = github {
                githubUrl = "https://api.github.com"
                authType = personalToken {
                    token = "credentialsJSON:0a7113b2-814d-4293-90a9-ee62744d71bd"
                }
            }
        }
    }
})

object HttpsGithubComAChubatovaComposite : GitVcsRoot({
    name = "https://github.com/AChubatova/composite"
    url = "https://github.com/AChubatova/composite"
    branch = "refs/heads/master"
    branchSpec = "+:refs/heads/*"
})
