# MobileAutomationDemo

## Project Description

**AutomationSwagLabs** is an automation testing project that uses the **Behavior-Driven Development (BDD)** methodology to verify the login and add products functionalities of the **SwagLabs** mobile application. The project is built with **Cucumber** and uses **Gherkin** to write tests in a human-readable format. The tests are implemented in **Java**.

The goal of this project is to ensure that users can log in successfully to the application using valid credentials and handle errors for incorrect credentials. Additionally, it verifies that users can select products from the catalog and add them to the shopping cart. The tests ensure that the selected products are correctly added to the cart, and that the cart reflects the correct number of items, allowing users to review or proceed with the checkout process.

## Technologies Used

- **Java**: The primary programming language for the tests.
- **Cucumber**: BDD framework to run Gherkin-based tests.
- **Gherkin**: A human-readable language used to write test scenarios.
- **TestNG**: Framework used for running and managing test cases.
- **Appium**: Mobile automation framework used to interact with Android and iOS applications.
- **Maven**: Build tool used to manage project dependencies.
- **Allure**: Reporting framework used to generate detailed test execution reports.

## Page Object Model (POM)
This project follows the Page Object Model (POM) design pattern to improve the maintainability and scalability of the test automation code. In POM, each screen or page of the mobile application is represented by a separate Java class. These classes contain methods that interact with the elements on the respective screen and perform the required actions, such as entering text, clicking buttons, or verifying the presence of certain elements.

The advantage of using POM is that it separates the test logic from the UI elements, making the code easier to maintain and reducing duplication. Each page class is responsible for a specific screen of the application, and tests can interact with these page objects instead of directly dealing with low-level interactions.

## Requirements

Before running the tests, ensure you have the following installed on your machine:

- **Java 11**: Required to run the test scripts and manage dependencies.
- **Maven**: Build tool to manage project dependencies and execute tests.
- **IDE (IntelliJ IDEA)**:  Integrated Development Environment for writing and running tests.
- **AndroidDriver**: if testing on a physical Android device is used for interactions.
- **Git**: (if you want to clone the repository) Version control system to download and manage the project code.

## Installation

1. **Clone the Repository**

   If you haven't cloned the repository yet, you can do so with the following command:

   git clone https://github.com/lbarmas/MobileAutomationDemo.git
   
