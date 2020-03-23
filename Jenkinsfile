def scripts;

pipeline {

  agent { node { label 'linux'} }

  environment {
    IMAGE_GROOVY_LOAD = 'dmikov/groovy-load'
  }

  options {
    disableConcurrentBuilds()
    timeout(time: 45, unit: 'MINUTES')
    timestamps()
    buildDiscarder(logRotator(artifactNumToKeepStr: '1'))
  }

  stages{ 
    stage('Load scripts') {
      steps{
        script{
          scripts = load('scripts.groovy')
        }
      }
    }
    stage('Use scripts') {
      steps {
        script {
          scripts.printThis('!!!!! MESSAGE !!!!!')
        }
      }
    }
    stage('Conditional') {
      when { expression { return buildThis() } }
      steps {
        sh('echo $env.IMAGE.GROOVY_LOAD')
      }
 
    }
  }
}
