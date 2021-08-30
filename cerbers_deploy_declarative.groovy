import hudson.Util;

pipeline {

    agent {
        label "magicBook"
    }

    stages {
        stage("Stage 1") {
            steps {
                echo "4e kavo!"
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
}