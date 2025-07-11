package day79_11_07_2025;

/*
You are developing a Credit Risk Assessment System for a financial institution. 
The system evaluates customer creditworthiness based on income, debt, and missed 
payments. Your task is to design and implement the program using Object-Oriented 
Programming (OOP) principles in Java.

The system should:
------------------
 - Accept multiple customer profiles.
 - Calculate a credit score for each customer using a weighted formula.
 - Classify each customer as Low Risk, Medium Risk, or High Risk.
 - Output a summary report for each customer.

Specifications:
---------------
 - Scoring Formula (Fixed weights):
 - Income Score = min(1, income / 100000)
 - Debt Score = 1 - min(1, debt / 50000)
 - Missed Payments Score = 1 - min(1, missedPayments / 10)
 - Final Score = (0.4 × Income Score) + (0.4 × Debt Score) + (0.2 × Missed Payment Score) × 100

Risk Level Classification:
--------------------------
 - Score ≥ 80 → Low Risk
 - 50 ≤ Score < 80 → Medium Risk
 - Score < 50 → High Risk

Tasks to Complete
-----------------
- Create a POJO class Customer
    - Fields: name, income, debt, missedPayments
    - Include constructors, getters, and setters.

- Create a POJO class CreditReport
    - Fields: Customer object, calculatedScore, riskLevel
    - Include constructors and toString() method.

 - Define an interface RiskAnalyzer
    - Method: CreditReport analyzeRisk(Customer customer);

 - Implement a class CreditRiskAnalyzerImpl that implements the interface.
    - Calculate the score using the provided formula.
    - Determine the risk level.
    - Return a CreditReport object.

- Write the Main class to:
    - Create at least 3 sample Customer objects.
    - Use the CreditRiskAnalyzerImpl to generate reports.
    - Print the final report for each customer.


Sample Input:
-------------
3
David
100000
0
0
Eva
10000
10000
10
Frank
80000
10000
2

Sample Output:
--------------
Customer: David, Score: 100.0, Risk Level: Low                                                                                                        
Customer: Eva, Score: 36.0, Risk Level: High                                                                                                          
Customer: Frank, Score: 80.0, Risk Level: Low 

*/


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Customer {
    // TODO: Define private fields for name, income, debt, missedPayments
    // TODO: Add constructor, getters, setters
    private String name;
    private double income,debt;
    private int missedPayments;
    Customer(String name,double income,double debt,int missedPayments){
        this.name=name;
        this.income=income;
        this.debt=debt;
        this.missedPayments=missedPayments;
    }
    public String getName(){
        return name;
    }
    public double getIncome(){
        return income;
    }
    public double getDebt(){
        return debt;
    }
    public int getMissedPayments(){
        return missedPayments;
    }
}

class CreditReport {
    // TODO: Define Customer customer, double score, String riskLevel
    // TODO: Constructor and toString() method
    private Customer customer;
    private double score;
    private String riskLevel;
    CreditReport(Customer customer,double score,String riskLevel){
        this.customer=customer;
        this.score=score;
        this.riskLevel=riskLevel;
    }
    public String toString(){
        // System.out.println(String.format("%.1f",score));
        return "Customer: "+customer.getName()+", Score: "+String.format("%.1f",score)+", Risk Level: "+riskLevel;
    }
}

interface RiskAnalyzer {
    CreditReport analyzeRisk(Customer customer);
}

class CreditRiskAnalyzerImpl implements RiskAnalyzer {

    @Override
    public CreditReport analyzeRisk(Customer customer) {
        // TODO: Implement score calculation and risk classification
        double income=customer.getIncome(),debt=customer.getDebt();
        int missedPayments=customer.getMissedPayments();
        double incomeScore=Math.min(1,(double) income / 100000);
        // System.out.println(incomeScore);
        double debtScore = 1 - Math.min(1,(double) debt / 50000);
        // System.out.println(debtScore);
        // System.out.println(missedPayments);
        double missedPaymentsScore = 1 - Math.min(1,(double) missedPayments / 10);
        // System.out.println(missedPaymentsScore);
        double finalScore = ((0.4 * incomeScore) + (0.4 * debtScore) + (0.2 * missedPaymentsScore)) * 100;
        // System.out.println(finalScore);
        String riskLevel="";
        if(finalScore>=80){
            riskLevel="Low";
        }
        else if(finalScore>=50){
            riskLevel="Medium";
        }
        else{
            riskLevel="High";
        }
        return new CreditReport(customer,finalScore,riskLevel);
    }
}


public class JavaDesign7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            double income = Double.parseDouble(sc.nextLine());
            double debt = Double.parseDouble(sc.nextLine());
            int missedPayments = Integer.parseInt(sc.nextLine());

            customers.add(new Customer(name, income, debt, missedPayments));
        }
        sc.close();
        RiskAnalyzer analyzer = new CreditRiskAnalyzerImpl();

        for (Customer customer : customers) {
            CreditReport report = analyzer.analyzeRisk(customer);
            System.out.println(report);
        }
    }
}
