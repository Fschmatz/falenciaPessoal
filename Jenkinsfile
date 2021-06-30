pipeline{
    environment {
        BRANCH_NAME = "${env.BRANCH_NAME}"
    }
    agent any
    stages {
        stage ('Build - Homologacão'){
            steps{
                sh 'mvn clean package -DskipTests=true'
            }
        }
        stage ('Liquibase'){
            steps{
                sh 'mvn liquibase:update'
            }
        }
        stage ('Testes') {
            steps {
                sh 'mvn test'
            }
        }
        stage ('Deploy - Homologacão') {
            steps {
                sh 'docker-compose -f docker-compose-homolog.yml up --build --force-recreate -d'
            }
        }
        stage ( 'Requisitar Aprovacão' ) {
            steps {
                script {
                    timeout(time: 12, unit: 'HOURS') {
                        input message: 'Aprovado ?', ok: 'Sim'
                    }
                }
            }
        }
        stage ('Deploy - Producão') {
            steps {
                sh 'docker-compose -f docker-compose-prod.yml up --build --force-recreate -d'
            }
        }
    }
    post {
        always {
            junit allowEmptyResults: true, testResults: 'target/surefire-reports/.xml, api-test/target/surefire-reports/.xml, functional-test/target/surefire-reports/.xml, functional-test/target/failsafe-reports/.xml'
            archiveArtifacts artifacts: 'target/*.jar', onlyIfSuccessful: true
        }
    }
}