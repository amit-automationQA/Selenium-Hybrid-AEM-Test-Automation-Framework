# 🚀 Selenium Hybrid AEM Test Automation Framework

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=selenium&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-FF4C2B?style=for-the-badge&logo=testing&logoColor=white)

> 💡 A powerful hybrid test automation framework tailored for Adobe Experience Manager (AEM) testing using Selenium + Java + TestNG + ExtentReports + Log4j.

---

## 🧩 Features

- ✅ **Hybrid Framework** using TestNG for flexibility and scalability.
- 🌐 **Cross-browser support**: Chrome, Firefox, Edge.
- 🔗 **Broken link checker** for Header & Footer.
- 🖼️ **Screenshots** for failed test cases in ExtentReports.
- 📁 **Auto folder generation** during execution.
- 📜 **Log4j integration** for detailed logging.
- 🔁 **Retry Analyzer** for flaky test recovery.
- ☁️ **Sauce Labs** integration for cloud-based testing.

---

<details>
<summary>📁 <strong>Project Structure</strong> (Click to expand)</summary>

```bash
├── .settings/            # IDE-specific settings
├── Driver/               # WebDriver executables
├── Logs/                 # Execution logs
├── Screenshots/          # Captured screenshots
├── TestData/             # Input data files
├── reports/              # ExtentReports output
├── src/                  # Test scripts & core framework
├── target/               # Compiled binaries
├── test-output/          # TestNG reports
├── pom.xml               # Maven configuration
└── testng.xml            # Test suite configuration
```

</details>

---

## ⚙️ Getting Started

### 🔧 Prerequisites

- JDK 8 or higher
- Maven 3.6+
- Chrome/Firefox/Edge browser
- Any IDE (Eclipse, IntelliJ IDEA)

### 🛠️ Installation

```bash
git clone https://github.com/amit-automationQA/Selenium-Hybrid-AEM-Test-Automation-Framework.git
cd Selenium-Hybrid-AEM-Test-Automation-Framework
mvn clean install
```

### 🚦 Run Tests

```bash
mvn test
```

> 📍 Configure browser and environment settings in `testng.xml` or appropriate config classes before execution.

---

## 📊 Reporting

- ExtentReports generated in `/reports` folder.
- Includes screenshots of failed test steps.
- Easily shareable HTML format.

---

## 📘 Logging

- Log4j-based logging.
- Logs stored in `/Logs` directory.
- Helpful for debugging and audit trails.

---

## 🌐 Cross-Browser & Cloud Testing

- Define desired browser in `testng.xml`.
- Run tests on Sauce Labs by setting credentials and URL in the config.

---

## 🤝 Contributing

Contributions are welcome! Please:

1. Fork the repo 🍴
2. Create a feature branch 💡
3. Submit a PR 🚀

---

## 📄 License

MIT License. Feel free to use and share.

---

> Made with ❤️ by [Amit](https://github.com/amit-automationQA)
