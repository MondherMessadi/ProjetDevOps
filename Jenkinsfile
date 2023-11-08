pipeline {
    agent any
environment {
    		DOCKERHUB_CREDENTIALS=credentials('projet')
    	}
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
        
        stage('NEXUS') {
            steps {
                sh 'mvn deploy -DskipTests'
            }
        }

        stage('Docker Image') {
                           steps {
                               sh 'docker build -t mohamedtrabelsi-5sleam1 .'
                           }
               }
        stage('DOCKERHUB') {
                          steps {
                              sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                              sh 'docker tag mohamedtrabelsi-5sleam1 mohamedtrabelsi/med-5sleam1:1.0.0'
                              sh 'docker push mohamedtrabelsi/med-5sleam1:1.0.0'
                          }
                      }
        stage('Deploy with Docker Compose') {
        steps {
                sh 'docker compose up -d'  // Use -d to run in detached mode
        
            }
        }
        stage('Grafana/prometheus') {
            steps {
                sh 'docker start 94eaffdddd29'
                sh 'docker start 79be138fec0b'
            }
        }
    }
}
