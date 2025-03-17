# Employee Management System (Crew Compass)

## Overview
Crew Compass is a web-based Employee Management System designed to streamline attendance tracking, leave applications, and salary management. It provides an intuitive interface for employees and administrators to manage various HR-related tasks efficiently.

## Features
### For Employees
- **Attendance Tracking:** Employees can clock in and out, and view their attendance history.
- **Leave Management:** Employees can apply for leave, check approval status, and view leave history.
- **Profile Management:** Employees can update their personal details and upload profile pictures.

### For Administrators
- **Attendance Management:** View, edit, and manage employee attendance records.
- **Leave Approval:** Approve or reject leave applications.
- **Salary Management:** Manage and update employee salary details.
- **User Management:** Add, update, and remove employees from the system.

## Technologies Used
- **Backend:** Java, Spring Boot, Spring MVC
- **Frontend:** Thymeleaf, HTML, CSS, JavaScript
- **Database:** MySQL

## Installation
### Prerequisites
Ensure you have the following installed on your system:
- **Java Development Kit (JDK) 8 or later**
- **Apache Maven**
- **MySQL**
- **An IDE** (e.g., IntelliJ IDEA, Eclipse, or VS Code)

### Setup Instructions
1. **Clone the repository:**
   ```sh
   git clone https://github.com/your-username/employee-management-system.git
   cd employee-management-system
   ```
2. **Configure the Database:**
    - Create a MySQL database with the name `employee_db`.
    - Update the `application.properties` file with your database credentials:
      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
      spring.datasource.username=root
      spring.datasource.password=yourpassword
      spring.jpa.hibernate.ddl-auto=update
      ```
3. **Build and Run the Application:**
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
4. **Access the Application:**
    - Open your browser and navigate to `http://localhost:8080`

## Usage
### For Employees
- **Mark Attendance:** Navigate to the attendance page and clock in/out.
- **Apply for Leave:** Fill in leave details and submit.
- **Check Leave Status:** View the approval status of leave applications.

### For Administrators
- **View Attendance Records:** Monitor employee attendance data.
- **Approve/Reject Leave:** Process leave applications.
- **Manage Salaries:** Update and view salary records.

## Contributing
We welcome contributions! To contribute:
1. Fork the repository.
2. Create a new branch.
3. Make changes and commit them.
4. Push to your fork and submit a pull request.

## License
This project is licensed under the MIT License.

## Contact
For any queries or support, contact [royalihunma@gmail.com]().