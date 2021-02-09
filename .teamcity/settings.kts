import jetbrains.buildServer.configs.kotlin.v2019_2.*
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

    params {
        param("acc", "ac")
        param("a", "a")
        password("ac", "credentialsJSON:e6e1b518-fa68-401a-87da-be635f3d2051")
        param("b", "b")
    }
}

object Dskfjlalskdj : SvnVcsRoot({
    name = "dskfjlalskdj"
    url = "https://skdj.ck"
    userName = "AChubatova"
    password = "credentialsJSON:95fb58bf-be17-41ba-afbb-32267aad0bea"
})
