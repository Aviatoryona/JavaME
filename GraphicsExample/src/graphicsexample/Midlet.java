/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicsexample;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.StringItem;
import javax.microedition.midlet.*;

/**
 * @author Aviator
 */
public class Midlet extends MIDlet implements CommandListener{
     public Form f;
     public Display d;
     public Command exit=new Command("Exit",Command.EXIT,0);
     public StringItem item;
     public void startApp() {
        d=Display.getDisplay(this);
        item=new StringItem("Progress","gogogo....");
        f=new Form("GRAPHICS");
        f.addCommand(exit);
        f.append(item);
        f.setCommandListener(this);
        d.setCurrent(f);
        
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if(c.equals(exit)){
        this.notifyDestroyed();
        }
    }
}
