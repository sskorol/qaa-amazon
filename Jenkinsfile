node {
    stage('Checkout from GitHub') {
        checkout scm
    }
    stage('Run Selenium Tests') {
        sh '''
            chmod +x gradlew
            ./gradlew clean test
        '''
    }
    stage('Generate report') {
        allure includeProperties: false, jdk: 'JDK 8u152', results: [[path: 'build/allure-results']]
    }
}
