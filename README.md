# Employee-Performance-Bell-Curve-Analysis
1-The Employee Performance Bell Curve Analysis project is a Spring Boot application designed to analyze employee performance data based on the bell curve model.
2-It calculates the actual percentage distribution of employees across predefined performance categories, computes deviations from standard percentages, and suggests revisions for the performance distribution.

#Key Features
1.Calculate actual percentages of employees in predefined performance categories.

2.Compute deviations between actual and standard percentages.

3.Provide suggestions for revising employee distributions to align with the bell curve.


#Project Structure
Main Application
  import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeePerformanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeePerformanceApplication.class, args);
    }
}

#Controller

BellCurveController handles the HTTP requests and interacts with the service layer.

#Service

BellCurveService contains the business logic for analyzing the bell curve data.

#Repository

EmployeeRepository serves as an in-memory data source for employee records.

#Models

Employee: Represents an employee with attributes like ID, name, rating, and category.

Category: Represents a performance category with attributes like name and standard percentage.

#Prerequisites

1.Java Development Kit (JDK): Version 17 or higher (Java 21 recommended).

2.Spring Boot: Embedded in the project.

3.IDE: IntelliJ  Eclipse, or Spring Tool Suite (STS).

4.Maven: For dependency management.

#Installation Steps
1.Clone the Repository:
  git clone <repository-url>
  cd employee-performance
2.Build the Project:
  mvn clean install
3.Run the Application:
  mvn spring-boot:run
4.Access the Application:
  http://localhost:8080/bellcurve

#API Details

Endpoint: /bellcurve

Method: GET

Description: Returns the actual percentages, deviations, and suggested revisions for the employee performance categories.

Sample Output:Actual Percentages: {A=20.0, B=10.0, C=30.0, D=30.0, E=10.0}
Deviation: {A=10.0, B=-10.0, C=-10.0, D=10.0, E=0.0}
Suggested Revisions: [Employee(id=5001, name=Harry, rating=1, category=A), ...]

Technologies Used

1.Java 21

2.Spring Boot

3.Maven

4.Lombok

