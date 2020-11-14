/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import Db_Connect.connect;
import Interfaces.*;
import javax.microedition.lcdui.*;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import student_registration.Midlet;
/**
 *
 * @author Aviator
 */
public class View{
    public Form formm=Midlet.form;
    public Display dispp=Midlet.disp;
      RecordStore rs1=null;
    public  View(){
        String passs="";
        Intializer.DOA.setString("");
        connect con =new connect();
        StringItem progress=new StringItem("Details","");
      //  String items[]={"Name: ","Reg NO: ","Faculty: ","Course: ","Yr: ",
       //                  "Sem: ","Email: ","D.O.A: ","Password: "};
           try{
               
                           rs1= RecordStore.openRecordStore(formm.getTitle(),true,0,true) ; 
                           
                           try{
                          for(int i = 1; i <= rs1.getNumRecords(); i++){
                          progress.setText(progress.getText() + "\n");
                          for(int j = 0; j < rs1.getRecord(i).length; j++){
                          progress.setText(progress.getText() + (char)(rs1.getRecord(i)[j])); 
                                       }
                                 }
                        
                        formm.deleteAll();
                        Alert alt=new Alert("","Retrieving Data......\nPlease Wait.........!",null,null);     
                         alt.setTimeout(5000);
                         AlertType.INFO.playSound(dispp);
                         dispp.setCurrent(alt);
                        formm.append(progress);
                        dispp.setCurrent(formm);
                        rs1.closeRecordStore();
                        
                           }catch(NullPointerException ne){
                           Alert alt=new Alert("","NO RECORDS FOUND",null,null);     
                         alt.setTimeout(Alert.FOREVER);
                         AlertType.INFO.playSound(dispp);
                         dispp.setCurrent(alt);
                           }
                        
                 }catch(RecordStoreException re){
           Alert alt=new Alert("ALERT","Database Not Found!",null,null);     
             alt.setTimeout(2000);
             AlertType.ERROR.playSound(dispp);
             dispp.setCurrent(alt);

           }
        
       /* formm.append(Intializer.Name);
        formm.append(Intializer.Reg);
        formm.append(Intializer.faculty);
        formm.append(Intializer.Course);
        formm.append(Intializer.year);
        formm.append(Intializer.sem);
        formm.append(Intializer.Mail);
        formm.append(Intializer.DOA);*/
        
    }
}
