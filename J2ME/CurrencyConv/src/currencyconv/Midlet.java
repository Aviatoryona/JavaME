/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package currencyconv;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.*;

/**
 * @author simon nzioki
 */
public class Midlet extends MIDlet implements CommandListener{
        private Form fom=new Form("CURRENCY"); 
        private Command Exit=new Command("Exit",Command.EXIT,0);
        private Command convert=new Command("Convert",Command.EXIT,0);
        private Display disp=Display.getDisplay(this);
        private TextField txt,txt1,txt2;
        
        public int Convert(){
            
        return 0;
        }
    public void startApp() {
        fom.addCommand(Exit);
        fom.
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
