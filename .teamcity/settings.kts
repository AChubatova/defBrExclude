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

    vcsRoot(Flower)
    vcsRoot(Sdpasodipoi)
    vcsRoot(Monkey)
    vcsRoot(HttpsGithubComXunitSamplesXunit)
    vcsRoot(Kasdjlkasjd)
    vcsRoot(Lion)
    vcsRoot(Comp)
    vcsRoot(Xcxc)
    vcsRoot(Babushka)
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
        root(HttpsGithubComXunitSamplesXunit)

        branchFilter = """
            +:*
            -:<default>
            -:brch
            -:branch2
        """.trimIndent()
    }
})

object Babushka : SvnVcsRoot({
    name = "babushka"
    url = "https://sdkj.clk"
    userName = "asdasd"
    password = "credentialsJSON:dd2a99dd-56b8-415f-8693-c630ed71b024"
    passphrase = "credentialsJSON:dd2c9df4-659b-44de-873c-bf0ddd8b1653"
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

object Flower : SvnVcsRoot({
    name = "flower"
    url = "https://flower.com"
    userName = "abc"
    password = "credentialsJSON:3695b330-e752-4181-9fea-0f42c109abd3"
})

object HttpsGithubComXunitSamplesXunit : GitVcsRoot({
    name = "https://github.com/xunit/samples.xunit"
    url = "https://github.com/xunit/samples.xunit"
    branch = "refs/heads/main"
})

object Kasdjlkasjd : SvnVcsRoot({
    name = "kasdjlkasjd"
    url = "https://k.l"
    userName = "a"
    password = "credentialsJSON:a353cfd6-0035-4e48-a996-c850fec3a269"
})

object Lion : SvnVcsRoot({
    name = "lion"
    url = "https://sdkj.dl"
    userName = "abc"
    password = "credentialsJSON:3695b330-e752-4181-9fea-0f42c109abd3"
})

object Monkey : SvnVcsRoot({
    name = "monkey"
    url = "https://skdj.bm"
    password = "credentialsJSON:3695b330-e752-4181-9fea-0f42c109abd3"
})

object Sdpasodipoi : SvnVcsRoot({
    name = "sdpasodipoi"
    url = "https://doctor.do"
    userName = "doctor"
    password = "credentialsJSON:f8348dfe-6b69-4c9e-8d88-e1707124dd85"
})

object Sdsd : GitVcsRoot({
    name = "sdsd"
    url = "https://git.git"
    branch = "sldk"
    authMethod = password {
        userName = "aas"
        password = "credentialsJSON:851f7076-b689-4758-ab5b-c213e4409a57"
    }
})

object Xcxc : GitVcsRoot({
    name = "xcxc"
    url = "https://gihub.com"
    branch = "refs/heads/master"
    authMethod = password {
        userName = "achubatova"
        password = "credentialsJSON:82318fd5-6a50-409a-96a8-9cd360ddca82"
    }
})
