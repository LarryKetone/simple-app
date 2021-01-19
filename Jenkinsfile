pipeline {

   agent any


   environment {

       // use your actual issuer URL here and NOT the placeholder {yourOktaDomain}

       OKTA_OAUTH2_ISSUER           = 'https://dev-7700958.okta.com/oauth2/default/oauth2/default'

       OKTA_OAUTH2_CLIENT_ID        = credentials('0oa3u0qvoXJ3pl1sT5d6')

       OKTA_OAUTH2_CLIENT_SECRET    = credentials('8hZW362-TN1ZteTDItwFBvfwpS4gGX3ojc8suMuy')

   }


   stages {

      stage('Build') {

         steps {

            // Get some code from a GitHub repository

            git 'https://github.com/<your-username>/simple-app.git'


            // Run Maven on a Unix agent.

            sh "./mvnw -Dmaven.test.failure.ignore=true clean package"


            // To run Maven on a Windows agent, use

            // bat "mvn -Dmaven.test.failure.ignore=true clean package"

         }


         post {

            // If Maven was able to run the tests, even if some of the test

            // failed, record the test results and archive the jar file.

            success {

               junit '**/target/surefire-reports/TEST-*.xml'

               archiveArtifacts 'target/*.jar'

            }

         }

      }

   }

}
