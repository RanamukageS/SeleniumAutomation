# Selenium Automation Project – OrangeHRM Live 🌐  

![Java](https://img.shields.io/badge/Language-Java-blue)
![Maven](https://img.shields.io/badge/Build-Maven-orange)
![Selenium](https://img.shields.io/badge/Framework-Selenium-green)
![ExtentReports](https://img.shields.io/badge/Reports-ExtentReports-purple)

## 📖 Overview  

This project is a **Selenium automation framework** built to test and validate functionalities of the orangehrmlive opensource website [url : https://opensource-demo.orangehrmlive.com/].  
It automates key test scenarios to ensure system reliability, improves testing efficiency, and integrates seamlessly with **CI/CD pipelines** for automated execution.  

---

## ✨ Features  

- 🧭 **End-to-End Test Automation** for OrangeHRM Live website  
- 📸 **Failed Screenshot Capture** – Automatically captures screenshots when a test fails  
- ♻️ **Retry Mechanism** – Re-runs failed tests for better reliability  
- 📊 **HTML Reports** – Integrated with **Extent Reports**  
- 🕒 **Scheduled Execution** – Runs automatically at midnight or can be triggered manually
- ⚙️ Manual & Separate Execution – Can be run manually as Smoke or Regression tests as needed
- 🧩 **Modular Design** – Easy to extend with new test cases or modules  

---

## 🧠 Tech Stack  

| Tool | Purpose |
|------|----------|
| **Java** | Programming language |
| **Selenium WebDriver** | UI automation |
| **Maven** | Build and dependency management |
| **TestNG** | Test execution and reporting |
| **Extent Reports** | Visual test reports |
| **IntelliJ IDEA** | Development environment |

---

## ⚙️ Project Structure 

### 🧭 Folder Overview  

| Folder | Description |
|--------|--------------|
| **baseTest/** | Contains setup, teardown, and common test utilities. |
| **pom/** | Implements Page Object Model (POM) design pattern for different app pages. |
| **utils/** | Helper utilities like config reader, retry logic, screenshots, etc. |
| **reports/** | Extent Report configuration and generated test reports. |
| **resources/** | Configuration files, logs, and test data. |
| **tests/** | Contains TestNG test classes organized by module. |
| **test-output/** | Contains automatically generated test report. |
| **dataProviderSet/** | All the relevant data providers included. |

---
## 🧠 Screenshots
Website : <img width="1440" height="831" alt="image" src="https://github.com/user-attachments/assets/dd2f26c2-8ae6-40df-a136-1f19b9edde13" />
Captured screenshots : <img width="1440" height="831" alt="image" src="https://github.com/user-attachments/assets/f58c32aa-3cf8-44a2-9e4b-b8484b5f589c" />
Successfull Test Run Via GitHubActions: <img width="1440" height="831" alt="image" src="https://github.com/user-attachments/assets/a1e88c9d-7000-4ce7-854a-0c6fa17df7e0" />
Test Report : <img width="1440" height="831" alt="image" src="https://github.com/user-attachments/assets/9e247fba-7c8b-49a1-a68b-236576e8e088" />








---
Would you like me to:  
✅ Add **badges** for CI/CD status (GitHub Actions) and test coverage?  


