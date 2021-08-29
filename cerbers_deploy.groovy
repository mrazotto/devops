import hudson.Util;

node("magicBook") {
    stage('Clone pipeline') {
        checkout([$class: 'GitSCM',
                  branches: [[name: "*/develop"]],
                  doGenerateSubmoduleConfigurations: false,
                  gitTool: 'Default',
                  submoduleCfg: [],
                  userRemoteConfigs: [[
                      credentialsId: "mrazotto",
                      url: 'https://github.com/mrazotto/devops.git']]])
    }
    stage('Download .zip') {
        sh 'git clone https://github.com/mrazotto/nydus.git'
    }
    stage('Deploy') {
        sh """ansible-playbook playbook.yml"""
    }
}
