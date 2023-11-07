pipeline {
    agent any

    stages {
        stage('Récupération du code de la branche') {
            steps {
                git branch: 'MohamedTrabelsi',
                url: 'https://github.com/MondherMessadi/ProjetDevOps.git'
            }
        }

        stage('Nettoyage et compilation avec Maven') {
            steps {
                // Étape de nettoyage du projet
                sh "mvn clean"

                // Étape de compilation du projet
                sh "mvn compile"
                // Etape de sonar
            }
        }
      
        stage('MVN SONARQUBE'){
        steps {
            sh "mvn sonar:sonar -Dsonar.login=sqa_9ef0a27231c4d3a5152a56982c2edbd71da162ec"
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
        
    }
}
