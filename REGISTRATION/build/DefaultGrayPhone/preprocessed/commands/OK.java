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
       RecordStore rs1=null;
             public void OK(){
                 connect cn=new connect();
          String reg= Intializer.registrationNO.getString();
          String pass=Intializer.password.getString();
          
               String DBname=reg;
                              try{
                       rs1=RecordStore.openRecordStore(reg, true);
                       for(int i = 1; i <= rs1.getNumRecords(); i++){
                                       rs1.deleteRecord(i);
                                 }
                       RecordStore.deleteRecordStore(reg);
                       cn.deleteSuccess();
                      }
                      catch(RecordStoreException re){
                                   cn.failConnectAlert();
                                   
                      }
      
        }
      }