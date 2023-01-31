# Selenium Automation Framework Saucedemo

## Dependencies used

- Selenium
- WebDriverManager
- TestNG
- Log4J
- Allure
- JsonSimple

## Prerequisites to run the project

- [JDK 11](https://www.oracle.com/co/java/technologies/javase/jdk11-archive-downloads.html) (Environment variable)
- [Maven](https://maven.apache.org/download.cgi) (Environment variable)
- [Allure](https://docs.qameta.io/allure-report/#_installing_a_commandline) (Environment variable)
- IDE (ex. [IntelliJ](https://www.jetbrains.com/idea/download/#section=windows))

## Download and open project

### Workaround 1

#### Download project

1. Click on the code button in this repository
2. Select the Download Zip option
3. Extract the .zip file with the **Extract here** option
4. Place the project folder on the desired location

### Workaround 2 - Gitbash

1. Select the folder when you would like clone the project
2. Open gitbash, copy and paste the following command

```bash
git clone https://github.com/Diegocortes15/selenium-automation-framework-saucedemo.git
```

![image](https://user-images.githubusercontent.com/60171460/212787114-fe2b25d3-cf72-4336-9c16-83cf3b8f30d4.png)

## Run project

```bash
mvn clean verify
```

## Open allure report

```bash
allure serve target/allure-results
```

![Animation 4](https://user-images.githubusercontent.com/60171460/215754305-ce8f94ec-e7ea-48e6-9b3c-340eef1b9242.gif)
