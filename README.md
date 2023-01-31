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

### How set environment variables

1. Download and save the folders where you want. Look at the links above.
2. Take in mind the `path` where you are saving your folders **that contains **jdk**.
3. Copy jdk path.
4. On windows, in search bar, type `environment variables` and click on `Edit the system environment variables`.

![environment variables](https://user-images.githubusercontent.com/60171460/157496931-f1d25ccc-66c8-4608-9a3b-24fd2411a920.gif)

5. In the `System properties` window, click `environment variables`.
6. In `Environment variables` window in `Advanced tab`, in `System variables` section, double click `Path`.
7. In `Edit environment variable` click `New` button and paste the **path that contains jdk**, then click `Ok`.
8. Close the open windows and that's all to install JDK 🥳.

![environment variables (2)](https://user-images.githubusercontent.com/60171460/157497327-09035824-bc66-4f1f-ad66-a92690bf4313.gif)

#### Browsers

Installed:
- Chrome
- Firefox
- Microsoft Edge


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

![image](https://user-images.githubusercontent.com/60171460/215863587-4ee3772f-78ca-4320-ba45-50d281baec33.png)

## Run project

Open the project with the desired IDE, then run the following command.

```bash
mvn clean verify
```

## Open allure report

To open allure report run the following command

```bash
allure serve target/allure-results
```

![Animation 5 (1)](https://user-images.githubusercontent.com/60171460/215867864-3ec22fc7-46e5-4aca-8112-03ffcc8f6867.gif)
