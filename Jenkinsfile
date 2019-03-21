def appName = 'projetogeral-api'
def registryHost = '127.0.0.1:30400'
def imageName = "${registryHost}/${appName}:${env.BUILD_ID}"
def namespace = 'default'

pipeline {
    agent any 


    stages {


		 stage('Maven Build') {
             steps {	
            	 withMaven(maven: 'Maven3.6.0', mavenSettingsConfig: 'maven-settings', mavenLocalRepo: '.repository') {
	      			 sh "mvn install -DskipTests"
            	 }
        	 }
         }


	    stage('Docker Build') {
			steps {
				script {
					def customImage = docker.build("127.0.0.1:30400/${appName}:${env.BUILD_ID}", ".")
    				customImage.push()
                    customImage.push('latest')
    			}
			}
		}

		stage ('deploy') {
            steps {
                //sh "kubectl apply -f https://raw.githubusercontent.com/RaphaelBlefari/${appName}/master/${appName}.yaml"
                sh "echo ${appName} ${imageName} ${namespace}"                
                
                sh "kubectl set image deployment ${appName} ${appName}=${imageName} -n ${namespace}"
                sh "kubectl rollout status deployment/${appName} -n ${namespace}"
            }
        }
    }
}