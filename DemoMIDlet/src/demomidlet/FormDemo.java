/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demomidlet;

/**
 *
 * @author Aviator
 */
import java.io.IOException;
import javax.microedition.lcdui.*;

public class FormDemo extends Form implements ItemStateListener
{
private Ticker tckr;
private DateField df;
private StringItem str;
private Gauge gauge;
private Spacer spcr;
private TextField txt;
private ChoiceGroup cg;
//private ImageItem imgItem;

public FormDemo(String title){
super(title);

tckr = new Ticker("A ticker, not a control- part of Screen");
df = new DateField("A Date Field control", DateField.DATE_TIME);
str = new StringItem("stritem", "TEXT");
gauge = new Gauge("Volume Gauge", true, 10, 6);

//imgItem = new ImageItem("An Image", Image.createImage("/image.png"), ImageItem.LAYOUT_DEFAULT, "Alternate text");

spcr = new Spacer(0,40);
txt = new TextField("TextField", "Enter Text", 20, TextField.ANY);
cg = new ChoiceGroup("ChoiceGroup", ChoiceGroup.MULTIPLE);
cg.append("Choice 1", null);
cg.append("Choice 2", null);

this.setTicker(tckr);
this.append(df);
this.append(str);
this.append("String Message 2!");
this.append(spcr);
this.append(gauge);
this.append(txt);
this.append(cg);
//this.append(imgItem);

this.setItemStateListener(this);
}

public void itemStateChanged(Item i){
str.setText(i.getLabel()+" has changed");
}
}
