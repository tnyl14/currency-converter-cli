# Currency Converter CLI
Hi. 
A simple command-line currency converter using the [Frankfurter API](https://www.frankfurter.app/).

## Features
- Convert amounts between any supported currencies
- Live exchange rates from the Frankfurter API
- Simple CLI interface for testing and self-learning

## Requirements
- Java 11 or higher
- Maven (if using Maven for dependency management)
- Internet connection (to fetch live exchange rates)

## How to Run
From the project root, use the following and follow the prompts:

```bash
mvn compile exec:java -Dexec.mainClass="org.example.Main"

