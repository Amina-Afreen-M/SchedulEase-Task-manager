# SchedulEase - Smart Task Manager

SchedulEase is a smart task management system designed to help users prioritize, schedule, and manage tasks efficiently. With features like auto-scheduling, prioritization, and daily summaries, SchedulEase optimizes productivity by ensuring that the most critical tasks are completed first.

## Features
- **Smart Task Prioritization**: Automatically prioritize tasks based on deadlines, importance, and user-defined parameters.
- **Auto-Scheduling**: Assigns tasks to the most appropriate time slots using a smart algorithm.
- **Daily Summary Notifications**: Get a daily summary of your scheduled tasks.
- **Goal Management**: Manage long-term goals like learning new skills, and break them into smaller tasks.
- **Customizable Task Categories**: Organize tasks into categories for better management.

## Installation

To get started with SchedulEase, follow the steps below:

### Prerequisites
- **JDK 8 or later**: Ensure Java Development Kit (JDK) is installed.
- **Apache Tomcat**: To run JSP files.
- **MySQL**: For database management (you can use MySQL Workbench for local setup).
- **Maven**: To manage dependencies.

### Steps to Install

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/schedulease.git
   ```

2. Navigate to the project directory:
   ```bash
   cd schedulease
   ```

3. Install the dependencies using Maven:
   ```bash
   mvn clean install
   ```

4. Setup MySQL database:
   - Open MySQL Workbench.
   - Create a new database called `todo`.
   - Run the SQL script provided in `/db/todo.sql` to set up the required tables.

5. Run the project on Apache Tomcat:
   - Deploy the project on your local Tomcat server.
   - Access the application at `http://localhost:8080/schedulease`.

## Usage

1. **Adding Tasks**:
   - Navigate to the "Add Task" page to create new tasks with deadlines, categories, and priorities.

2. **View Tasks**:
   - Access the task list to view all tasks, categorized by priority or deadlines.

3. **Daily Summary**:
   - SchedulEase will automatically generate a daily summary of tasks, helping you stay on track.

4. **Smart Auto-Scheduling**:
   - Enable auto-scheduling to let the system assign time slots for your tasks based on their priority.

## Configuration

- **Database Configuration**: Update the `db.properties` file with your MySQL credentials:
   ```properties
   db.url=jdbc:mysql://localhost:3036/schedulease
   db.user=root
   db.password=root
   ```

- **Toastr Notifications**: Customize your Toastr notifications (used for task updates, reminders) in `toastr.js`.

## Technologies Used
- **Java**: Backend logic and task management algorithms.
- **JSP**: Frontend for user interaction.
- **MySQL**: Database for storing tasks and schedules.
- **Maven**: Dependency management.
- **Toastr**: For notification popups.
  
## Contributing

Contributions are welcome! To contribute to SchedulEase:
1. Fork the repository.
2. Create a new feature branch (`git checkout -b feature-branch-name`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature-branch-name`).
5. Create a new Pull Request.

