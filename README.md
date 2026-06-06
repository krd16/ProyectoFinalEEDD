# ProyectoFinalEEDD

Desktop inventory management application built with JavaFX and PostgreSQL.

## Features

- User authentication
- Add and update product stock
- Remove product stock
- Check current stock by product name

## Tech Stack

| Layer      | Technology          |
|------------|---------------------|
| UI         | JavaFX 21           |
| Language   | Java 17             |
| Database   | PostgreSQL          |
| Build      | Maven               |
| Testing    | JUnit 5 + Mockito   |
| CI         | Jenkins             |
| Analysis   | SonarQube           |

## Project Structure

```
src/
├── main/java/org/example/proyectofinaleedd/
│   ├── Navigation/       # Screen navigation logic
│   ├── Screens/          # JavaFX UI screens
│   ├── Services/         # Business logic
│   └── Repositories/     # Database access
└── test/java/org/example/proyectofinaleedd/
    └── Services/         # Unit tests
```

## Maven Profiles

| Profile | Description          | Active by default |
|---------|----------------------|-------------------|
| `dev`   | Development database | ✅ Yes            |
| `prod`  | Production database  | ❌ No             |

Run with a specific profile:
```bash
mvn clean package -P prod
```

## How to Run

```bash
# Clone the repository
git clone https://github.com/krd16/ProyectoFinalEEDD.git
cd ProyectoFinalEEDD

# Run the application
mvn clean javafx:run
```

## How to Test

```bash
mvn test
```

Test reports are generated at `target/surefire-reports/`.

## CI Pipeline

The Jenkins pipeline runs automatically on every push and executes the following stages:

| Stage     | Description                              |
|-----------|------------------------------------------|
| Checkout  | Clones the repository from GitHub        |
| Build     | Compiles the source code                 |
| Test      | Runs all JUnit tests                     |
| SonarQube | Analyses code quality and coverage       |
| Package   | Generates the `.jar` file                |
| Publish   | Archives the artifact in Jenkins         |

### Latest Artifact

[⬇ Download latest build](http://3.221.22.166:8080/job/StockPipeline/lastSuccessfulBuild/artifact/target/ProyectoFinalEEDD-1.0-SNAPSHOT.jar)

### Latest Test Report

[📄 View test report](http://3.221.22.166:8080/job/StockPipeline/lastSuccessfulBuild/testReport/)

### SonarQube Report

[📊 View code analysis](http://3.221.22.166:9000/dashboard?id=ProyectoFinalEEDD)

## Branch Model

| Branch   | Purpose                                        |
|----------|------------------------------------------------|
| `master` | Stable code — protected                        |
| `dev`    | Development branch — merged into master via PR |

## Author

[krd16](https://github.com/krd16)
