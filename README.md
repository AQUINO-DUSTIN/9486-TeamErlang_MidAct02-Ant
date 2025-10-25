# LeetCode Pair Programming Archive

This repository contains a collection of Java solutions developed during pair programming sessions, managed entirely by a highly functional **Apache Ant** build script.

The `build.xml` automates the entire development workflow, ensuring clean builds, flexible execution, and organized documentation.

## Project Structure

```
LeetCodeSolutions/
├── build.xml           # The core Ant build file
├── src/                # All Java source code (.java files)
├── build/              # Compiled classes (.class files) (Ignored by Git)
├── dist/               # Final JAR files (Ignored by Git)
└── doc/                # Javadoc documentation (Ignored by Git)
```

## Ant Build Capabilities

The `build.xml` file is configured to execute all required tasks:

| Ant Target | Description |
| :--- | :--- |
| `clean` | Deletes the generated `build`, `dist`, and `doc` folders. |
| `compile-all` | Compiles **the entire codebase** from the `src` directory. |
| `compile-single` | Compiles **only a specified single `.java` file** (requires argument). |
| `execute-main` | Executes the designated main class of the project. |
| `execute-single` | Executes a **specified Java file** with a `main` method (requires argument). |
| `javadoc` | Generates HTML documentation from Javadoc comments and places it in the `doc` folder. |
| `jar-classes` | Creates a JAR file containing all **compiled classes** from `build/`. |
| `jar-docs` | Creates a separate JAR file containing all **documentation** from `doc/`. |
| `build` | The primary target; runs `clean`, `compile-all`, `javadoc`, `jar-classes`, and `jar-docs`. |

## Getting Started

1.  **Clone** the repository.

2.  Ensure you have **Apache Ant** installed and configured in your environment path.

3.  Execute the default build to compile and package everything:

    ```bash
    ant build
    ```
