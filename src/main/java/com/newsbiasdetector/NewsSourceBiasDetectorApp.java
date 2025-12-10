package com.newsbiasdetector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewsSourceBiasDetectorApp extends JFrame {

    JTextArea inputTextArea;
    JTextArea resultsTextArea;
    JButton analyzeButton;
    JButton clearButton;
    BiasDetector biasDetector;

    public NewsSourceBiasDetectorApp() {
        biasDetector = new BiasDetector();

        setTitle("News Source Bias Detector");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("News Article Bias Detector", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2, 1, 10, 10));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        JLabel inputLabel = new JLabel("Paste or type your news article here:");
        inputTextArea = new JTextArea(10, 60);
        inputTextArea.setLineWrap(true);
        inputTextArea.setWrapStyleWord(true);
        inputTextArea.setFont(new Font("Arial", Font.PLAIN, 12));
        JScrollPane inputScrollPane = new JScrollPane(inputTextArea);
        inputPanel.add(inputLabel, BorderLayout.NORTH);
        inputPanel.add(inputScrollPane, BorderLayout.CENTER);

        JPanel resultsPanel = new JPanel();
        resultsPanel.setLayout(new BorderLayout());
        JLabel resultsLabel = new JLabel("Analysis Results:");
        resultsTextArea = new JTextArea(10, 60);
        resultsTextArea.setLineWrap(true);
        resultsTextArea.setWrapStyleWord(true);
        resultsTextArea.setEditable(false);
        resultsTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        resultsTextArea.setBackground(new Color(240, 240, 240));
        JScrollPane resultsScrollPane = new JScrollPane(resultsTextArea);
        resultsPanel.add(resultsLabel, BorderLayout.NORTH);
        resultsPanel.add(resultsScrollPane, BorderLayout.CENTER);

        centerPanel.add(inputPanel);
        centerPanel.add(resultsPanel);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        analyzeButton = new JButton("Analyze");
        analyzeButton.setFont(new Font("Arial", Font.BOLD, 14));
        analyzeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String articleText = inputTextArea.getText().trim();
                if (articleText.isEmpty()) {
                    resultsTextArea.setText("Please enter some text to analyze.");
                    return;
                }
                BiasAnalysisResult result = biasDetector.analyzeText(articleText);
                resultsTextArea.setText(result.toString());
            }
        });

        clearButton = new JButton("Clear");
        clearButton.setFont(new Font("Arial", Font.BOLD, 14));
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputTextArea.setText("");
                resultsTextArea.setText("");
            }
        });

        buttonPanel.add(analyzeButton);
        buttonPanel.add(clearButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
                new NewsSourceBiasDetectorApp();
    }
}
