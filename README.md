# StudentRecordAnalyzer

## Project Overview

The **StudentRecordAnalyzer** is a Java-based program designed to calculate and analyze employee payroll records. It allows users to input employee details such as name, hours worked, and hourly rate, then calculates the gross salary, state tax, federal tax, and net salary. The program supports multiple output formats: displaying results on the screen, saving them to a file, or both.

## Features

- **Input Employee Data**: Capture employee details including first name, middle initial, last name, ID number, hours worked, and hourly rate.
- **Salary Calculation**: 
  - Calculates gross salary based on hours worked (including overtime if applicable).
  - Calculates state and federal taxes at fixed rates (7% for state tax, 15% for federal tax).
  - Computes net salary by subtracting taxes from the gross salary.
- **Output Options**: 
  - Display results on the screen.
  - Save results to a `.txt` file.
  - Display and save results simultaneously.
- **Input Validation**: Ensures valid input for hours worked and hourly rate.

## Technologies Used

- **Java**: Main programming language used to develop the application.
- **Scanner**: For user input.
- **PrintWriter**: To write results to a file.

## How to Run

1. Clone or download this repository to your local machine.
2. Open a terminal or command prompt.
3. Navigate to the project directory.
4. Compile and run the program:
   ```bash
   javac StudentRecordAnalyzer.java
   java StudentRecordAnalyzer
5. Follow the on-screen prompts to input employee details and choose the desired output format.
Program Flow

1. Input Collection
The program collects the following information for each employee:

First Name: Employee's first name.
Middle Initial: Employee's middle initial.
Last Name: Employee's last name.
ID Number: Employee's unique ID.
Hours Worked: Total hours worked by the employee.
Rate Per Hour: The hourly wage.

2. Salary Calculations
Gross Salary: Calculated by multiplying hours worked by the hourly rate. Overtime (if hours > 40) is paid at 1.5x the regular rate.
State Tax: 7% of gross salary.
Federal Tax: 15% of gross salary.
Net Salary: Gross salary minus state and federal taxes.

4. Output
The user can choose how the results are displayed:

Option 1 (Screen): Outputs the results on the screen.
Option 2 (File): Saves the results to a .txt file.
Option 3 (Both): Displays the results on the screen and saves them to a file.

4. Example
Input:
Enter First Name           : John
Enter Middle Initial       : D
Enter Last Name            : Doe
Enter ID Number            : 12345
Enter Hours Worked         : 40
Enter Rate Per Hour        : 20

Output (Screen):
Last Name  First Name  MI  ID#        Rate Per Hour  Hours Worked  State Tax  Fed Tax  Gross   Net
Doe        John        D   12345      20.00           40.00         5.60       12.00    800.00  782.40
Total Gross = 800.00
Gross_Average = 800.00

Output (File)
Last Name  First Name  MI  ID#        Rate Per Hour  Hours Worked  State Tax  Fed Tax  Gross   Net
Doe        John        D   12345      20.00           40.00         5.60       12.00    800.00  782.40
Total Gross = 800.00
Gross_Average = 800.00
