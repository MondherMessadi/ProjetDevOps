pipeline {
    agent any

    stages {
        stage('Récupération du code de la branche') {
            steps {
                git branch: 'hassenbenadel',
                url: 'https://github.com/MondherMessadi/ProjetDevOps.git'
            }
        }

        stage('Nettoyage et compilation avec Maven') {
            steps {
                sh "mvn clean"
                sh "mvn compile"
            }
        }

        stage('Exécution des tests') {
            steps {
                sh "mvn test -e"  // Run JUnit tests
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withCredentials([string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')]) {
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
                        nexusUrl: '192.168.56.8:8081',
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
              sh 'docker build -t hassenbenadel/achat:2.0 -f Dockerfile .'
        }
    }
}

stage('Push to DockerHub') {
    steps {
        script {
            // Use DockerHub token as a credential
            withCredentials([usernamePassword(credentialsId: 'DockerToken', usernameVariable: 'DOCKERHUB_USERNAME', passwordVariable: 'DOCKERHUB_PASSWORD')]) {
                sh "docker login -u $DOCKERHUB_USERNAME -p $DOCKERHUB_PASSWORD"
            }

            // Push the Docker image to DockerHub
            sh 'docker push hassenbenadel/achat:1.0'
        }
    }
}


    }
}
