def buildImage(){
  echo "Image is building..."
  withCredentials([usernamePassword(credentialsId: 'github', passwordVariable: 'PSW', usernameVariable: 'USER')]) {
    sh "docker build -t bhairavisanskriti/sanskriti-website:${VERSION}"
    sh "echo ${PSW} | docker login -u ${USER} --password-stdin"
    sh "docker push bhairavisanskriti/sanskriti-website:${VERSION}"
  }
  echo "Image is pushed to DockerHub"
}

def testApp(){
  echo "Testing application..."
}

def deployApp(){
  echo "Deploying application..."
}
