pipeline {
    agent any
    environment {
    	TOMCAT_WEBAPPS = "E:\\Setup\\devtools\\apache-tomcat-8.0.53\\webapps"
    }
    tools {
        maven 'Maven3'  // Tên đúng với cấu hình ở trên
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/anhnt3-seatech/MyWebApp.git'
            }
        }
        stage('Pre-clean workaround') {
            steps {
                bat 'del /F /Q MyWebApp\\target\\MyWebApp-1.0-SNAPSHOT.war'
            }
        }
        stage('Build') {
            steps {
               dir('MyWebApp') {
                    bat 'mvn clean install'
                }
            }
        }
        stage('Deploy') {
            steps {
                bat """
                    copy /Y MyWebApp\\target\\MyWebApp-1.0-SNAPSHOT.war "%TOMCAT_WEBAPPS%\\MyWebApp-1.0-SNAPSHOT.war"
                """
            }
        }
    }
    post {
        success {
            echo 'Build and Deploy Successful!'
        }
        failure {
            echo 'Build or Deploy failed, check the logs for details.'
        }
    }
}
