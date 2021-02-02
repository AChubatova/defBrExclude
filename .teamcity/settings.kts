import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.powerShell
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

    vcsRoot(Comp)

    buildType(FilterOutDefaultBranch)
}

object FilterOutDefaultBranch : BuildType({
    name = "FilterOutDefaultBranch2"

    vcs {
        root(Comp)
    }

    steps {
        powerShell {
            scriptMode = file {
                path = "part4.ps1"
            }
            param("jetbrains_powershell_script_code", """
                Write-output "HI"
                Start-Sleep seconds 1
            """.trimIndent())
        }
    }
})

object Comp : GitVcsRoot({
    name = "comp"
    url = "https://github.com/AChubatova/composite"
    branch = "refs/heads/master"
    branchSpec = """
        +:refs/heads/(*)
        +:mm
    """.trimIndent()
    authMethod = password {
        userName = "AChubatova"
        password = "credentialsJSON:828deb71-9d3e-47a1-a88c-d45d94705a55"
    }
})
