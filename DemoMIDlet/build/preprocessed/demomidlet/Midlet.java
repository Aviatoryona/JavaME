/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demomidlet;


/**
 * @author Aviator
 */
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class Midlet extends MIDlet implements CommandListener{
private Display display;

private ListDemo listDemo;
private TextBoxDemo textBoxDemo;
private FormDemo formDemo;
private AlertDemo alertDemo;

private Command exitCmd, menuCmd;

public Midlet(){
display = Display.getDisplay(this);
listDemo = new ListDemo("A List Menu", List.IMPLICIT, new String[]{"TextBox", "Form", "Alert"}, null);
textBoxDemo = new TextBoxDemo("A TextBox", "Stuff inside textBox, 500 char limit, ANY text", 500, TextField.ANY);
formDemo = new FormDemo("A Form");
alertDemo = new AlertDemo("An INFO Alert", "Alert content", null, AlertType.INFO);

exitCmd = new Command("Exit", Command.EXIT, 0);
menuCmd = new Command("Menu", Command.BACK, 1);

}

public void startApp() {
listDemo.addCommand(exitCmd);
listDemo.setCommandListener(this);
textBoxDemo.addCommand(exitCmd);
textBoxDemo.addCommand(menuCmd);
textBoxDemo.setCommandListener(this);
formDemo.addCommand(exitCmd);
formDemo.addCommand(menuCmd);
formDemo.setCommandListener(this);

display.setCurrent(listDemo);
}

public void pauseApp() {}

public void destroyApp(boolean unconditional) {}

private void exit() {
System.gc();
destroyApp(false);
notifyDestroyed();
}

public void commandAction(Command c, Displayable d){
if(c == exitCmd){
exit();
}else if(c == menuCmd){
display.setCurrent(listDemo);
}else if(c == List.SELECT_COMMAND && d == listDemo){
switch(listDemo.getSelectedIndex()){
case 0:
display.setCurrent(textBoxDemo);
break;
case 1:
display.setCurrent(formDemo);
break;
case 2:
display.setCurrent(alertDemo);
break;
default:
break;
}
}
}
}
