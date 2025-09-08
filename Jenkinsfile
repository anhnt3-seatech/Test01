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
                git 'https://github.com/anhnt3-seatech/Test01.git'
            }
        }
        stage('Pre-clean workaround') {
            steps {
            	echo 'Build and Deploy Successful!'
                bat 'del /F /Q target\\TestApp-1.0-SNAPSHOT.war'
            }
        }
        stage('Build') {
            steps {
               bat 'mvn clean install'
            }
        }
        stage('Deploy') {
            steps {
                bat """
                    copy /Y \\target\\TestApp-1.0-SNAPSHOT.war "%TOMCAT_WEBAPPS%\\TestApp-1.0-SNAPSHOT.war"
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
