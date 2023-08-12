pipeline {
    agent any

     triggers {
             cron('H/5 * * * *')
             pollSCM('H/5 * * * *')
        }
    stages {
        stage('Checkout from GitHub') {
            steps {
                // Checkout from the Git repository and branch
                git(
                    url: 'https://github.com/ashutosh0810/nagpDevopsRepo.git',
                    branch: 'master'
                )
            }
        }

        stage('Test') {
            steps {
                script {
                    // Maven build and test
                    bat 'mvn clean '
                }
            }
        }

           stage('Test') {
                    steps {
                        script {
                            // Maven build and test
                            bat 'mvn test'
                        }
                    }
                }

        stage('SonarQube Analysis') {
            steps {
                script {
                    // SonarQube scan
                    withSonarQubeEnv('test_sonar') {
                        bat 'mvn sonar:sonar'
                    }
                }
            }
        }
    }

    post {
        always {
            // Always archive the artifacts and TestNG results
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true

        }
    }
}
