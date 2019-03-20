pipeline {
    agent any
    tools {
        maven 'Maven3.6.0'
        jdk 'jdk8'
    }

    
    environment {
        PROJECT_PORT = '8080'
        MYSQL_URL    = 'jdbc:mysql://mysql.mmpasserini.com.br:3306/mmpasserini01?useTimezone=true&serverTimezone=UTC'
        MYSQL_DROPTYPE = 'create-drop'
        MYSQL_USER = 'mmpasser01_add1'
        MYSQL_PASSWORD = 'Rapha123'
    }   
    
     stage ('Pegando Versão')  {
        checkout scm
        sh "git rev-parse --short HEAD > commit-id"
        tag = readFile('commit-id').replace("\n", "").replace("\r", "")
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