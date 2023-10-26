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
        stage('Mockito'){
        steps {
            sh "mvn test"
        }
        }
        stage('mvn deploy'){
            steps {
                sh "mvn deploy"
            }
        }
    }
}
