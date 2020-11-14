/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import Interfaces.*;
import javax.microedition.lcdui.*;
import student_registration.Midlet;

/**
 *
 * @author Aviator
 */
public class Delete {
    public Form formm= Midlet.form;
    public Display dispp=Midlet.disp; 
    
      public Delete(){
              Alert alt=new Alert("ALERT","\tRISK OF LOOSING DATA!",null,null);     
           alt.setTimeout(2000);
           AlertType.WARNING.playSound(dispp);
           dispp.setCurrent(alt);
                formm.append("\tFill Fields press OK in MENU ");
                formm.append(Intializer.registrationNO);
                formm.append(Intializer.password);
                formm.addCommand(Intializer.Ok);
      }

}
