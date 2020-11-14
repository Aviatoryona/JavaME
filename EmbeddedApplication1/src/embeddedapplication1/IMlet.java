/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package embeddedapplication1;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import javax.microedition.midlet.*;

/**
 * @author Aviator
 */
public class IMlet extends MIDlet implements CommandListener{
    public static Form form;
      public static Display disp;
    public void startApp() {      
        form.append(new StringItem("Hello Yonathaniel",null));
        disp=Display.getDisplay(this);
        disp.setCurrent(form);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        
    }
}
