/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import javax.microedition.lcdui.Form;
import student_registration.Midlet;

/**
 *
 * @author Aviator
 */
public class Forms {
    public Form formm=Midlet.form;
    public Forms(){
        formm.append("\tFill ALL Fields press save in MENU ");
        formm.append(Intializer.TName);
        formm.append(Intializer.TReg);
        Initialixer ini=new Initialixer();
         ini.Initialixer();
        formm.append(Intializer.Faculty);
        formm.append(Intializer.TCourse);
        formm.append(Intializer.Yr);
        formm.append(Intializer.Sem);
        formm.append(Intializer.TMail);
        Intializer.TDOA.setString("yyyy/ mm /dd");
        formm.append(Intializer.TDOA);
        formm.append(Intializer.pass);  
        formm.append(Intializer.pass2);
    }
   
    
}
