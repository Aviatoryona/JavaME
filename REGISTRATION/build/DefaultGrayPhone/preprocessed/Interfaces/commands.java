/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;
import java.io.IOException;
import javax.microedition.lcdui.*;
import student_registration.Midlet;

/**
 *
 * @author Aviator
 */
public class commands {
    public Form formm=Midlet.form;
    ImageItem pic;
     public commands (){
     formm.addCommand(Intializer.Next);
     formm.addCommand(Intializer.Cancel);
     }
     
     public void next(){
         try{
             formm.append("Image");
           pic = new ImageItem("Yonah says hello",
          Image.createImage("/gal.png"),
          ImageItem.LAYOUT_CENTER|
          ImageItem.LAYOUT_NEWLINE_BEFORE|
          ImageItem.LAYOUT_NEWLINE_AFTER,"gal pic");
          formm.append(pic);
          formm.addCommand(Intializer.Save);
} catch(IOException e) {
formm.append(new StringItem(null,"Cant find gal.png "+e));
}
     }
}
