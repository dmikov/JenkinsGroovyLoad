def scripts;
node{
  scripts = load('scripts.groovy')
}

pipeline {

  agent any

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
    // stage('Load scripts') {
    //   steps{
    //     script{
    //       scripts = load('scripts.groovy')
    //     }
    //   }
    // }
    stage('Use scripts') {
      steps {
        script {
          scripts.printThis('!!!!! MESSAGE !!!!!')
          scripts.printEnv()
        }
      }
    }
    stage('Conditional') {
      when { expression { return scripts.buildThis('/') } }
      steps {
        sh('echo ${env.IMAGE.GROOVY_LOAD}')
      }
 
    }
  }
}
