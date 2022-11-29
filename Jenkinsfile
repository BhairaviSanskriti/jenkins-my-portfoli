def g_script

pipeline{
  agent any
  
  stages{
    
    stage('Init Stage'){
      steps{
        script{
          g_script = load 'script.groovy'
      
        }
      }
    }  
    
    stage('Image Build Stage'){
      steps{
        script{
          g_script.buildImage()
        }
      }
    }  
    
    stage('Test Stage'){
      steps{
        script{
          g_script.testApp()
        }
      }
    }

    stage('Deploy Stage'){
      when{
        expression{
          BRANCH_NAME == 'main'
        }
      }
      steps{
        script{
          g_script.deployApp()
        }
      }
    }  

    stage('Update application version'){
      script{
        steps{
          g_script.commitChanges()
        }
      }
    }
  }
}
