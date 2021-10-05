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
            currentBuild.result = 'FAILURE'
            result = 'FAILURE'

            echo "### Stage name: ${env.STAGE_RESULT}"
        }
//        sh """ansible-playbook playbook.yml"""
    }
    stage('AfterStage') {
        echo "4e kavo su4ara Albuquerque!"
    }
}
