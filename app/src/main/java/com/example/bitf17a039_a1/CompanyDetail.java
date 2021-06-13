package com.example.bitf17a039_a1;

public class CompanyDetail
{
    public String Company;
    public String ZipCode;
    public String State;
    public String City;
    public String Boxes;
    public String DateAndTime;

    CompanyDetail()
    {

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
    CompanyDetail(String com, String z, String s, String cit,String b,String dt)
    {
        this.Company=com;
        this.ZipCode=z;
        this.State=s;
        this.City=cit;
        this.Boxes=b;
        this.DateAndTime=dt;
    }
}
