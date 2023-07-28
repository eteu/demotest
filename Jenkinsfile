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
                dockerImage = docker.build('demotest:latest')
                echo 'image build OK'
            }
        }
    }
}