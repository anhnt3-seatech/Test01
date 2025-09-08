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
               	bat """
               	IF EXIST "target\\TestApp-1.0-SNAPSHOT.war" (
                    bat 'mvn clean install'
                ) ELSE (
                    echo WAR file not found. Deployment failed.
                    exit 1
                )
                """
            }
        }
        stage('Deploy') {
            steps {
                bat """
                	IF EXIST "target\\TestApp-1.0-SNAPSHOT.war" (
                        copy /Y "target\\TestApp-1.0-SNAPSHOT.war" "E:\\Setup\\devtools\\apache-tomcat-8.0.53\\webapps\\TestApp.war"
                    ) ELSE (
                        echo WAR file not found. Deployment failed.
                        exit 1
                    )
                    
                    copy /Y target\\TestApp-1.0-SNAPSHOT.war "%TOMCAT_WEBAPPS%\\TestApp.war"
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
