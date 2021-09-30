pipeline {

    agent {
        label "magicBook"
    }

    stages {
        stage("Deploy") {
            steps {
                script {
                    def x = true
                    if (x) {
                        catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                            sh "exit 1"
                        }
                    }
                }
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