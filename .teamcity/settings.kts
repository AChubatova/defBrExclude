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

    vcsRoot(Tigernotalone)
    vcsRoot(Pirat)
    vcsRoot(Razboinik)
    vcsRoot(Comp)
    vcsRoot(Tiger)
    vcsRoot(Sdkj)
    vcsRoot(Sdsd)

    buildType(FilterOutDefaultBranch)

    params {
        password("pwd2", "credentialsJSON:72ae78b7-3767-45b9-a0d8-2ff5ed2bf1f8")
        password("pwdtiger", "credentialsJSON:fe4ab7ed-0dc4-4bc9-8343-29c5f9e28b29")
        param("pwd", "pwdpwdpwdp")
        param("xcxc", "xcxc")
    }
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

object Pirat : GitVcsRoot({
    name = "pirat"
    url = "https://pirat.com"
    branch = "refs/heads/master"
    authMethod = password {
        userName = "AChubatova"
        password = "credentialsJSON:60f03ea7-2594-45c5-8193-b9c4f78ac375"
    }
})

object Razboinik : GitVcsRoot({
    name = "razboinik"
    url = "https://razboinik.com"
    branch = "refs/heads/masdter"
    authMethod = password {
        userName = "AChubatova"
        password = "credentialsJSON:91748f86-5c7c-4eb8-a49e-84d7903718c2"
    }
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
    password = "credentialsJSON:6ffea745-b7e2-4a7d-8cd8-85f00070bb19"
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

object Tigernotalone : GitVcsRoot({
    name = "tigernotalone"
    url = "https://sjshd.dfkj"
    branch = "sdfdf"
    authMethod = password {
        userName = "AChubatova"
        password = "credentialsJSON:b89ad2ad-a8f4-4805-8830-5b02af5eb261"
    }
})
