node {

     def mvnHome = tool 'Maven3.6.0'
     def javaHome = tool 'jdk8'
    sh "${mvnHome}/bin/mvn -B verify"
    sh "${javaHome}/bin -B verify"

    checkout scm

    // Pega o commit id para ser usado de tag (versionamento) na imagem
    sh "git rev-parse --short HEAD > commit-id"
    tag = readFile('commit-id').replace("\n", "").replace("\r", "")
    
    // configura o nome da aplicação, o endereço do repositório e o nome da imagem com a versão
    appName = "projetogeral-api"
    registryHost = "127.0.0.1:30400/"
    imageName = "${registryHost}${appName}:${tag}"


    environment {
    PROJECT_PORT = '8080'
    MYSQL_URL    = 'jdbc:mysql://mysql.mmpasserini.com.br:3306/mmpasserini01?useTimezone=true&serverTimezone=UTC'
    MYSQL_DROPTYPE = 'create-drop'
    MYSQL_USER = 'mmpasser01_add1'
    MYSQL_PASSWORD = 'Rapha123'
    }    

    stage "Check Path"

        sh ''' echo "PATH = ${PATH}" echo "M2_HOME = ${M2_HOME}" '''
        
    
    stage "Buidando Aplicação"
    
        sh 'mvn -Dmaven.test.failure.ignore=true install' 

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








