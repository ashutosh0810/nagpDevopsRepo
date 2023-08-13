pipeline {
    agent any

    tools {
            maven "MAVEN_HOME"

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

        stage('build') {
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

           stage('Deploy to Artifactory') {
                    when {
                        expression { currentBuild.resultIsBetterOrEqualTo('SUCCESS') }
                    }
                    steps {
                        rtMavenDeployer(
                           id: 'deployer',
                           serverId: 'nagp@jfrog',
                           releaseRepo: 'testrepo',
                           snapshotRepo: 'testrepo'
                           )
                        rtMavenRun(
                           pom: 'pom.xml',
                           goals: 'clean install',
                           deployerId: 'deployer'
                        )
                        rtPublishBuildInfo(
                           serverId: 'nagp@jfrog'
                        )


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
