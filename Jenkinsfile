pipeline {
    agent any
    tools {
        maven 'Maven3.6.0'
        jdk 'jdk8'
    }

    
    environment {
        PROJECT_PORT = '8080'
        MYSQL_URL    = 'mysql.mmpasserini.com.br'
        MYSQL_DROPTYPE = 'create-drop'
        MYSQL_USER = 'mmpasser01_add1'
        MYSQL_PASSWORD = 'Rapha123'
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
                sh 'mvn -Dmaven.test.failure.ignore=true install' 
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
    }
}