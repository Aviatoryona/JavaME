
import canvas.Convas;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
public class Midlet extends MIDlet implements CommandListener{
private Display display;
private Convas canvas;
private Command exitCmd;

public Midlet(){
display = Display.getDisplay(this);
canvas = new Convas();
exitCmd = new Command("Exit", Command.EXIT, 0);
}

public void startApp() {
canvas.addCommand(exitCmd);
canvas.setCommandListener(this);

display.setCurrent(canvas);
}

public void pauseApp() { }

public void destroyApp(boolean unconditional) {
}

private void exit() {
System.gc();
destroyApp(false);
notifyDestroyed();
}

public void commandAction(Command c, Displayable d){
if(c == exitCmd){
exit();
}
}
}