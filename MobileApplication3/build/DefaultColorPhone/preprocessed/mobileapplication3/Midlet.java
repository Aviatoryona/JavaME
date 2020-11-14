/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileapplication3;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

/**
 * @author Aviator
 */
public class Midlet extends MIDlet implements CommandListener{ 
   public static Form f=new Form("Example");
   private Command exit,yes=new Command("Yes",Command.OK,1);
   private Display dp;
    public void startApp() {
        exit=new Command("Exit",Command.EXIT,0);
        f.addCommand(exit);
        f.addCommand(yes);
        f.append("HELLO & WELCOME");
        
        f.setCommandListener(this);
        dp=Display.getDisplay(this);
        dp.setCurrent(f);
    }
    
    public void pauseApp() {
    }
   
    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if(exit.equals(c) && d.equals(f)){
         notifyDestroyed();
             }
        if(yes.equals(c) && d.equals(f)){
         NewClass nc=new NewClass();
          dp.setCurrent(nc.ff);
             }
    }
 
}
