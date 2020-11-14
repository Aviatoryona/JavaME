/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;
import Db_Connect.connect;
import Interfaces.Intializer;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;

/**
 *
 * @author Aviator
 */
   public  class OK{
             public void OK(){
                 connect cn=new connect();
          String reg= Intializer.registrationNO.getString();
          String pass=Intializer.password.getString();
          
               String DBname=reg;
                              try{
                      RecordStore rs1=Intializer.rs;
                       rs1=RecordStore.openRecordStore(reg, true);
                       for(int i = 1; i <= rs1.getNumRecords(); i++){
                                       rs1.deleteRecord(i);
                                 }
                       
                     cn.deleteSuccess();
                      }
                      catch(RecordStoreException re){
                                   cn.failConnectAlert();
                                   
                      }
      
        }
      }