package com.newsbiasdetector;

import java.util.Arrays;
import java.util.List;

public class BiasDetector {

    private List<String> positiveWords;
    private List<String> negativeWords;
    private List<String> opinionWords;

    public BiasDetector() {
        positiveWords = Arrays.asList(
                "excellent", "amazing", "wonderful", "fantastic", "great", "good", "best",
                "perfect", "brilliant", "outstanding", "superior", "exceptional", "remarkable",
                "admirable", "impressive", "favorable", "beneficial", "positive", "success",
                "victory", "triumph", "achievement", "progress", "improvement", "hero",
                "honorable", "trustworthy", "reliable", "honest", "effective", "efficient",
                "strong", "robust", "promising", "encouraging", "innovative", "groundbreaking",
                "leading", "top", "notable", "commendable", "inspiring", "thriving", "booming",
                "growing", "stabilizing", "strengthening"
        );

        negativeWords = Arrays.asList(
                "terrible", "awful", "horrible", "bad", "worst", "poor", "failed",
                "disaster", "catastrophe", "crisis", "problem", "issue", "danger",
                "threat", "risk", "harm", "damage", "corrupt", "dishonest", "untrustworthy",
                "scandal", "controversy", "outrage", "failure", "decline", "loss",
                "villain", "criminal", "dangerous", "evil","chaos", "chaotic", "gridlock", "gridlocked", "ordeal", "mess", "mismanaged", "incompetent", "incompetence", "botched", "blunder",
                "backlash", "uproar", "furious", "fury", "furor", "anger", "angry",
                "frustrated", "frustration", "collapsed", "collapse", "meltdown",
                "breakdown", "worsening", "escalating", "worsen", "escalate",
                "spiraling", "spiral", "unstable", "unstable", "volatile",
                "corruption", "cover up", "cover-up", "abuse", "abusive",
                "negligent", "negligence", "reckless", "recklessness", "recklessly",
                "shocking", "shameful", "disgraceful", "unacceptable", "appalling",
                "disturbing", "alarming", "severe", "severely", "dramatic", "drastic",
                "grim", "bleak", "dire", "devastating", "devastated", "ruined", "ruin",
                "catastrophic", "fatal", "deadly", "out of control", "in chaos"
        );

        opinionWords = Arrays.asList(
                "believe", "think", "feel", "seems", "appears", "probably", "possibly",
                "likely", "unlikely", "clearly", "obviously", "certainly", "definitely",
                "should", "must", "ought", "alleged", "reportedly", "supposedly",
                "claim", "argue", "suggest", "opinion", "view", "perspective",
                "undoubtedly", "questionable", "debatable", "controversial",
                "apparently", "evidently", "presumably", "roughly", "approximately",
                "maybe", "perhaps", "somewhat", "somehow", "sort of", "kind of",
                "in my view", "in my opinion", "many believe", "critics say",
                "experts say", "supporters argue", "opponents argue", "some claim",
                "it seems", "it appears", "often", "rarely", "frequently", "typically",
                "generally", "arguably", "allegedly",
                "very", "highly", "extremely", "deeply", "seriously", "strongly",
                "really", "so", "too", "totally", "utterly", "completely", "absolutely"
        );
    }

    public BiasAnalysisResult analyzeText(String text) {
        String cleanedText = text.toLowerCase().replaceAll("[^a-z\\s]", " ");
        String[] words = cleanedText.split("\\s+");

        int totalWords = words.length;
        int positiveCount = 0;
        int negativeCount = 0;
        int opinionCount = 0;

        for (String word : words) {
            if (word.trim().isEmpty()) {
                totalWords--;
                continue;
            }

            if (positiveWords.contains(word)) {
                positiveCount++;
            }
            if (negativeWords.contains(word)) {
                negativeCount++;
            }
            if (opinionWords.contains(word)) {
                opinionCount++;
            }
        }

        String classification = classifyBias(totalWords, positiveCount, negativeCount, opinionCount);

        return new BiasAnalysisResult(totalWords, positiveCount, negativeCount, opinionCount, classification);
    }

    private String classifyBias(int totalWords, int positiveCount, int negativeCount, int opinionCount) {
        if (totalWords == 0) {
            return "No text to analyze";
        }

        double biasedWordPercentage = ((double)(positiveCount + negativeCount + opinionCount) / totalWords) * 100;

        String direction = "";
        if (positiveCount > negativeCount) {
            direction = " - Positive Bias";
        } else if (negativeCount > positiveCount) {
            direction = " - Negative Bias";
        }

        int sentimentDifference = Math.abs(positiveCount - negativeCount);

        if (biasedWordPercentage < 5 && sentimentDifference < 3) {
            return "Neutral";
        } else if (biasedWordPercentage < 10 && sentimentDifference < 5) {
            return "Slightly Biased" + direction;
        } else {
            return "Strongly Biased" + direction;
        }
    }
}
