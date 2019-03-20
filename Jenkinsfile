
def  appName = "projetogeral-api"
def  registryHost = "127.0.0.1:30400/"
def  tag = "1.0"
def  imageName = "${registryHost}${appName}:${tag}"


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

        stage ('deploy') {
            steps {
                input "Deploy to PROD?"
                customImage.push('latest')
                sh "kubectl apply -f https://raw.githubusercontent.com/RaphaelBlefari/${appName}/master/${appName}.yaml"
                sh "kubectl set image deployment app app=${imageName} --record"
                sh "kubectl rollout status deployment/${appName}"
            }
        }
    }
}