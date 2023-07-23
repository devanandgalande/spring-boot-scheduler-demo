pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven1"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/devanandgalande/spring-boot-scheduler-demo'

                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
       stage('Build Docker image') {
            steps {
                sh 'docker build -t devanandgalande/spring-boot-scheduler .'
            }
        }
        stage('Docker Push') {
            steps {
                withCredentials([string(credentialsId: 'DOCKER_HUB_PASSWORD', variable: 'DOCKER_HUB_PASSWORD')]) {
                    sh 'docker login -u devanandgalande -p ${DOCKER_HUB_PASSWORD}'
                }
                sh 'docker push devanandgalande/spring-boot-scheduler '
            }

        }
        stage('Deploy to k8s cluster') {
            sh 'kubectl apply -f deployment.yml '
        }
    }
}