package com.mycompany.milestonegui;


public class MilestoneCalculator {
    private int milestone1;          // Score for Milestone 1
    private int milestone2;          // Score for Milestone 2
    private int terminalAssessment; // Score for Terminal Assessment

    // Maximum points allowed for each milestone
    public static final int MAX_M1 = 25;
    public static final int MAX_M2 = 40;
    public static final int MAX_TA = 35;

    // Set Milestone 1 score with validation
    public void setMilestone1(int m1) {
        if (m1 < 0 || m1 > MAX_M1) {
            throw new IllegalArgumentException("Milestone 1 must be 0 to " + MAX_M1);
        }
        milestone1 = m1;
    }

    // Set Milestone 2 score with validation
    public void setMilestone2(int m2) {
        if (m2 < 0 || m2 > MAX_M2) {
            throw new IllegalArgumentException("Milestone 2 must be 0 to " + MAX_M2);
        }
        milestone2 = m2;
    }

    // Set Terminal Assessment score with validation
    public void setTerminalAssessment(int ta) {
        if (ta < 0 || ta > MAX_TA) {
            throw new IllegalArgumentException("Terminal Assessment must be 0 to " + MAX_TA);
        }
        terminalAssessment = ta;
    }

    // Calculate total points earned
    public int calculateTotal() {
        return milestone1 + milestone2 + terminalAssessment;
    }

    /**
     * Calculate GPA grade based on total points.
     * Returns integer GPA: 1 (highest) to 5 (fail).
     */
    public int calculateGPA() {
        int total = calculateTotal();
        if (total >= 90) return 1;
        else if (total >= 80) return 2;
        else if (total >= 70) return 3;
        else if (total >= 60) return 4;
        else return 5; // Fail
    }
}
