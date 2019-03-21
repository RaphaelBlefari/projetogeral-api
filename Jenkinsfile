def imageName = "${registryHost}${appName}:${env.BUILD_ID}"
def namespace = 'applications'

pipeline {
    agent any 
    stages {

      stage('Maven Build') {
        steps {
           echo namespace
        }
      }


      stage('Maven Build') {
        steps {
          echo imageName
        }
      }

    }
}