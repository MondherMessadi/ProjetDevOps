pipeline {
    agent any

    stages {
        stage('Récupération du code de la branche') {
            steps {
                sh 'git clone https://github.com/MondherMessadi/ProjetDevOps.git project_directory' 
            }
        }

        stage('Nettoyage et compilation avec Maven') {
            steps {
                // Étape de nettoyage du projet
                sh "mvn clean"

                // Étape de compilation du projet
                sh "mvn compile"
            }
            stage('MVN SONARQUBE') {
            steps {
                mvn sonar:sonar -Dsonar.login=sonar
            }
        }
        }
    }
}
