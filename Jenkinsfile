pipeline {
   agent any

   tools {

        gradle "Gradle5.6_Centos"
        jdk "JDK8_Centos"
   }

   stages {
      stage('Download Code') {
          steps {
              echo "---------Downloading Code -------------"
              checkout([
                  $class: 'GitSCM',
                  branches: [[name: '*/master']],
                  doGenerateSubmoduleConfigurations: false,
                  extensions: [],
                  gitTool: 'Default',
                  submoduleCfg: [],
                  userRemoteConfigs: [[
                      credentialsId: 'GitHub_juanp312',
                      url:'https://github.com/juanp312/CeibaFarmacia.git'
                ]]

              ])
          }
      }
      stage('Build') {
         steps {

            sh "gradle clean build"

            }
         }

       stage('Tests') {
         steps {

            sh "gradle test"

            }
         }
      }
   }