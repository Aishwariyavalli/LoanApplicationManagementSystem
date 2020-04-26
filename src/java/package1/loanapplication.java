/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

/**
 *
 * @author Aishw
 */
public class loanapplication implements java.io.Serializable {
    
    private Integer AppId;
    private String LoanType;
    private Integer LoanAmount;
    private String CustName;
    private Integer MonthlyIncome;
    private String Gender;
    private Integer Age;
    private String Address;
    private Integer MobileNo;
    private Integer AlternateNo;
    private String emailId;
    
    public loanapplication(){
        
    }
    public loanapplication(Integer AppId, String LoanType, Integer LoanAmount, String CustName, Integer MonthlyIncome, String Gender, Integer Age, String Address, Integer MobileNo, Integer AlternateNo, String emailId){
        this.AppId=AppId;
        this.LoanType=LoanType;
        this.LoanAmount=LoanAmount;
        this.CustName=CustName;
        this.MonthlyIncome=MonthlyIncome;
        this.Gender=Gender;
        this.Age=Age;
        this.Address=Address;
        this.MobileNo=MobileNo;
        this.AlternateNo=AlternateNo;
        this.emailId=emailId;
                
      }
    public Integer getAppId(){
        return this.AppId;
    }
    public void setAppId(Integer AppId){
        this.AppId=AppId;
    }
     public String getLoanType(){
        return this.LoanType;
    }
    public void setLoanType(String LoanType){
        this.LoanType=LoanType;
    }
     public Integer getLoanAmount(){
        return this.LoanAmount;
    }
    public void setLoanAmount(Integer LoanAmount){
        this.LoanAmount=LoanAmount;
    }
     public String getCustName(){
        return this.CustName;
    }
    public void setCustName(String CustName){
        this.CustName=CustName;
    }
     public Integer getMonthlyIncome(){
        return this.MonthlyIncome;
    }
    public void setMonthlyIncome(Integer MonthlyIncome){
        this.MonthlyIncome=MonthlyIncome;
    }
     public String getGender(){
        return this.Gender;
    }
    public void setGender(String Gender){
        this.Gender=Gender;
    }
     public Integer getAge(){
        return this.Age;
    }
    public void setAge(Integer Age){
        this.Age=Age;
    }
      public String getAddress(){
        return this.Address;
    }
    public void setAddress(String Address){
        this.Address=Address;
    }
     public Integer getMobileNo(){
        return this.MobileNo;
    }
    public void setMobileNo(Integer MobileNo){
        this.MobileNo=MobileNo;
    }
     public Integer getAlternateNo(){
        return this.AlternateNo;
    }
    public void setAlternateNo(Integer AlternateNo){
        this.AlternateNo=AlternateNo;
    }
     public String getEmailId(){
        return this.emailId;
    }
    public void setEmailId(String emailId){
        this.emailId=emailId;
    }
    
}
