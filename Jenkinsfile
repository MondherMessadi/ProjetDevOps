pipeline {
    agent any

    stages {
        stage('Récupération du code de la branche') {
            steps {
                git branch: 'ayedboukadida' ,
                url : 'https://github.com/MondherMessadi/ProjetDevOps.git';
            }
        }

        stage('Nettoyage et compilation avec Maven') {
            steps {
                // Étape de nettoyage du projet
                sh "mvn clean"

                // Étape de compilation du projet
                sh "mvn compile"
            }
        }
          stage('Exécution des tests') {
            steps {
                sh "mvn test "  // Run JUnit tests
            }


        }
        stage('SonarQube') {
            steps {
                // Provide SonarQube authentication using the provided token
                withCredentials([string(credentialsId: 'DevOpsAyed', variable: 'SONAR_TOKEN')]) {
                    sh "mvn sonar:sonar -Dsonar.login=$SONAR_TOKEN"
                }
            }
        }
         stage("Maven Build") {
            steps {
                script {
                    sh "mvn package -DskipTests=true"
                }
            }
        }

               stage('Publish Artifacts to Nexus') {
            steps {
                script {
                    nexusArtifactUploader artifacts: [[
                        artifactId: 'achat',
                        classifier: '',
                        file: 'target/achat-1.0.jar',
                        type: 'jar']],
                        credentialsId: 'nexusCredentials',
                        groupId: 'tn.esprit.rh',
                        nexusUrl: '192.168.1.17:8081',
                        nexusVersion: 'nexus3',
                        protocol: 'http',
                        repository: 'maven-releases/',
                        version: '1.0'
                }
            }
        }

 stage('Build Docker Image') {
    steps {
        script {
              sh 'docker build -t ayedboukadida/achat:1.0 -f Dockerfile .'
        }
    }
}

stage('Push to DockerHub') {
    steps {
        script {
            // Use DockerHub token as a credential
            withCredentials([usernamePassword(credentialsId: 'dockertoken', usernameVariable: 'DOCKERHUB_USERNAME', passwordVariable: 'DOCKERHUB_PASSWORD')]) {
                sh "docker login -u $DOCKERHUB_USERNAME -p $DOCKERHUB_PASSWORD"
            }

            // Push the Docker image to DockerHub
            sh 'docker push ayedboukadida/achat:1.0'
        }
    }
}
    stage('Deploy with Docker Compose') {
        steps {
                sh 'docker-compose up -d'  // Use -d to run in detached mode

            }
        }


}
}