/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package productcomputer;

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
    public static Display screen;
    public Form home=new Form("Product");
    private Command exit=new Command("Exit",Command.BACK,0);
    public void startApp()
    {
     screen=Display.getDisplay(this);
     ComputeProduct cpro=new ComputeProduct();
     home.append(cpro.value);
     home.append(cpro.value2);
     home.append(cpro.result);
     home.addCommand(exit);
     home.setCommandListener(this);
     screen.setCurrentItem(cpro.value);
    }
    public void pauseApp()
    {
     
    }
    public void destroyApp(boolean unconditional) 
    {
     if(unconditional)
     {
     this.notifyDestroyed();
     }
    }
    public void commandAction(Command c, Displayable d)
    {
      if(c.equals(exit)&&d.equals(home))
      {
      this.destroyApp(true);
      }
    }
}
