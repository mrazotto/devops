import hudson.Util;

node("magicBook") {
    stage('Git Clone') {
        cleanWs()

            checkout([$class            : 'GitSCM',
                      branches          : [[name: "*/develop"]],
                      doGenerateSubmoduleConfigurations: false,
                      gitTool           : 'Default',
                      submoduleCfg      : [],
                      userRemoteConfigs : [[
                          credentialsId : "mrazotto",
                          url           : 'https://github.com/mrazotto/cerbers.git']]])

        dir('cerbers_devops') {
            checkout([$class            : 'GitSCM',
                      branches          : [[name: "*/develop"]],
                      gitTool           : 'Default',
                      userRemoteConfigs : [[
                          credentialsId : "mrazotto",
                          url           : 'https://github.com/mrazotto/devops.git']]])
        }
    }

    stage('Create Configs Templates ') {
        sh "sh cerbers_devops/scripts/service/cerbers_templates.sh"
    }

    stage('Build distrib') {
        sh """zip -r nydus.zip \
                ./aserver \
                ./blserver \
                ./restserver \
                ./arestserver \
                ./autserver \
                ./cerbers_templates"""
    }

    stage('Send to Nydus') {

    }

}
