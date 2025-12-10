package com.newsbiasdetector;

public class BiasAnalysisResult {
    private int totalWords;
    private int positiveCount;
    private int negativeCount;
    private int opinionCount;
    private String classification;

    public BiasAnalysisResult(int totalWords, int positiveCount, int negativeCount,
                             int opinionCount, String classification) {
        this.totalWords = totalWords;
        this.positiveCount = positiveCount;
        this.negativeCount = negativeCount;
        this.opinionCount = opinionCount;
        this.classification = classification;
    }

    @Override
    public String toString() {
        return String.format(
            "=== BIAS ANALYSIS RESULTS ===\n\n" +
            "Total Words: %d\n" +
            "Positive Words: %d\n" +
            "Negative Words: %d\n" +
            "Opinion Words: %d\n\n" +
            "Classification: %s\n" +
            "===========================",
            totalWords, positiveCount, negativeCount, opinionCount, classification
        );
    }
}
