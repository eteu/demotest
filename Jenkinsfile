pipeline {
    agent any
    tools {
        maven 'maven1'
    }
    stages {
        stage('maven build') {
            steps {
                bat 'mvn clean package'
            }
        }
        stage('build_image') {
            steps {
                script {
                    dockerImage = docker.build('demotest:latest')
                    echo 'image build OK '
                }
            }
        }
        stage('execution') {
            steps {
                script {
                    try {
                        bat "docker stop DemoTest"
                        bat "docker rm DemoTest"
                    } catch(Exception e) {
                        echo "non trouvé"
                    }
                    bat "docker run --name DemoTest -d -p 8075:8080 demotest:latest nomDemoTest.jar"
                }
            }
        }
    }
}
