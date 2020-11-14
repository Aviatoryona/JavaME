/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import Db_Connect.connect;
import Interfaces.Initialixer;
import Interfaces.Intializer;
import javax.microedition.lcdui.*;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import student_registration.Midlet;
/**
 *
 * @author Aviator
 */
public class Edit implements ItemCommandListener{
   public Form formm=Midlet.form;
   public Display dispp=Midlet.disp;
    String label="",
            reg=Intializer.TReg.getString();;
    Alert alt;
      public Edit(){
          Initialixer ini=new Initialixer();
          ini.Initialixer();
           formm.append("Edit Details");
           formm.append(Intializer.edit);
           formm.append("Enter Registration Number");
           formm.append(Intializer.TReg);
          Intializer.TReg.addCommand(Intializer.yes);
          Intializer.TReg.setItemCommandListener(this);
          Intializer.passwordEdit.addCommand(Intializer.change);
          Intializer.passwordEdit.setItemCommandListener(this);
          formm.removeCommand(Intializer.yess);
      }
        public void alert1(){
             alt=new Alert("ALERT","Updating Database.....\nplease wait......!",null,null);     
             alt.setTimeout(4000);
             dispp.setCurrent(alt);
        }
        public void alert2(){
             alt=new Alert("ALERT","DONE!",null,null);     
             alt.setTimeout(Alert.FOREVER);
             AlertType.INFO.playSound(dispp);
             dispp.setCurrent(alt);
        }
        
    public void editt(){
            label=Intializer.edit.getString((Intializer.edit.getSelectedIndex()));
            try{
            RecordStore rs1=Intializer.rs;
                 rs1=RecordStore.openRecordStore(formm.getTitle(), true);
                 
            if("Name".equals(label)){
             formm.deleteAll(); 
             alert1();
             String newdata=Intializer.NEWITEM.getString();
             rs1.setRecord(1,newdata.getBytes() ,0,newdata.length());
             formm.deleteAll(); 
             alert2();
            Intializer.TReg.removeCommand(Intializer.yes);
            
             }
              
         else if("Faculty".equals(label)){
            formm.deleteAll(); 
             alert1();
             String newdata=Intializer.NEWITEM.getString();
             rs1.setRecord(3,newdata.getBytes() ,0,newdata.length());
             formm.deleteAll(); 
             alert2();
            Intializer.TReg.removeCommand(Intializer.yes);
          } 
           else if("Course".equals(label)){
            formm.deleteAll(); 
             alert1();
             String newdata=Intializer.NEWITEM.getString();
             rs1.setRecord(4,newdata.getBytes() ,0,newdata.length());
             formm.deleteAll(); 
             alert2();
            Intializer.TReg.removeCommand(Intializer.yes);
          }
           else if("Year Of Study".equals(label)){
            formm.deleteAll(); 
             alert1();
             String newdata=Intializer.NEWITEM.getString();
             rs1.setRecord(5,newdata.getBytes() ,0,newdata.length());
             formm.deleteAll(); 
             alert2();
            Intializer.TReg.removeCommand(Intializer.yes);
          }
           else if("Semester".equals(label)){
            formm.deleteAll(); 
             alert1();
             String newdata=Intializer.NEWITEM.getString();
             rs1.setRecord(6,newdata.getBytes() ,0,newdata.length());
             formm.deleteAll(); 
             alert2();
            Intializer.TReg.removeCommand(Intializer.yes);
          }
           else if("EMail Address".equals(label)){
            formm.deleteAll(); 
             alert1();
             String newdata=Intializer.NEWITEM.getString();
             rs1.setRecord(7,newdata.getBytes() ,0,newdata.length());
             formm.deleteAll(); 
             alert2();
            Intializer.TReg.removeCommand(Intializer.yes);
          }
           else if("Date Of Admission".equals(label)){
            formm.deleteAll(); 
             alert1();
             String newdata=Intializer.NEWITEM.getString();
             rs1.setRecord(8,newdata.getBytes() ,0,newdata.length());
             formm.deleteAll(); 
             alert2();
            Intializer.TReg.removeCommand(Intializer.yes);
          } 
           
            }catch(RecordStoreException re){
                connect cn=new connect();
                cn.failConnectAlert();
            }
                 }
       public void actions(){
           label=Intializer.edit.getString((Intializer.edit.getSelectedIndex()));
            if("Name".equals(label)){
            formm.deleteAll(); 
            Intializer.NEWITEM.setLabel("New "+label);
            formm.append(Intializer.NEWITEM);  
            formm.append(Intializer.passwordEdit);
            Intializer.TReg.removeCommand(Intializer.yes);
             }
            else if("Registration Number".equals(label)){
            formm.deleteAll(); 
            Intializer.NEWITEM.setLabel("New "+label);
            formm.append(Intializer.NEWITEM);  
            formm.append(Intializer.passwordEdit);
            Intializer.TReg.removeCommand(Intializer.yes);
          }  
           else if("Faculty".equals(label)){
            formm.deleteAll(); 
            Intializer.NEWITEM.setLabel("New "+label);
            formm.append(Intializer.NEWITEM);  
            formm.append(Intializer.passwordEdit);
            Intializer.TReg.removeCommand(Intializer.yes);
          } 
           else if("Course".equals(label)){
            formm.deleteAll(); 
            Intializer.NEWITEM.setLabel("New "+label);
            formm.append(Intializer.NEWITEM);  
            formm.append(Intializer.passwordEdit);
            Intializer.TReg.removeCommand(Intializer.yes);
          }
           else if("EMail Address".equals(label)){
            formm.deleteAll(); 
            Intializer.NEWITEM.setLabel("New "+label);
            formm.append(Intializer.NEWITEM);  
            formm.append(Intializer.passwordEdit);
            Intializer.TReg.removeCommand(Intializer.yes);
          }
           else if("Date Of Admission".equals(label)){
            formm.deleteAll(); 
            Intializer.NEWITEM.setLabel("New "+label);
            formm.append(Intializer.NEWITEM);  
            formm.append(Intializer.passwordEdit);
            Intializer.TReg.removeCommand(Intializer.yes);
          }
           else if("Date Of Admission".equals(label)){
            formm.deleteAll(); 
            Intializer.NEWITEM.setLabel("New "+label);
            formm.append(Intializer.NEWITEM);  
            formm.append(Intializer.passwordEdit);
            Intializer.TReg.removeCommand(Intializer.yes);
          }
          }
       
    public void commandAction(Command c, Item item) {
        if(c.equals(Intializer.yes) && item.equals(Intializer.TReg)){   
            actions();
        }
      else  if(c.equals(Intializer.change) && item.equals(Intializer.passwordEdit)){
            formm.deleteAll();
            label=Intializer.edit.getString((Intializer.edit.getSelectedIndex()));
            formm.append("\n\n\n\tEdit Details For=>"+reg+"\n\n"+"Set "+label+"=>"+Intializer.NEWITEM.getString());
            Intializer.passwordEdit.removeCommand(Intializer.change);
            formm.addCommand(Intializer.yess);
      }
    }
}