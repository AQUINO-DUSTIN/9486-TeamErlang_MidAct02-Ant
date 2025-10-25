# LeetCode Pair Programming Archive

This repository contains a collection of Java solutions managed by a robust **Apache Ant** build script, which automates the entire development, testing, and packaging process.

---

## Core Capabilities

The centralized `build.xml` file is configured to handle all project workflow stages:

* **Cleanup & Setup:** Deleting old artifacts (`clean`) and creating output directories.
* **Flexible Compilation:** Compiling the entire codebase (`compile`) or a single, specific file (`compile-file`).
* **Execution & Testing:** Running all integrated test suites via the `MasterTestRunner` (`execute-main`).
* **Documentation:** Generating Javadoc HTML documentation (`javadoc`).
* **Packaging:** Creating two distinct JAR files in `dist/`: one for **compiled classes** and one for **documentation**.

---

## Getting Started

1.  Ensure **Apache Ant** is installed and configured in your system environment path.
2.  Run the primary target to execute the full process:

    ```bash
    ant build
    ```

### Key Targets

| Target | Description |
| :--- | :--- |
| `build` | Runs the full sequence: **compile**, **javadoc**, and **package**. |
| `execute-main` | Executes the `MasterTestRunner` to run all solution test cases. |
| `execute-single` | Runs a specific class: `ant execute-single -Dclass=MyPackage.MySolution` |

---

## Project Structure (Managed by Ant)
