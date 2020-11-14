/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package canvas;

/**
 *
 * @author Aviator
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * @author Aviator
 */
import java.io.IOException;
import javax.microedition.lcdui.*;

public class Convas extends Canvas implements Runnable{
private Thread MainThread;
private long sleep = 50;
private boolean run = true;
private String keyAction = "Key";

private Image img;

private int[] moveShapeLoc = {
this.getWidth()/10,
this.getWidth()/4,
this.getHeight()/8
};
private int[] autoShapeDim = {
this.getWidth()/2,
this.getHeight()/2,
this.getWidth()/10,
this.getHeight()/10,
};

private int direction;
private static int DIRECTIONLEFT = 0;
private static int DIRECTIONRIGHT = 1;


public Convas(){
MainThread = new Thread(this);
try{
img = Image.createImage("/image.png");
}catch(IOException e){}
direction = DIRECTIONRIGHT;
MainThread.start();
}

public void run(){
while(run){
autoShape();
repaint();
try{
Thread.sleep(sleep);
}catch(InterruptedException e){}
}
}

protected void keyPressed(int keyCode){
int gameAction = getGameAction(keyCode);
keyAction = "Key Down: (int)"+keyCode;

if(gameAction == LEFT){
moveShape(-4, 0);
}else if(gameAction == RIGHT){
moveShape(4, 0);
}else if(gameAction == UP){
moveShape(0, -4);
}else if(gameAction == DOWN){
moveShape(0, 4);
}
}
protected void keyReleased(int keyCode){
int gameAction = getGameAction(keyCode);
keyAction = "Key Up: (int)"+keyCode;
}

private void moveShape(int hspeed, int vspeed){
moveShapeLoc[1] += hspeed;
moveShapeLoc[2] += vspeed;
}

private void autoShape(){
if(direction == DIRECTIONLEFT){
if(autoShapeDim[0] > 0){
autoShapeDim[0]--;
}else{
direction++;
}
}else{
if(autoShapeDim[0] + autoShapeDim[2] < this.getWidth()){
autoShapeDim[0]++;
}else{
direction--;
}
}
}

public void paint(Graphics g){
g.setColor(0xFFFFFF);
g.fillRect(0, 0, this.getWidth(), this.getHeight());
g.setColor(0x000000);
g.drawString("CanvasDemo", 1, 1, Graphics.LEFT | Graphics.TOP);
g.drawString(keyAction, 1, 20, Graphics.LEFT | Graphics.TOP);
g.fillRect(autoShapeDim[0], autoShapeDim[1],autoShapeDim[2],autoShapeDim[3]);
g.setColor(0xFF0000);
g.drawArc(moveShapeLoc[1], moveShapeLoc[2], moveShapeLoc[0]*2, moveShapeLoc[0]*2, 0, 360);
g.drawImage(img, this.getWidth()/2, this.getHeight()/2, Graphics.HCENTER | Graphics.VCENTER);
}
}


