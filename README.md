# Student Management Application

## Description
The Student Management Application is a web-based system built using Spring Boot and PostgreSQL to facilitate the management of student information. It allows users to perform CRUD operations (Create, Read, Update, Delete) on student records stored in a PostgreSQL database. The application provides an intuitive user interface for adding, updating, and deleting student records, as well as visualizing student data.

## Features
- **CRUD Operations:** Add, update, delete, and view student records.
- **Interactive Interface:** User-friendly interface for easy interaction with student data.
- **Data Visualization:** Visual representation of student data using HTML elements.
- **Database Integration:** Utilizes PostgreSQL for data storage and retrieval.

## Setup Instructions
1. Clone the repository to your local machine.
2. Install PostgreSQL and create a database named "student_management".
3. Update the `application.properties` file with your PostgreSQL database credentials.
5. Run the application: `student_tracker_app/src/main/java/com/student_tracker/student_tracker_app/StudentTrackerAppApplication.java`.
6. Access the application using `localhost:8080/index.html`.
7. Can also access the deployed application at `https://samrath-student-tracker.onrender.com`.

## Usage
1. **Adding a New Student:**
   - Click on the "Add Student" button.
   - Enter the student's details in the provided form.
   - Click "Submit" to add the student to the database.

2. **Updating Student Information:**
   - Click on the "Update" button next to the student record you wish to update.
   - Modify the student's details in the form.
   - Click "Update" to save the changes.

3. **Deleting a Student:**
   - Click on the "Delete" button next to the student record you want to remove.

4. **Viewing Student Data:**
   - All student records are displayed on the main page, including their names(in their hair colour), weights, heights,and GPAs.
