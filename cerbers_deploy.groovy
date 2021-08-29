import hudson.Util;

stage('Deploy') {
    sh """ansible-playbook playbook.yml"""
}