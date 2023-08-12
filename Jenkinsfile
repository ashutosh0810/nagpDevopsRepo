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
                        script {
                            def server = Artifactory.server('nagp@jfrog')
                            def rtMaven = Artifactory.newMavenBuild()
                            //rtMaven.tool = 'Maven'  // Name of Maven installation on Jenkins
                            rtMaven.deployer releaseRepo:'libs-release-local', snapshotRepo:'libs-snapshot-local', server: server

                            // Run Maven with Artifactory integration
                            rtMaven.run pom: 'pom.xml', goals: 'clean install -Dmaven.test.skip=true'
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
