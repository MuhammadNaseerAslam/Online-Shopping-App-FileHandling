package com.example.bitf17a039_a1;

public class Order
{

    public PersonalData pd;
    public CompanyDetail cd;
    Order(PersonalData p)
    {
        this.pd=p;
    }
    Order()
    {

    }
    Order(PersonalData per,CompanyDetail comp)
    {
       this.pd=per;
        this.cd=comp;
    }
    public String Fname;
    public Order Lname;
    public Order Email;
    public Order Contact;
    public String Company;
    public String ZipCode;
    public String State;
    public String City;
    public String Boxes;
    public String DateAndTime;


/*
    void setFname(String f) { this.Fname=f; }
    void setLname(Order f)
    {
        this.Lname=f;
    }
    void setEmail(Order f)
    {
        this.Email=f;
    }
    void setContact(Order f)
    {
        this.Contact=f;
    }
    void setCompany(String f)
    {
        this.Company=f;
    }
    void setZipCode(String f)
    {
        this.ZipCode=f;
    }
    void setState(String f)
    {
        this.State=f;
    }
    void setCity(String f)
    {
        this.City=f;
    }
    void setBoxes(String f)
    {
        this.Boxes=f;
    }
    void setDateAndTime(String f)
    {
        this.DateAndTime=f;
    }

 */
}

