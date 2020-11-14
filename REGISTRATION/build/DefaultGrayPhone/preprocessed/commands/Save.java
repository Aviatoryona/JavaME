/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;
import Db_Connect.*;
import Interfaces.*;
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
public class Save {
  RecordStore rs1=null;
  public Display dispp=Midlet.disp;
  connect cn=new connect();
  Log_In in= new  Log_In();
  Form formm= in.formm;
    public  int Save(){
                formm.deleteAll();
                String name,reg_NO,faculty,course,Email,D_O_A,PASSWORD,pass2;
                int year,sem;
                name=(Intializer.TName).getString();
                reg_NO=(Intializer.TReg).getString();
                faculty=(Intializer.Faculty.getString(Intializer.Faculty.getSelectedIndex()));
                course=(Intializer.TCourse).getString();
                year=Integer.parseInt(Intializer.Yr.getString(Intializer.Yr.getSelectedIndex()));
                sem=Integer.parseInt(Intializer.Sem.getString(Intializer.Sem.getSelectedIndex()));
                Email=Intializer.TMail.getString();
                D_O_A=Intializer.TDOA.getString();
                PASSWORD=Intializer.pass.getString();  
                pass2= Intializer.pass2.getString();
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
                       // String reg="";
                              rs1= RecordStore.openRecordStore(reg_NO, true,0, true) ;           
                 String Details[]={name,reg_NO,faculty,course,""+year, ""+sem,Email,D_O_A,PASSWORD}; 
                         for(int i = 0; i < Details.length; i++){
                         rs1.addRecord(Details[i].getBytes(), 0, Details[i].length());
                             }
                          Alert  alt=new Alert("","Saving data ......\n\n\nplease wait.........!",null,null);     
                           alt.setTimeout(5000);
                           AlertType.INFO.playSound(dispp);
                           dispp.setCurrent(alt);
                          rs1.closeRecordStore();
                         //cn.ConnectAlert();   
                      formm.deleteAll();
                      formm.removeCommand(Intializer.Save);
                      formm.removeCommand(Intializer.back);
                      formm.removeCommand(Intializer.Next);
                      dispp.setCurrent(formm);
                             }
                      }
                      catch(RecordStoreException re){
                                   cn.failConnectAlert();
                                   formm.removeCommand(Intializer.Save);
                      }
               return 0;
                }
    
}
