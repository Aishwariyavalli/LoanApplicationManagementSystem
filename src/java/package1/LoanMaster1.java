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
public class LoanMaster1 implements java.io.Serializable {
    private Integer LoanId;
    private Integer CID;
    private String LoanType;
    private Integer LoanTenure;
    private Integer LoanAmount;
    private String InterestType;
   private String IssueDate;
    private String MortgageDetails;
    private String GuarantorName;
    private String Address;
    private Integer ContactNo;
    private Integer ApprStatus;
    private Integer InterestRate;
    public LoanMaster1(){
        
    }
    public LoanMaster1(Integer LoanId, Integer CID, String LoanType, Integer LoanTenure, Integer LoanAmount,String InterestType, String IssueDate, String MortgageDetails, String GuarantorName,String Address,Integer ContactNo, Integer ApprStatus, Integer InterestRate){
        this.LoanId=LoanId;
        this.CID=CID;
        this.LoanType=LoanType;
        this.LoanTenure=LoanTenure;
        this.LoanAmount=LoanAmount;
        this.InterestType=InterestType;
        this.IssueDate=IssueDate;
        this.MortgageDetails=MortgageDetails;
        this.GuarantorName=GuarantorName;
        this.Address=Address;
        this.ContactNo=ContactNo;
        this.ApprStatus=ApprStatus;  
       this.InterestRate=InterestRate;
    }        
    public Integer getLoanId(){
        return this.LoanId;
    }
    public void setLoanId(Integer LoanId){
        this.LoanId=LoanId;
    }
    public Integer getCID(){
        return this.CID;
    }
    public void setCID(Integer CID){
        this.CID=CID;
    }
    public String getLoanType(){
        return this.LoanType;
    }
    public void setLoanType(String LoanType){
        this.LoanType=LoanType;
    }
    public Integer getLoanTenure(){
        return this.LoanTenure;
    }
    public void setLoanTenure(Integer LoanTenure){
        this.LoanTenure=LoanTenure;
    }
    public Integer getLoanAmount(){
        return this.LoanAmount;
    }
    public void setLoanAmount(Integer LoanAmount){
        this.LoanAmount=LoanAmount;
    }
     public String getInterestType(){
        return this.InterestType;
    }
    public void setInterestType(String InterestType){
        this.InterestType=InterestType;
    }
     public String getIssueDate(){
        return this.IssueDate;
    }
    public void setIssueDate(String IssueDate){
        this.IssueDate=IssueDate;
    }
     public String getMortgageDetails(){
        return this.MortgageDetails;
    }
    public void setMortgageDetails(String MortgageDetails){
        this.MortgageDetails=MortgageDetails;
    }
     public String getGuarantorName(){
        return this.GuarantorName;
    }
    public void setGuarantorName(String GuarantorName){
        this.GuarantorName=GuarantorName;
    }
     public String getAddress(){
        return this.Address;
    }
    public void setAddress(String Address){
        this.Address=Address;
    }
    
    public Integer getContactNo(){
        return this.ContactNo;
    }
    public void setContactNo(Integer ContactNo){
        this.ContactNo=ContactNo;
    }
     public Integer getApprStatus(){
        return this.ApprStatus;
    }
    public void setApprStatus(Integer ApprStatus){
        this.ApprStatus=ApprStatus;
    }
    public Integer getInterestRate(){
        return this.InterestRate;
    }
    public void setInterestRate(Integer InterestRate){
        this.InterestRate=InterestRate;
    }
}
