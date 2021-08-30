import hudson.Util;

pipeline {

    agent {
        label "magicBook"
    }

    stages {
        stage("Clone Pipeline") {
            steps {
                echo "Hello Mraz!"
            }
        }
    }
}