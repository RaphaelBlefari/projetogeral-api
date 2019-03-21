def imageName = "${registryHost}${appName}:${env.BUILD_ID}"
def namespace = 'applications'

pipeline {
    agent any 
    stages {

      stage('Maven Build') {
        steps {
          faca deploy ${namespace}
        }
      }


      stage('Maven Build') {
        steps {
          faca pizza ${imageName}
        }
      }

    }
}