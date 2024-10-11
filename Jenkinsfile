pipeline {
    agent {label 'main'}

    stages {
        stage('test') {
            steps {
				dir "QualityStreamTutorial"
                sh "mvn clean compile test"
            }
        }
        stage('Build application') {
            steps {
                echo 'mvn clean install -Dmaven.test.skip-true'
            }
        }
        stage('Create docker image') {
            steps {
                echo 'creando docker'
            }
        }
    }
}
