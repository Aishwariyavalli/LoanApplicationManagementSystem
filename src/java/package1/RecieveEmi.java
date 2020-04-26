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
public class RecieveEmi implements java.io.Serializable {
    private Integer CID;
    private Integer RecieptNo;
    private Integer NoOfPayment;
    private String RecieptDate;
    private String EMIDate;
    private float EMIAmount;
    private float LateFineCharge;
    private float TotalAmount;
    
    public RecieveEmi(){
        
    }
    public RecieveEmi(Integer CID, Integer RecieptNo, Integer NoOfPayment, String RecieptDate, String EMIDate,float EMIAmount, float LateFineCharge, float TotalAmount){
        this.CID=CID;
        this.RecieptNo=RecieptNo;
        this.NoOfPayment=NoOfPayment;
        this.RecieptDate=RecieptDate;
        this.EMIDate=EMIDate;
        this.EMIAmount=EMIAmount;
        this.EMIDate=EMIDate;
        this.EMIAmount=EMIAmount;
        this.LateFineCharge=LateFineCharge;
        this.TotalAmount=TotalAmount;
    }
    public Integer getCID(){
        return this.CID;
    }
    public void setCID(Integer CID){
        this.CID=CID;
    }
     public Integer getRecieptNo(){
        return this.RecieptNo;
    }
    public void setRecieptNo(Integer RecieptNo){
        this.RecieptNo=RecieptNo;
    }
     public Integer getNoOfPayment(){
        return this.NoOfPayment;
    }
    public void setNoOfPayment(Integer NoOfPayment){
        this.NoOfPayment=NoOfPayment;
    }
     public String getRecieptDate(){
        return this.RecieptDate;
    }
    public void setRecieptDate(String RecieptDate){
        this.RecieptDate=RecieptDate;
    }
     public String getEMIDate(){
        return this.EMIDate;
    }
    public void setEMIDate(String EMIDate){
        this.EMIDate=EMIDate;
    }
    public float getEMIAmount(){
        return this.EMIAmount;
    }
    public void setEMIAmount(float EMIAmount){
        this.EMIAmount=EMIAmount;
    }
     public float getLateFineCharge(){
        return this.LateFineCharge;
    }
    public void setLateFineCharge(float LateFineCharge){
        this.LateFineCharge=LateFineCharge;
    }
     public float getTotalAmount(){
        return this.TotalAmount;
    }
    public void setTotalAmount(float TotalAmount){
        this.TotalAmount=TotalAmount;
    }
   
}
