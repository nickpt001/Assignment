# Task: Automating User Tasks Completion Percentage for FanCode City Users

## Scenario Description:
All the users of City `FanCode` should have more than half of their todos task completed.

Given User has the todo tasks
And User belongs to the city FanCode
Then User Completed task percentage should be greater than 50%

## Solution Overview:
This project aims to automate the verification of completed task percentage for users belonging to the FanCode city using API automation with Java and TestNG.

## Resources (APIs):
The project utilizes the following APIs:
- http://jsonplaceholder.typicode.com/todos
- http://jsonplaceholder.typicode.com/users

## Steps for Setting Up and Running the Project:

### Prerequisites:
- Ensure you have Java JDK installed on your system.
- Install TestNG framework for running TestNG tests.

### Project Setup:
1. Clone the repository:
git clone <repository_url>
2. Navigate to the project directory:
cd <project_directory>

### Running the Project:
1. Open the project in your preferred Java IDE.
2. Ensure all dependencies are resolved.
3. Run the `UserTests` class as a TestNG test.

## Project Structure:
- `UserTests.java`: Contains TestNG tests for verifying user task completion percentage.
- `README.txt`: Provides project overview, setup instructions, and usage guidelines.
- Other supporting files and directories.

## Notes:
- The `UserTests` class contains the automation code written in Java with TestNG.
- FanCode City users are identified based on latitude (-40 to 5) and longitude (5 to 100) criteria.
