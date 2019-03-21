def appName = 'projetogeral-api'
def registryHost = '127.0.0.1:30400'
def imageName = "${registryHost}${appName}:${env.BUILD_ID}"
def namespace = 'default'

pipeline {
    agent any 
    stages {

      stage('Maven Build') {
        steps {
           echo namespace
        }
      }


      stage('Maven Build2') {
        steps {
          echo imageName
        }
      }

    }
}