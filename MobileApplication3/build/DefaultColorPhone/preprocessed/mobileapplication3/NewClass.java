/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileapplication3;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.TextField;

/**
 *
 * @author Aviator
 */
public  class NewClass implements itemCommandListener
    {
        public TextField tf;
        public Command on=new Command("On",Command.OK,1);
        public Form ff=Midlet.f;
        public  NewClass(){
        tf=new TextField("Name","",34,TextField.ANY);
        tf.setString("yonathaniel");
        tf.addCommand(on);
        ff.append(tf);
        }
        
        public void commandAction(Command c,Item item)
    {
         if(c.equals(on)&&item.equals(tf)){
         tf.setString("Mbogho k yonathaniel");
         }
    }
    }
