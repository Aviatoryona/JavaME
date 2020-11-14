/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package student_registration;
import Interfaces.Intializer;
import javax.microedition.lcdui.*;
/**
 *
 * @author Aviator
 */
public class Pass_Reset {
    public Form formm=Midlet.form;
    public Pass_Reset(){
         formm.append("\n\n\n~~~~~~~~~~~~~~~RESET PASSWORD"+"~~~~~~~~~~~~~~~~~~~~");
         formm.append(Intializer.TReg);
         Intializer.pass.setLabel("New Password");
         formm.append(Intializer.pass);
         formm.append(Intializer.pass2);
    }
    
    
}
