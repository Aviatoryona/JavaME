/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package currencyconvertor;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.midlet.*;

/**
 * @author simon nzioki
 */
public class Midlet extends MIDlet implements CommandListener{
public static Form mum=new Form("Covertor");
private Command exit=new Command("Exit",Command.EXIT,0);
private Display screen=Display.getDisplay(this);
Convertor con=new Convertor();;
    public void startApp() 
    {
     mum.addCommand(exit);
     mum.setCommandListener(this);
     screen.setCurrent(con.mum);
    }
    
    public void pauseApp()
    {
     
    }
    
    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) 
    {
      if(c.equals(exit)&&d.equals(mum))
      {
      this.notifyDestroyed();
      }
    }
}
