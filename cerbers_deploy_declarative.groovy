pipeline {

    agent {
        label "magicBook"
    }

    stages {
        stage("Stage 1") {
            steps {
                sh "ansible-playbook playbook.yml"
            }
        }
        stage("Stage 2") {
            steps {
                echo "Su4ara!"
            }
        }
        stage("Stage 3") {
            steps {
                echo "Albuquerque!"
            }
        }
    }

    post {
        echo "Всё прошло Гуд!!!"
    }
}