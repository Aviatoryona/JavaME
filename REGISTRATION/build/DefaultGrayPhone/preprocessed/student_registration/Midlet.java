/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package student_registration;
import Db_Connect.connect;
import Interfaces.*;
import commands.*;
import java.util.Date;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import javax.microedition.rms.*;
/**
 * @author Aviator
 */
public class Midlet extends MIDlet implements CommandListener {
      RecordStore rs1=null;
      public static Form form;
      public static Display disp; 
      Date d=new Date();
      ImageItem pic;
      String passs=""; 
             StringItem progress=new StringItem("Details","");
    public void startApp() {
        start();
    }
    
    public void startUp() {                          //commands after login in
        form.addCommand(Intializer.Exit);     
        form.addCommand(Intializer.Delete);
        form.addCommand(Intializer.Edit);
        form.addCommand(Intializer.View);
        form.setCommandListener(this);
        disp.setCurrent(form);
    }
    public void pauseApp() {
        
    }
    
    public void destroyApp(boolean unconditional) {
    }
    
     public void start(){
         form=new Form("REGISTRATION PORTAL");
         form.append("\n\n\n\n\n~~~~~~~~~~~~~~~~~~~~WELCOME~~~~~~~~~~~~~~~~~~~~\n"+d);
         form.addCommand(Intializer.cont);
         form.addCommand(Intializer.Exit);
         form.setCommandListener(this);
         disp=Display.getDisplay(this);
         disp.setCurrent(form);
     }
     public void Home(){                                  //homepage after login in
           form.deleteAll();
           form.removeCommand(Intializer.New);
           form.removeCommand(Intializer.back);
           form.removeCommand(Intializer.logIn);
           form.removeCommand(Intializer.Next);
           form.removeCommand(Intializer.Save);
           form.removeCommand(Intializer.forget);
           form.removeCommand(Intializer.cont);
           form.removeCommand(Intializer.back);
           form.removeCommand(Intializer.yess);
           form.append("\n\n\n\n~~~~~~~~~~~"+form.getTitle()+"~~~~~~~~~~~~~~~~~~~~\n"+d);
           form.removeCommand(Intializer.Ok);
     }
     public int getCredentials(){                        //login in form
         form.deleteAll();
            Log_In in=new Log_In();
            disp=Display.getDisplay(this);
            form.removeCommand(Intializer.cont);
            form.addCommand(Intializer.forget);
            form.addCommand(Intializer.New);
            form.addCommand(Intializer.Exit);
            form.addCommand(Intializer.help);
            disp.setCurrent(in.formm);
     return 0;
     }
     
     public int checkCredentials(String reg,String pass){         //login in 
         form.deleteAll();
          connect con =new connect();
          Log_In logi =new Log_In();
          form.removeCommand(Intializer.forget);
          form.removeCommand(Intializer.logIn);
          form.addCommand(Intializer.Exit);
          reg=Intializer.TReg.getString();
          pass=Intializer.pass.getString();
                 if(!"".equals(reg) && !"".equals(pass)){
                             try{  
                                RecordStore.openRecordStore(reg, true,0, true) ;                            
                                  form.deleteAll();
                                  disp=Display.getDisplay(this);
                                  form.setTitle(reg);
                                   Home();
                                   this.startUp();
                                  disp.setCurrent(form);
                           }catch(RecordStoreException re){
                               Alert alt=new Alert("ALERT","Database Not Found!"+re,null,null);     
                               alt.setTimeout(2000);
                               AlertType.WARNING.playSound(disp);
                               disp.setCurrent(alt);
                               form.deleteAll();
                               getCredentials();
                                 } 
   
                 }else{
                               form.deleteAll();
            Alert alt=new Alert("","Kindly Provide registration number and password!",null,null);     
             alt.setTimeout(3000);
             AlertType.ERROR.playSound(disp);
             disp.setCurrent(alt);
                                  this.getCredentials();
                                  disp.setCurrent(form);
                 }
     return 0;
     }
     
     public void removeCommands(){                             //remove commands from form     after delete records
               form.removeCommand(Intializer.Ok);
               form.removeCommand(Intializer.back);
               form.removeCommand(Intializer.Edit);
               form.removeCommand(Intializer.View);
               form.removeCommand(Intializer.Cancel);
               form.removeCommand(Intializer.Delete);
     }
     
     public void xxx(){              // recall if Incredentials Icorrect in Password reset
          form.deleteAll();
          connect con =new connect();
           con.failReset();
          form.removeCommand(Intializer.forget);
          form.removeCommand(Intializer.logIn);
          form.addCommand(Intializer.reset);
          Pass_Reset  PR=new Pass_Reset ();
            disp.setCurrent(PR.formm);
     }
     public void resetPassword(String reg,String pass,String pass2){
           reg=Intializer.TReg.getString();
           pass=Intializer.pass.getString();
           pass2=Intializer.pass2.getString();
           
           if(((!"".equals(reg)) && !"".equals(pass)) ){
               if(pass.equals(pass2)){
                  try{
                      rs1=RecordStore.openRecordStore(reg, true);
                      for(int j=0;j<rs1.getRecord(9).length;j++){
                      rs1.setRecord(9, pass.getBytes(),0,pass.length());
                      }
                     form.deleteAll();
             Alert alt=new Alert("","Password SuccessFully swapped!",null,null);     
             alt.setTimeout(Alert.FOREVER);
             AlertType.INFO.playSound(disp);
             disp.setCurrent(alt); 
                  }catch(RecordStoreException re){
                    form.deleteAll();
             Alert alt=new Alert("","Connection Failure!"+re,null,null);     
             alt.setTimeout(3000);
             AlertType.ERROR.playSound(disp);
             disp.setCurrent(alt);
                  }
               form.removeCommand(Intializer.reset);
               }
               else{
           xxx();
           }
           } 
           else{
           xxx();
           }  
    }
    public void commandAction(Command c, Displayable d){                //all commands actions performed here....
        if((Intializer.Exit).equals(c) && d.equals(form)){               //exit program
            form.deleteAll();
            Alert alt=new Alert("","Closing application......!",null,null);     
             alt.setTimeout(5000);
             AlertType.CONFIRMATION.playSound(disp);
             disp.setCurrent(alt);
            notifyDestroyed();
        }
        else if((Intializer.back).equals(c) && d.equals(form)){            //go back
            Home();  
        } 
        else if((Intializer.New).equals(c) && d.equals(form)){
            form.deleteAll();
            form.addCommand(Intializer.back);
            form.removeCommand(Intializer.logIn);
            form.removeCommand(Intializer.Ok);
            Forms fm=new Forms();
            commands com=new commands(); 
               disp.setCurrent(fm.formm);
               disp.setCurrent(com.formm);
        }
        
        else if((Intializer.Save).equals(c) && d.equals(form)){                  //save details to db,new account/user
            form.deleteAll();
            form.removeCommand(Intializer.Ok);  
              Save sv=new Save();
                 sv.Save();
                 getCredentials();
        }
        
        else if((Intializer.Cancel).equals(c) && d.equals(form)){                      //cancel
               form.deleteAll();
               Alert alt=new Alert("","\tCANCELLED",null,null);
               alt.setTimeout(2000);
               AlertType.INFO.playSound(disp);
               disp.setCurrent(alt);
               start();
        }
        else if((Intializer.View).equals(c) && d.equals(form)){            //view details from db
            form.deleteAll();
            form.addCommand(Intializer.back);
            form.removeCommand(Intializer.Ok);
            View vw=new View();
              disp.setCurrent(vw.formm);
        }
        else if((Intializer.Edit).equals(c) && d.equals(form)){                              //Edit DB details
           form.deleteAll();
           Intializer.TReg.addCommand(Intializer.yes);
           Intializer.passwordEdit.addCommand(Intializer.change);
           form.addCommand(Intializer.back);
           form.removeCommand(Intializer.Ok);
           form.addCommand(Intializer.Exit);
           Edit editt=new Edit();
           disp.setCurrent(editt.formm);
        } 
        
        else if((Intializer.Delete).equals(c) && d.equals(form)){                   //delete account command
            form.deleteAll();
            form.addCommand(Intializer.back);
            form.addCommand(Intializer.Cancel);
            form.addCommand(Intializer.Exit);
           Delete del=new Delete();
           disp.setCurrent(del.formm); 
        }
                                //delete command
        else if((Intializer.Ok).equals(c) && d.equals(form)){
             OK K=new OK();                                             //Confirm delete
               K.OK();
              this.getCredentials();
        } 
        else if((Intializer.Next).equals(c) && d.equals(form)){        // complete here......
              form.deleteAll();
              TextField tb=new TextField("Comments(optional)","",100,0);
               tb.setString("Comments can be either more details About yourself ");
               form.removeCommand(Intializer.Next);
               form.append(tb);
               form.addCommand(Intializer.Save);
               form.addCommand(Intializer.Exit);
        } 
        
      else  if((Intializer.cont).equals(c) && d.equals(form)){        // continue command here......
            this.getCredentials();
        }
      else  if((Intializer.forget).equals(c) && d.equals(form)){        // forgot password in command here......
          form.deleteAll();
          form.removeCommand(Intializer.forget);
          form.removeCommand(Intializer.logIn);
          form.addCommand(Intializer.reset);
          Pass_Reset  PR=new Pass_Reset ();
            disp.setCurrent(PR.formm); 
        } 
      else  if((Intializer.logIn).equals(c) && d.equals(form)){        // log in command here......
          checkCredentials("","");
        } 
      else  if((Intializer.reset).equals(c) && d.equals(form)){        // Reset passwprd cmmand in command here......
           form.deleteAll();
           resetPassword("","","");
        } 
     else  if((Intializer.yess).equals(c) && d.equals(form)){        // DO CONFIRM eDIT cmmand in command here......
            Edit dit= new Edit();
              dit.editt();
          //removeCommands();
         form.removeCommand(Intializer.yess);
        } 
         
    }
}
 