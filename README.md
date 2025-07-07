# Clean Architecture Example

### Enterprise Business Rules
1. Product price must be positive
2. CategoryId in a product must not be blank


This repository contains a project created for **practice and exploration purposes**, and represents **a personal interpretation** of how a software system can align with the principles of Clean Architecture.

**⚠️ Important:**  
The code organization, dependencies, and design decisions may differ from other implementations following Clean Architecture.

## Objectives

- Explore and exercise the fundamental concepts of Clean Architecture, such as:
    - Layered separation (Entities, Use Cases, Interfaces, Frameworks)
    - Dependency inversion
    - SOLID principles
- Understand how components interact in a modular and decoupled application flow.
- Experiment with strategies for code organization and responsibility assignment.

## What does this project do?

In a simplified way:
- Presents a layered structure inspired by Clean Architecture.
- Implements representative use cases.
- Integrates dependencies and input/output mechanisms in a decoupled manner.
- Serves as a reference for experimenting with improvements, refactors, and new ideas.

## Technologies Used

- Language: Kotlin
- Framework: Spring Boot
- Tools: Jackson

## Clean Architecture

Clean architecture presents four concentric circles that represent different areas in software.
There areas are called:
- **Entities**: Encapsulate enterprise-wide Critical Business Rules.
- **Use Cases**: Contains application-specific business rules.
- **Interface Adapters**: A set of adapters that convert data from the format most convenient for the use cases and entities, to the format most convenient for some external agency such as the database or the web.
- **Frameworks and Drivers**: Generally composed of frameworks and tools such as the database and the web framework

## Project Structure

The organization follows these main layers:

- **Domain**: Business entities and related enterprise business rules. This is **Entities** in clean architecture.
- **Application**: Application logic and Use Case contracts and implementations. This is **Use Cases** in clean architecture.
- **Presentation**: It is part of Infrastructure. Related to web controller. User Interaction.
- **Data**: It is part of Infrastructure. Related to persistence of data and query data.


Please note that this design is **one interpretation** and may differ from other examples or publications on the subject.
I'm not implementing the area **Interface Adapter** because for this case is not necessary. It would only add complexity. Feel free to implement.
For example **presentation.dto** could belong to this area.
**Interface Adapters** talks about controller. Don't make the mistake of thinking it's the same as a web driver. Web driver in spring needs to be marked with @Controller which is a Framework implementation.

## How to Use This Project

1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/your-repo.git
