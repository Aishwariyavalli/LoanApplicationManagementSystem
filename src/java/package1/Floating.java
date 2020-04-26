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
public class Floating implements java.io.Serializable {
     private Integer No;
    private String LoanType;
    private String Duration;
    private float Rate;
    
    public Floating(){
        
    }
    public Floating(Integer No, String LoanType, String Duration, float Rate){
        this.No=No;
        this.LoanType=LoanType;
        this.Duration=Duration;
        this.Rate=Rate;
    }
     public Integer getNo(){
        return this.No;
    }
    public void setNo(Integer No){
        this.No=No;
    }
    public String getLoanType(){
        return this.LoanType;
    }
    public void setLoanType(String LoanType){
        this.LoanType=LoanType;
    }
     public String getDuration(){
        return this.Duration;
    }
    public void setDuration(String Duration){
        this.Duration=Duration;
    }
    public float getRate(){
        return this.Rate;
    }
    public void setRate(float Rate){
        this.Rate=Rate;
    }
}
