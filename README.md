READ ME
============================

### Folder structure of the framework
    .
    |–– TestReports                                                         
    |–– actions               
    |  |–– commons            
    |  |–– listenerConfig
    |  |–– pageObjects
    |  |–– reportConfig
    |  |–– utils
    |–– browserDrivers
    |  |–– chrome
    |  |–– firefox
    |–– resources
    |–– testcases
    |  |–– Search


### Setup environment

1. Install Java 8 (We can download here: https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
2. Install Eclipse (https://www.eclipse.org/downloads/)
3. Set JAVA_HOME follows the instruction (https://docs.oracle.com/cd/E19182-01/821-0917/inst_jdk_javahome_t/index.html)
4. Install browsers: Chrome and Firefox
5. Install maven (https://www.baeldung.com/install-maven-on-windows-linux-mac)

### About the framework
- Using maven, testNG and Selenium WebDriver
- WebDriver management using WebDriverManager library and browser options to init browser drivers
- Test Suite organization: in folder testcases, it consists of features packages, in every package will be having many test cases inside
- Using extentReport

### Run Tests
The XML files in the resources folder allow running with:
- Browser Chrome/Firefox
- Multi-browser execution
- Execution by multi-thread 

#### How to run tests
1. We can run XML file directly in Eclipse IDE - run with testNG
2. Or we can run test with commands below:

