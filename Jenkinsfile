pipeline {
    agent any


    sh "git rev-parse --short HEAD > commit-id"
    tag = readFile('commit-id').replace("\n", "").replace("\r", "")
    appName = "projetogeral-api"
    registryHost = "127.0.0.1:30400/"
    imageName = "${registryHost}${appName}:${tag}"


    tools {
        maven 'Maven3.6.0'
        jdk 'jdk8'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }

        }

        stage ('Build') {
            steps {
                sh 'mvn package' 
            }
        }

        
    }
}