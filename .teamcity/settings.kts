import jetbrains.buildServer.configs.kotlin.v2019_2.*
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

    vcsRoot(Dskfjlalskdj)
    vcsRoot(Adasd)

    buildType(Gfhgf)

    params {
        param("acc", "ac")
        password("nv", "credentialsJSON:eac70b87-f454-49c0-983b-0c32eaf074ee")
        param("a", "a")
        password("ac", "credentialsJSON:e6e1b518-fa68-401a-87da-be635f3d2051")
        param("b", "b")
    }
}

object Gfhgf : BuildType({
    name = "gfhgf"

    vcs {
        root(DslContext.settingsRoot)
    }
})

object Adasd : SvnVcsRoot({
    name = "adasd"
    url = "https://sdlk.svn"
    userName = "AChubatova"
    password = "credentialsJSON:bbe0ebb8-3f1c-4443-b83f-510dd1763dc9"
})

object Dskfjlalskdj : GitVcsRoot({
    name = "dskfjlalskdj"
    url = "https://github.com/AChubatova/defBrExclude"
    branch = "refs/heads/main"
    authMethod = password {
        userName = "AChubatova"
        password = "credentialsJSON:95fb58bf-be17-41ba-afbb-32267aad0bea"
    }
})
