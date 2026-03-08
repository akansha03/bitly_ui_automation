# Bitly Short URL UI Automation

UI automation framework for [Bitly](https://bitly.com/) using **Selenium WebDriver** and **TestNG**. Automates login, navigation, and short URL creation flows.

---

## Tech Stack

| Technology | Version |
|------------|---------|
| Java       | 21      |
| Selenium   | 4.35.0  |
| TestNG     | 7.10.2  |
| Maven      | -       |
| Allure     | 2.25.0  |

---

## Project Structure

```
bitly_ui_automation/
├── src/
│   ├── main/java/com/bitly/
│   │   ├── base/BaseTest.java          # Base test class with setup/teardown
│   │   ├── config/ConfigReader.java    # Configuration reader
│   │   ├── driver/DriverFactory.java    # ThreadLocal WebDriver management
│   │   ├── pages/
│   │   │   ├── LoginPage.java          # Login page object
│   │   │   └── HomePage.java           # Home page object (short URL creation)
│   │   └── utils/WaitUtils.java        # Wait utilities
│   └── test/java/com/bitly/
│       └── ShortenLongURLTests.java    # Test cases
├── testng.xml                           # TestNG suite configuration
├── pom.xml                              # Maven dependencies
└── README.md
```

---

## Prerequisites

- **Java 21** or higher
- **Maven** 3.6+
- **Chrome** browser (ChromeDriver is managed by Selenium 4+)
- Bitly account credentials for login tests

---

## Setup

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd bitly_ui_automation
   ```

2. **Install dependencies**
   ```bash
   mvn clean install
   ```

3. **Configure test credentials**  
   Edit the `@DataProvider` in `ShortenLongURLTests.java` with your Bitly credentials:
   ```java
   return new Object[][] {{"your-email@example.com", "your-password", "expected-username"}};
   ```

---

## Running Tests

**Run all tests:**

```bash
mvn clean test
```

**Run with specific suite:**

```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

**Generate Allure report:**

```bash
mvn clean test
mvn allure:serve
```

---

## Test Scenarios

| Test | Description |
|------|-------------|
| `testLoginUser` | Logs in via side menu, verifies username on home page, creates a short URL via quick-create, and asserts the URL contains `bit.ly` |

**Flow covered:**

1. Open Bitly homepage
2. Close cookie banner and click login
3. Enter email and password, submit
4. Wait for home page and assert displayed username
5. Enter destination URL (e.g. Stack Overflow link)
6. Enable QR code checkbox
7. Click "Create Bitly" and verify short URL is generated

---

## Architecture

- **Page Object Model (POM)** – `LoginPage` and `HomePage` encapsulate locators and actions.
- **DriverFactory** – Uses `ThreadLocal<WebDriver>` for parallel-safe driver management.
- **BaseTest** – Shared `@BeforeMethod` / `@AfterMethod` for driver initialization and cleanup; exposes `loginPage` and `homePage` to child test classes.
- **Explicit waits** – `WebDriverWait` used for dynamic elements (e.g. post-login home page).

---

## Configuration

| Property | Default | Description |
|----------|---------|-------------|
| `headless` | false | Run browser in headless mode |
| `browser` | CHROME | Browser type |
| `baseUrl` | https://www.google.com | Base URL (tests use `https://bitly.com/` directly) |

---

## License

MIT
