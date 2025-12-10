# News Source Bias Detector

A simple Java Swing application that detects bias in news articles using keyword matching.

## Features

- Simple Swing-based GUI with text areas and buttons
- Bias detection using predefined keyword lists
- Classification into Neutral, Slightly Biased, or Strongly Biased
- Offline operation with no external dependencies


## How to Use

1. Launch the application
2. Paste or type a news article into the top text area
3. Click "Analyze" to see the bias analysis
4. Click "Clear" to reset both text areas

## Bias Detection Logic

The application analyzes text based on three categories:
- **Positive words**: excellent, amazing, wonderful, etc.
- **Negative words**: terrible, awful, horrible, etc.
- **Opinion words**: believe, think, seems, etc.

The classification is determined by:
- The percentage of biased words in the article
- The difference between positive and negative word counts
