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
public class Log_In {
    public Form formm=Midlet.form;
    public  Log_In(){
           formm.append("KINDLY LOG IN");
           formm.append(Intializer.TReg);
           formm.append(Intializer.pass);
           formm.addCommand(Intializer.logIn);
      }
    
}
