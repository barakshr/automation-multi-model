export M2_HOME="/Users/barakshamir/Documents/HOME/apache-maven"
PATH="${M2_HOME}/bin:${PATH}"
export PATH
mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen https://www.lambdatest.com/selenium-playground/"