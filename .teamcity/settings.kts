import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.PullRequests
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.commitStatusPublisher
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.pullRequests
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

    vcsRoot(Sdsdafjjhkjh)

    buildType(Pullreq)
    buildType(BrFilter)

    params {
        param("a", "a")
    }
}

object BrFilter : BuildType({
    name = "brFilter"

    vcs {
        root(Sdsdafjjhkjh)

        branchFilter = "+:branch2"
    }
})

object Pullreq : BuildType({
    name = "pullreq"

    vcs {
        root(Sdsdafjjhkjh)
    }

    triggers {
        vcs {
            triggerRules = "+:root=${Sdsdafjjhkjh.id}:sedfjhk"

        }
    }

    features {
        commitStatusPublisher {
            vcsRootExtId = "${Sdsdafjjhkjh.id}"
            publisher = github {
                githubUrl = "https://api.github.com"
                authType = personalToken {
                    token = "credentialsJSON:8ca59394-44df-4486-b34a-4e9c955a98ff"
                }
            }
        }
        pullRequests {
            vcsRootExtId = "Pullrequest_Sdsdafter"
            provider = github {
                authType = token {
                    token = "credentialsJSON:8ca59394-44df-4486-b34a-4e9c955a98ff"
                }
                filterAuthorRole = PullRequests.GitHubRoleFilter.MEMBER
            }
        }
    }
})

object Sdsdafjjhkjh : GitVcsRoot({
    name = "sdsdbefore"
    url = "https://github.com/AChubatova/composite"
    branch = "refs/heads/master"
    branchSpec = "+:refs/heads/(*)"
})
