# AutomationGambling

I have to completed all the Tasks mentioned in the Challenge,I have created a partial Automation Framework comprise of (Selenium+JAVA+JUnit+Page Object Model+MAVEN+log4j2).

Main code is in :src/main/java/betTestChallenge/Automation/codeBase/Base.java Test code is in :src/test/java/betTestChallenge/Automation/AppTest.java

Prerequisites – SYSTEM SETUP Java: v1.8 v)(if not installed use: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

Eclipse

Maven:Apache Maven 3.5.4 , if its not installed please install from "https://maven.apache.org/install.html"

STEPS TO FOLLOW FOR EXECUTION OF CODE: Clone the code by using below command at your folder destination where you want the code. https://github.com/manushray/AutomationGambling.git

Open the Eclipse follow the below steps: Click on the "File > Import " Navigate to Maven > Existing Maven Projects & click on "Next". Browse to the location of folder where you have clone the code & click on "Finish" I have created a partial Automation Framework comprise of (Selenium+JAVA+JUnit+Page Object Model) where my "Base" class is Parent of all the classes which is present under package name "betTestChallenge.Automation.codeBase" Reading of config.properties , driver , selection of browser type all these activities are done in "Base" Class As I have made my code dynamic from where you can change the parameter and data set/Test Scneario by changing in the config.properties file which is present under package name "/src/main/java/betTestChallenge/Automation/Configuration/config.properties"

This Project IS A DYNAMIC Project where you can pass the parameter and test cases will run for that particular scenario.

YOU HAVE TO CHANGE THE PARAMETERS in config.properties present at (/src/main/java/betTestChallenge/Automation/Configuration/config.properties)AS MENTIONED BELOW:

While placing a bet I am 1st navigating to "Next 48 hours" so please go to that link and change below parameter as these are the TEAMS NAME where user can put their bet
1. single_bet_match(Match name where user wants to place a bet, You can take by click > on the team fixture > Right click > Inspect)(Match name where user wants to place a bet, You can take by click > on the team fixture > Right click > Inspect)
2. multi_bet_match-Here you have to take 5 names from the site as we have to place 5 bet(Match name where user wants to place a bet, You can take by click > on the team fixture > Right click > Inspect)

Apart from that you can change many variable according to your choice.

Once you have done your changes in config.properties then you dont have to do any changes , just run the project as mention below(The full script runs for couple of min so please dont kill the browser if it takes time to identify/load the page.

If you want to re-run the project again & again then please do change the parameter mentioned above in "config.properties"

Eclipse: Click on "Project > Run As > JUnit Test"

I am printing message from each method on console as well using log4j2 for logging purpose.

