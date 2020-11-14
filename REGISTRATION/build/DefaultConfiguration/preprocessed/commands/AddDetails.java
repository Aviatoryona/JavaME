/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import Db_Connect.connect;
import Interfaces.Initialixer;
import Interfaces.Intializer;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Form;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import student_registration.Log_In;
import student_registration.Midlet;

/**
 *
 * @author Aviator
 */
public class AddDetails {
    RecordStore rs1=null;
    public Display dispp=Midlet.disp;
  public String name;
  private String reg_NO;
  private String faculty;
  private String course;
  private int year;
  private int sem;
  private String Email;
  private String D_O_A;
  private String PASSWORD,pass2;
   public Form formm=Midlet.form;
    public AddDetails(){
        formm.deleteAll();
        formm.append(Intializer.TName);
        Initialixer ini=new Initialixer();
         ini.Initialixer();
        formm.append(Intializer.Faculty);
        formm.append(Intializer.TCourse);
        formm.append(Intializer.Yr);
        formm.append(Intializer.Sem);
        formm.append(Intializer.TMail);
        Intializer.TDOA.setString("yyyy/ mm /dd");
        formm.append(Intializer.TDOA);
        formm.append(Intializer.pass);  
        formm.append(Intializer.pass2);
    } 
    
     connect cn=new connect();
  Log_In in= new  Log_In();
    public  int Save(){
        Form formm= in.formm;
        name=(Intializer.TName).getString();
        reg_NO=formm.getTitle();
        faculty=(Intializer.Faculty.getString(Intializer.Faculty.getSelectedIndex()));
        course=(Intializer.TCourse).getString();
        year=Integer.parseInt(Intializer.Yr.getString(Intializer.Yr.getSelectedIndex()));
        sem=Integer.parseInt(Intializer.Sem.getString(Intializer.Sem.getSelectedIndex()));
        Email=Intializer.TMail.getString();
        D_O_A=Intializer.TDOA.getString();
        PASSWORD=Intializer.pass.getString();  
         pass2= Intializer.pass2.getString();      
        String Details[]={name,reg_NO,faculty,course,""+year,
                         ""+sem,Email,D_O_A,PASSWORD};
                try{
                    if("".equals(name) || "".equals(reg_NO) || "".equals(course)|| "".equals(Email)|| "".equals(PASSWORD)){
                    cn.DbConnectFailure(); 
                    formm.removeCommand(Intializer.Save);
                    formm.removeCommand(Intializer.back);
                    formm.removeCommand(Intializer.Next);
                    }
                    else if(!pass2.equals(PASSWORD)){
                     cn.DbConnectFailure2();
                     formm.removeCommand(Intializer.Save);
                     formm.removeCommand(Intializer.back);
                     formm.removeCommand(Intializer.Next);
                    }
                    else if(PASSWORD.length()<5){
                     cn.shortPass();
                     formm.removeCommand(Intializer.Save);
                     formm.removeCommand(Intializer.back);
                     formm.removeCommand(Intializer.Next);
                    }
                    else{
                        String reg="";
                       rs1=RecordStore.openRecordStore(reg_NO, true);
                       
                          for(int j=0;j<rs1.getRecord(2).length;j++){
                             reg+=(char)(rs1.getRecord(2)[j]);
                                                 } 
                             formm.deleteAll();
                        Alert alt=new Alert("","Adding  Data......\nPlease Wait.........!",null,null);     
                         alt.setTimeout(5000);
                         AlertType.INFO.playSound(dispp);
                         dispp.setCurrent(alt);
                         for(int i = 0; i < Details.length; i++){
                         rs1.addRecord(Details[i].getBytes(), 0, Details[i].length());
                          rs1.closeRecordStore();    
                         cn.ConnectAlert();
                         }
                      
                      formm.deleteAll();
                      formm.removeCommand(Intializer.Save);
                      formm.removeCommand(Intializer.back);
                      formm.removeCommand(Intializer.Next);
                      dispp.setCurrent(formm);
                             }
                      }
                      catch(RecordStoreException re){
                                   cn.failConnectAlert();
                      }
               return 0;
                }
}
