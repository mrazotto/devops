pipeline {

    agent {
        label "magicBook"
    }

    stages {
        stage("Deploy") {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    sh "exit 1"
                }
                echo "AAAAAAAAAAAA"
            }
        }
        stage("Random Stage") {
            steps {
                echo "Su4ara!"
            }
        }
    }

//    post {
//        cleanup {
//            cleanWs()
//        }
//    }
}