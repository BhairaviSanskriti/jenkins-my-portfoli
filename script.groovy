def buildImage(){
  echo "Image is being built with version ${param.VERSION}.${BUILD_NUMBER} ..."
  withCredentials([usernamePassword(credentialsId: 'docker', passwordVariable: 'PSW', usernameVariable: 'USER')]) {
    sh "docker build -t bhairavisanskriti/sanskriti-website:${VERSION}.${BUILD_NUMBER}"
    sh "echo ${PSW} | docker login -u ${USER} --password-stdin"
    sh "docker push bhairavisanskriti/sanskriti-website:${VERSION}.${BUILD_NUMBER}"
  }
  echo "Image is pushed to DockerHub."
}

def testApp(){
  echo "Testing application..."
}

def deployApp(){
  echo "Deploying application..."
}
