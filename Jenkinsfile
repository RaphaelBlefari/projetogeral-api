pipeline {
    agent any


    sh "git rev-parse --short HEAD > commit-id"
    tag = readFile('commit-id').replace("\n", "").replace("\r", "")
    appName = "projetogeral-api"
    registryHost = "127.0.0.1:30400/"
    imageName = "${registryHost}${appName}:${tag}"

    environment {
        PROJECT_PORT = '8080'
        MYSQL_URL    = 'mysql.mmpasserini.com.br'
        MYSQL_DROPTYPE = 'create-drop'
        MYSQL_USER = 'mmpasser01_add1'
        MYSQL_PASSWORD = 'Rapha123'
    }   


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
    }

      stage ('Build') {
            steps {
                sh 'mvn package' 
            }
        }

        stage "Buildando Imagem"

            def customImage = docker.build("${imageName}")

        stage "Push para registry"

            customImage.push()

            stage "Deploy PROD"

        input "Deploy to PROD?"
        customImage.push('latest')
        sh "kubectl apply -f https://raw.githubusercontent.com/RaphaelBlefari/${appName}/master/${appName}.yaml"
        sh "kubectl set image deployment app app=${imageName} --record"
        sh "kubectl rollout status deployment/${appName}"
}