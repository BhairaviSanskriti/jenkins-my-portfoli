def buildImage(){
  echo "Image is being built with version ${BUILD_NUMBER} ..."
  withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'PSW', usernameVariable: 'USER')]) {
    sh "docker build -t bhairavisanskriti/sanskriti-website:${BUILD_NUMBER} ."
    sh "echo ${PSW} | docker login -u ${USER} --password-stdin"
    sh "docker push bhairavisanskriti/sanskriti-website:${BUILD_NUMBER}"
  }
  echo "Image is pushed to DockerHub."
}

def testApp(){
  echo "Testing application..."
}

def deployApp(){
  echo "Deploying application..."
}

def commitChanges(){
  withCredentials([usernamePassword(credentialsId: 'github', passwordVariable: 'PSW', usernameVariable: 'USER')]) {
    sh 'git config --global user.name "jenkins"'
    sh 'git config --global user.email "my.jenkins.server@gmail.com"'
    sh "git remote set-url origin https://${USER}:${PSW}@github.com/BhairaviSanskriti/jenkins-my-portfolio.git"
    sh "git add ."
    sh 'git commit -m "updated version"'
    sh "git push origin HEAD:${BRANCH_NAME}"
  }
}

return this
