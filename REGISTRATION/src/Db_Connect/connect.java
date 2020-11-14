/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Db_Connect;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Display;
import student_registration.Midlet;
/**
 *
 * @author Aviator
 */
public class connect{
           
                // database initializers

   private Display dispp=Midlet.disp;
    public  connect(){
            failConnectAlert();
            ConnectAlert();
    }
    public final void failConnectAlert(){
             Alert alt=new Alert("ALERT","connection failure!",null,null);     
             alt.setTimeout(2000);
             AlertType.ERROR.playSound(dispp);
             dispp.setCurrent(alt);
    }
    
    public final void ConnectAlert(){
             Alert alt=new Alert("Finished","success!",null,null);     
             alt.setTimeout(2000);
             AlertType.INFO.playSound(dispp);
             dispp.setCurrent(alt);
    }
    public final void deleteSuccess(){
             Alert alt=new Alert("Finished","Delete Complete!",null,null);     
             alt.setTimeout(2000);
             AlertType.INFO.playSound(dispp);
             dispp.setCurrent(alt);
    }
    public final void failSave(){
             Alert alt=new Alert("Failed","Database ALREADY exists ,Use Another Registration Number!",null,null);     
             alt.setTimeout(3000);
             AlertType.ERROR.playSound(dispp);
             dispp.setCurrent(alt);
    }
    public final void failLOGIN(){
             Alert alt=new Alert("Failed","Credentials Incorrect!",null,null);     
             alt.setTimeout(2000);
             AlertType.ERROR.playSound(dispp);
             dispp.setCurrent(alt);
    }
    public final void failReset(){
             Alert alt=new Alert("Failed","Credentials Incorrect!",null,null);     
             alt.setTimeout(2000);
             AlertType.ERROR.playSound(dispp);
             dispp.setCurrent(alt);
    }
    public final void DbConnectFailure(){            //Db connect
             Alert alt=new Alert("Failed","Fill ALL The Fields!",null,null);     
             alt.setTimeout(3000);
             AlertType.ERROR.playSound(dispp);
             dispp.setCurrent(alt);
    }
    public final void DbConnectFailure2(){
             Alert alt=new Alert("Failed","Passwords Don't Match!",null,null);     
             alt.setTimeout(3000);
             AlertType.ERROR.playSound(dispp);
             dispp.setCurrent(alt);
    }
    public final void shortPass(){
             Alert alt=new Alert("Failed","Password Too Short ,Atleast 5 characters!",null,null);     
             alt.setTimeout(3000);
             AlertType.WARNING.playSound(dispp);
             dispp.setCurrent(alt);
    }
}
