import hudson.Util;

def skipRemainingStages = true

node("magicBook") {

    cleanWs()

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
    stage('Deploy') {
        if (skipRemainingStages) {
            echo "CHECKING FAILED..."
            stageResult: 'FAILURE'
        }
        sh """ansible-playbook playbook.yml"""
    }
}
