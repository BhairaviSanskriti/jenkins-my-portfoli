pipeline{
  def g_script
  agent any
  
  stages{
    
    stage('Init Stage'){
      steps{
        g_script = load 'script.groovy'
      }
    }  
    
    stage('Image Build Stage'){
      steps{
        g_script.buildImage()
      }
    }  
    
    stage('Test Stage'){
      steps{
        g_script.testApp()
      }
    }

    stage('Deploy Stage'){
      when{
        expression{
          BRANCH_NAME == 'main'
        }
      }
      steps{
        g_script.deployApp()
      }
    }  

    stage('Update application version'){
      g_script.commitChanges()
    }
  }
}
