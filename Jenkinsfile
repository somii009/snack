pipeline {
    agent {node{label 'master'}}
    stages {
        stage("Docker") {
            agent{node{label 'master'}}
            environment{
                credential = "harbor-veta"
                // credential = "sfaas-harbor"
                registry = "dev-harbor.hmgics.com"
                // registry = "st-harbor.autoever.com"
                image = "veta/sfcc-be"
                //image = "sfaas/com/develop/sfcc-comm-be"
                tag = "0.1.${env.BUILD_NUMBER}"
            }
            steps {
                sh "ls -al"
                script {
                    withDockerRegistry(credentialsId: "$credential", url: "https://$registry"){
                        def img = docker.build("$registry/$image:$tag","--network host .")
                        // def img = docker.build("$registry/$image:$tag")
                        img.push()
                    }
                }
                sh "rm -rf ./target"
            }
        }
    }
}