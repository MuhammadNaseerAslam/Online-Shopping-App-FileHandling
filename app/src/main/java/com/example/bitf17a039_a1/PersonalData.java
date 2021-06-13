package com.example.bitf17a039_a1;

public class PersonalData
{
    public String Fname;
    public String Lname;
    public String Email;
    public String Contact;
    PersonalData()
    {

    }
    void setFname(String f)
    {
        this.Fname=f;
    }
    void setLname(String f)
    {
        this.Lname=f;
    }
    void setEmail(String f)
    {
        this.Email=f;
    }
    void setContact(String f)
    {
        this.Contact=f;
    }
    PersonalData(String f,String l,String e,String c)
    {
        this.Fname=f;
        this.Lname=l;
        this.Email=e;
        this.Contact=c;
    }
}
