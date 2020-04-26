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
public class EMI2 implements java.io.Serializable {
    private Integer ID;
    private Integer CID;
    //private CustMaster custMaster;
    private float EMIAmount;
    private float InterestAmount;
    private float TotalAmount;
    
    public EMI2(){
        
    }
   
    public EMI2(Integer ID, Integer CID, float EMIAmount, float InterestAmount, float TotalAmount){
        this.ID=ID;
        this.CID=CID;
        this.EMIAmount=EMIAmount;
        this.InterestAmount=InterestAmount;
        this.TotalAmount=TotalAmount;
    }
    public Integer getID(){
        return this.ID;
    }
    public void setID(Integer ID){
        this.ID=ID;
    }
   /* public CustMaster getCustMaster(){
        return this.custMaster;
    }
    public void setCustMaster(){
        this.custMaster=custMaster;
    }*/
     public Integer getCID(){
        return this.CID;
    }
    public void setCID(Integer CID){
        this.CID=CID;
    }
    public float getEMIAmount(){
        return this.EMIAmount;
    }
    public void setEMIAmount(float EMIAmount){
        this.EMIAmount=EMIAmount;
    }
    public float getInterestAmount(){
        return this.InterestAmount;
    }
    public void setInterestAmount(float InterestAmount){
        this.InterestAmount=InterestAmount;
    }
    public float getTotalAmount(){
        return this.TotalAmount;
    }
    public void setTotalAmount(float TotalAmount){
        this.TotalAmount=TotalAmount;
    }
}
