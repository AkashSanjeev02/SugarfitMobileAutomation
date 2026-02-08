# SugarFit Automation Framework

This repository contains an **Android Test Automation Framework** built for the **SugarFit mobile application**, using modern testing tools and best practices.  
The framework supports **BDD (Cucumber)**, **TestNG**, **Appium**, and **Maven**, with reusable utilities and page-based architecture.

---

## 🧰 Tech Stack

- Java
- Appium
- TestNG
- Cucumber (BDD)
- Maven
- Rest Assured
- Extent / Spark Reports

---

## 📂 Project Structure

```
SugarFitAutomationFramework
│
├── pom.xml
├── testNgAndroid.xml
├── README.md
│
├── src
│   ├── main
│   │   └── java
│   │       ├── org.base
│   │       │   └── BaseClass.java
│   │       │
│   │       ├── pagefactory
│   │       │   ├── LoginScreen.java
│   │       │   ├── HomeScreen.java
│   │       │   ├── EnterOtpScreen.java
│   │       │   ├── SelectMealScreen.java
│   │       │   ├── SelectFoodScreen.java
│   │       │   ├── WhatYouLikeToLogScreen.java
│   │       │   └── MailDairyScreen.java
│   │       │
│   │       ├── stepdefinitions
│   │       │   ├── LoginSteps.java
│   │       │   ├── HomeSteps.java
│   │       │   └── Hooks.java
│   │       │
│   │       ├── Utility
│   │       │   ├── GenericUtility.java
│   │       │   ├── RetryAnalyzer.java
│   │       │   └── RestAssuredUtility.java
│   │       │
│   │       └── features
│   │           ├── Login.feature
│   │           └── SugarFitHome.feature
│   │
│   └── test
│       └── java
│           └── runner
│               └── TestRunnerAndroid.java
│
└── target
    ├── extent-report.html
    ├── cucumber.json
    └── cucumber-html-report
```

---

## 🧩 Framework Design

### 🔹 BaseClass
- Initializes Appium driver
- Handles desired capabilities
- Manages driver lifecycle

### 🔹 Page Factory (POM)
- Each screen of the app is modeled as a separate page class
- Improves readability, reusability, and maintenance

### 🔹 Step Definitions
- Maps Gherkin steps from `.feature` files to Java methods
- Keeps test logic clean and business-readable

### 🔹 Utilities
- GenericUtility – common reusable helper methods
- RetryAnalyzer – retries failed test cases automatically
- RestAssuredUtility – API-related helpers

### 🔹 Hooks
- Cucumber hooks for setup and teardown
- Screenshot capture on failure (if enabled)

---

## 🧪 Test Execution

### ▶ Run Using TestNG XML
```bash
mvn test -DsuiteXmlFile=testNgAndroid.xml
```

### ▶ Run Using Maven
```bash
mvn clean test
```

---

## 📊 Reports

After execution, reports are generated under the `target` directory:

- Extent Report  
  `target/extent-report.html`

- Cucumber HTML Report  
  `target/cucumber-html-report`

- Cucumber JSON Report  
  `target/cucumber.json`

---

## 🔁 Retry Mechanism

- Implemented using TestNG RetryAnalyzer
- Automatically retries failed test cases
- Retry count is configurable in `RetryAnalyzer.java`

---

## ⚙️ Prerequisites

- Java 8 or above
- Maven installed
- Appium Server running
- Android Emulator or real device connected
- Proper device capabilities configured

---

## 🚀 How to Use

1. Clone the repository
2. Update device/app capabilities if needed
3. Start Appium server
4. Run tests using Maven or TestNG
5. View execution reports in `target` folder

---

## 🧑‍💻 Author

**Akash S**  
Automation Test Engineer  

---

## 📌 Notes

- Follow Page Object Model for all new screens
- Add new scenarios in `.feature` files
- Map steps inside `stepdefinitions`
- Do not commit `target/` folder to Git

---

Happy Testing 🚀
