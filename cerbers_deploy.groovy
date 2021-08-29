import hudson.Util;

node("magicBook") {
    stage('Deploy') {
        sh """ansible-playbook playbook.yml"""
    }
}
