# wsd_problem_submission


**Project Overview**
This project aims to streamline the automation of both User Interface (UI) and Application Programming Interface (API) testing for our application. It leverages Selenium for UI automation and RestAssured for API testing, with Maven serving as the tool for test management and execution.


**Key Features**
**Automated UI Testing:**
 1. Validates that the search bar accurately retrieves product results.
 2. Ensures that cart functionality operates as intended.
**Maven Integration:**
1. Facilitates build and dependency management.
**Project Structure:**
- src/main/java: Contains the core application code.
- src/test/java: Houses the test cases.
- pom.xml: The configuration file for Maven.


  **Why Choose This Framework?**
**Versatility**
This framework provides a robust solution for end-to-end testing by supporting both UI and API automation. Utilizing Selenium for UI tests and RestAssured for API tests ensures comprehensive coverage of both the front-end and back-end components of the application.

**Scalability**
The integration of Maven enhances the framework's scalability. It efficiently manages builds and dependencies, allowing for the seamless addition of new tests as the project evolves.

**User-Friendly Design**
The framework is crafted with usability in mind, featuring a well-organized project structure and thorough documentation. This design enables new team members to quickly acclimate and contribute effectively to the project.

**Strong Community Support**
The tools employed—Selenium, RestAssured, JUnit, and Maven—are widely adopted and backed by robust community support. This ensures that any challenges or inquiries can be addressed promptly through extensive documentation and community resources.

**Continuous Integration Compatibility**
The framework is designed to work seamlessly with continuous integration tools such as Jenkins, enabling automated test execution and reporting. This capability is crucial for maintaining application quality by identifying issues early in the development lifecycle.

**Prerequisites**
- Java 11 or higher
- Maven 3.6.3 or higher



## Installation
1. Clone the repository:
    ```bash
    git clone git clone https://github.com/reza17-bit/wsd_problem_submission.git
    ```
2. Navigate to the project directory:
    ```bash
    cd Testwsd
    ```
3. Install dependencies:
    ```bash
    mvn install
    ```

## Running Tests
To run the tests, use the following command:
```bash
mvn test
