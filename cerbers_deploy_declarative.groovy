pipeline {

    agent {
        label "magicBook"
    }

    stages {
        stage("Deploy") {
            steps {
                sh "ansible-playbook playbook.yml"
            }
        }
        stage("Random Stage") {
            steps {
                echo "Su4ara!"
            }
        }
    }

    post {
        cleanup {
            cleanWs()
        }
    }
}