# Build Instructions for News Source Bias Detector

This is a Java Swing desktop application. Follow these steps to build and run it on your local machine.

## Prerequisites

You need to have the following installed on your system:

1. **Java Development Kit (JDK) 11 or higher**
   - Download from: https://adoptium.net/ or https://www.oracle.com/java/technologies/downloads/
   - Verify installation: `java -version`

2. **Apache Maven 3.6 or higher** (recommended)
   - Download from: https://maven.apache.org/download.cgi
   - Verify installation: `mvn -version`

## Option 1: Build and Run with Maven (Recommended)

### Compile the project:
```bash
mvn clean compile
```

### Run the application:
```bash
mvn exec:java
```

### Create an executable JAR file:
```bash
mvn clean package
java -jar target/news-source-bias-detector-1.0.0.jar
```

## Option 2: Build with javac (Manual Compilation)

If you don't have Maven installed, you can compile manually:

### Step 1: Create the output directory
```bash
mkdir -p out
```

### Step 2: Compile all Java files
```bash
javac -d out src/main/java/com/newsbiasdetector/*.java
```

### Step 3: Run the application
```bash
java -cp out com.newsbiasdetector.NewsSourceBiasDetectorApp
```

## Project Structure

```
news-source-bias-detector/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── newsbiasdetector/
│                   ├── NewsSourceBiasDetectorApp.java (Main GUI)
│                   ├── BiasDetector.java (Analysis Logic)
│                   └── BiasAnalysisResult.java (Result Data)
├── pom.xml (Maven configuration)
└── README.md
```

## Usage

1. Launch the application using one of the methods above
2. The GUI window will open with two text areas
3. Paste or type a news article in the top text area
4. Click the "Analyze" button to detect bias
5. View results in the bottom text area showing:
   - Total word count
   - Positive/Negative/Opinion word counts
   - Bias classification (Neutral, Slightly Biased, or Strongly Biased)
6. Click "Clear" to reset and analyze another article

## Troubleshooting

### "mvn: command not found"
- Maven is not installed or not in your PATH
- Use Option 2 (manual compilation) or install Maven

### "javac: command not found"
- Java JDK is not installed or not in your PATH
- Install JDK and ensure it's added to your system PATH

### GUI doesn't appear
- Ensure you're running on a system with a graphical display
- On Linux, you may need to set DISPLAY environment variable
- The application requires a desktop environment to run

## Sample Article for Testing

Try this sample text to see the bias detector in action:

```
The new policy is absolutely terrible and will cause devastating harm to millions of people.
Critics claim this is the worst decision ever made. Supporters believe it might have some
benefits, but obviously the risks outweigh any potential gains. This controversial move
clearly demonstrates poor judgment.
```

Expected result: Strongly Biased (high count of negative and opinion words)
