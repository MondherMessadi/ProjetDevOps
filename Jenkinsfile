pipeline {
    agent any

    stages {
        stage('Récupération du code de la branche') {
            steps {
                git branch: 'azizghebrich' , 
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
                withCredentials([string(credentialsId: 'SonarQ', variable: 'SONAR_TOKEN')]) {
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
                        credentialsId: 'nexusC',
                        groupId: 'tn.esprit.rh',
                        nexusUrl: '192.168.100.7:8081',
                        nexusVersion: 'nexus3',
                        protocol: 'http',
                        repository: 'Aziz_Ghebrich_5Sleam1/',
                        version: '1.0'
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    // Build the Docker image (replace 'Dockerfile' with your Dockerfile location)
                    sh 'docker build -t azizghebrich/achat:1.0 -f Dockerfile .'
                }
            }
        }

        stage('Push to DockerHub') { 
            steps { 
                script { // Log in to DockerHub using the credentials 
                        withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'DOCKERHUB_PWD')]) { 
                        sh "docker login -u azizghebrich -p ${DOCKERHUB_PWD}" 
                         } 
                           // Push the Docker image to DockerHub 
                         sh 'docker push azizghebrich/achat:1.0'
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
