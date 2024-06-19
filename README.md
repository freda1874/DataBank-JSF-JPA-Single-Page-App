# JSF-JPA-EJB-BootStrap Single Page App

## Overview
This project is part of the **Enterprise Application Programming** course and demonstrates the integration of JavaServer Faces (JSF) with Enterprise JavaBeans (EJB) and Java Persistence API (JPA), styled using the Bootstrap CSS framework.
![image](https://github.com/freda1874/DataBank-JSF-JPA-Single-Page-App/assets/85437054/5090fa5d-f099-44fa-a592-42fe46aae5cb)

## Features
- **JSF Managed Bean**: Utilizes `@ViewScoped` managed bean.
- **JPA Model**: Implements JPA model classes with appropriate mappings and annotations.
- **Validation**: Adds validation to JSF views.
- **Bootstrap**: Styles the Student Directory application as a Single Page Application (SPA).
![image](https://github.com/freda1874/DataBank-JSF-JPA-Single-Page-App/assets/85437054/e3b24520-6392-41c1-a3d7-8f16351ddac4)

![image](https://github.com/freda1874/DataBank-JSF-JPA-Single-Page-App/assets/85437054/c134557f-3519-44d1-8f90-3d7158bb291b)

## Functionality
### CRUD Operations
- **Add New Student**: Clicking “Add New Student” shows the form on the same page. Submitting the form adds the student to the table and hides the form.
- **Edit Student**: Clicking “Edit” enables the fields for editing. Validation ensures proper format.
- **Delete Student**: Clicking “Delete” triggers a confirmation pop-up. Confirming removes the student from the database and UI.

### Error Handling
- Displays user-friendly error messages for validation errors and concurrency conflicts.
![image](https://github.com/freda1874/DataBank-JSF-JPA-Single-Page-App/assets/85437054/ff6fa00e-5fed-4acc-b524-1a56f8304e68)
![image](https://github.com/freda1874/DataBank-JSF-JPA-Single-Page-App/assets/85437054/31582a52-e72c-4483-8efd-824ad00d2c85)

### Audit Columns
- Tracks record creation and last update timestamps.

## Technologies
- **JSF**: Manages views and interactions.
- **EJB**: Provides business logic and transaction management.
- **JPA**: Handles database operations.
- **Bootstrap**: Ensures responsive and modern UI design.

## Configuration
### Persistence
- Configured using `@PersistenceContext` in the DAO implementation.
- JPA listeners automatically populate audit fields.

### JSF Navigation
- Uses `faces-config.xml` for navigation rules, managing view transitions based on action outcomes.

### Example Code
```xml
<h:commandButton action="#{studentController.someOutcome()}" />
```
- Toggles UI elements based on the `rendered` attribute, controlled by the managed bean.

## Installation
1. **Clone the Repository**
   ```sh
   git clone  https://github.com/freda1874/DataBank-JSF-JPA-Single-Page-App.git
   ```
2. **Open in Eclipse**
   - Import the project as an existing Maven project.
3. **Configure Database**
   - Ensure the database settings in `persistence.xml` are correct.
4. **Deploy to Server**
   - Deploy the application on a compatible EE server (e.g., Payara).

## Running the Application
- Access the application in your web browser.
- Use the provided UI to manage student records seamlessly.

## Contributing
- Fork the repository.
- Create a feature branch.
- Submit a pull request with detailed description.
 
