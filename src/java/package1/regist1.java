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
public class regist1 implements java.io.Serializable {
    private Integer RID;
    private String FullName;
    private String UserName;
    private Integer MobileNo;
    private String Password;
    private String EmailId;
    public regist1(){
        
    }
    public regist1(Integer RID, String FullName, String UserName,Integer MobileNo,String Password, String EmailId){
        this.RID=RID;
        this.FullName=FullName;
        this.UserName=UserName;
        this.MobileNo=MobileNo;
        this.Password=Password;
        this.EmailId=EmailId;
    }
    public Integer getRID(){
        return RID;
    }
    public void setRID(Integer RID){
        this.RID=RID;
    }
    public String getFullName(){
        return this.FullName;
    }
    public void setFullName(String FullName){
        this.FullName=FullName;
                
    }
    public String getUserName(){
        return this.UserName;
    }
    public void setUserName(String UserName){
        this.UserName=UserName;
                
    }
    public Integer getMobileNo(){
        return this.MobileNo;
    }
    public void setMobileNo(Integer MobileNo){
        this.MobileNo=MobileNo;
    }
     public String getPassword(){
        return this.Password;
    }
    public void setPassword(String Password){
        this.Password=Password;
                
    }
     public String getEmailId(){
        return this.EmailId;
    }
    public void setEmailId(String EmailId){
        this.EmailId=EmailId;
                
    }
}
