package com.example.budget_simplifier_v2;

public interface BudgetItem_IF
{
    public enum Period{NONE, HOURLY, DAILY, WEEKLY, MONTHLY, YEARLY};

    //Getter and setter for name
    public String getName();


    public void setName(String name);

    public void setSD(String SD);

    public String getSD();

    //Getter and setter for rate
    public double getRate();

    public void setRate(double rate);

    //Getter and setter for category
    public String getCategory();

    public void setCategory(String category);


    //Getter and setter for period
    public BudgetItem.Period getPeriod();

    public void setPeriod(BudgetItem.Period period);

    //Getter and Setter for periodAmount
    public double getPeriodAmount();
    public void setPeriodAmount(double periodAmount);
    public String getColor();
}
