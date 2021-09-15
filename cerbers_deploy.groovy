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
            echo "4e kavo!"
            currentBuild.result = 'UNSTABLE'
            result = 'UNSTABLE';
        }
        sh """ansible-playbook playbook.yml"""
    }
}
