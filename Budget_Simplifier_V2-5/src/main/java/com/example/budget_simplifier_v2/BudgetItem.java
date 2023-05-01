package com.example.budget_simplifier_v2;

public abstract class BudgetItem {
    public enum Period{NONE, HOURLY, DAILY, WEEKLY, MONTHLY, YEARLY};
    //Data members
    private String name; //name of the item we create
    private double rate; //how much money you pay or receive
    private String category; //group were the income or expense falls under
    private Period period; //Used to determine the paying period for income source. Note "None" used for expense only
    private double periodAmount; //Number of times for payPeriod


    //Constructor for BudgetItem
    public BudgetItem(String name, double rate, String category, Period period,double periodAmount)
    {
        this.name = name;
        this.rate = rate;
        this.category = category;
        this.period = period;
        this.periodAmount = periodAmount;
    }

    //Getter and setter for name
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    //Getter and setter for rate
    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    //Getter and setter for category
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    //Getter and setter for period
    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }



    //Getter and Setter for periodAmount
    public double getPeriodAmount() {
        return periodAmount;
    }

    public void setPeriodAmount(double periodAmount) {
        this.periodAmount = periodAmount;
    }

}
