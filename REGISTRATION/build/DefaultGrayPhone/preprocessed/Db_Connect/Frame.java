/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Db_Connect;

import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Graphics;
import student_registration.Midlet;

/**
 *
 * @author Aviator
 */
public class Frame{
     public Form ff=Midlet.form;
    public Frame(Graphics g) {
        g.drawString("Hello World",0,80,10);
         g.drawLine(0,0,20,20);
    }
    
}
