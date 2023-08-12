pipeline {
    agent any



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

        stage('Build & Test') {
            steps {
                script {
                    // Maven build and test
                    sh 'mvn clean test'
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                script {
                    // SonarQube scan
                    withSonarQubeEnv('test_sonar') {
                        sh 'mvn sonar:sonar'
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
