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

            sh "gradle --b ./build.gradle test"

            }
         }

         stage('Static Code Analysis') {
         			steps{
         				echo "------------>Sonar<------------"
         				withSonarQubeEnv('Sonar') {
         					sh "${tool name: 'SonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=./sonar-project.properties"
         				}
         			}
         		}

      }

       post {
      	success {
      		junit 'build/test-results/test/*.xml'
      	}
      }
   }