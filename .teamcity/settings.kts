import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.powerShell
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.SvnVcsRoot

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

    vcsRoot(Dfdf)
    vcsRoot(Ddfdf)
    vcsRoot(Comp)
    vcsRoot(Tiger)
    vcsRoot(Sdkj)
    vcsRoot(Sdsd)

    buildType(FilterOutDefaultBranch)
}

object FilterOutDefaultBranch : BuildType({
    name = "FilterOutDefaultBranch2"

    vcs {
        root(Comp)

        branchFilter = """
            +:*
            -:<default>
            -:brch
            -:branch2
        """.trimIndent()
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

object Ddfdf : GitVcsRoot({
    name = "ddfdf"
    url = "https://github.com/asdkjkj"
    branch = "refs/heads/master"
    authMethod = password {
        userName = "skj"
        password = "credentialsJSON:8d007738-1378-447d-8916-44c748a10df1"
    }
})

object Dfdf : SvnVcsRoot({
    name = "dfdf"
    url = "https://ddlfk.visualstudor.com"
    userName = "a"
    password = "credentialsJSON:259ff54f-0444-4496-b247-71dc84c51dfb"
})

object Sdkj : GitVcsRoot({
    name = "sdkj"
    url = "sdaslkdj"
    branch = "refs/heads/master"
    authMethod = password {
        userName = "fgfg"
        password = "credentialsJSON:13f5e742-4fc6-4e48-9416-d9974bae1ed5"
    }
})

object Sdsd : SvnVcsRoot({
    name = "sdsd"
    url = "https://sdklsk.clksd.com"
    userName = "dfd"
    password = "credentialsJSON:dfcdab12-3c85-4bc7-ad79-6e914e0f7790"
})

object Tiger : GitVcsRoot({
    name = "tiger"
    url = "https://tiger.com"
    branch = "refs/heads/master"
    authMethod = password {
        userName = "AChubatova"
        password = "credentialsJSON:828deb71-9d3e-47a1-a88c-d45d94705a55"
    }
})
