/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package productcomputer;

/**
 *
 * @author simon nzioki
 */
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemCommandListener;
import javax.microedition.lcdui.TextField;

/**
 * @author simon nzioki
 */
public class ComputeProduct implements ItemCommandListener {
    
public TextField value=new TextField("floating values.","",10,TextField.DECIMAL),
               value2=new TextField("Floating values.","",10,TextField.DECIMAL),
               result=new TextField("Product  ","",100,TextField.UNEDITABLE);
public Form f=new Form("Product Calculator");
public Command multiply=new Command("Multiply",Command.ITEM,0);
private Alert empty=new Alert("Empty","Please provide both values.",null,AlertType.ERROR);
private Display screen=Midlet.screen;
    public ComputeProduct()
    {
        value.addCommand(multiply);
        value2.addCommand(multiply);
        value.setItemCommandListener(this);
        value2.setItemCommandListener(this);
    }
    public void commandAction(Command c, Item item) 
    {
     if(item.equals(value)&&c.equals(multiply))
     {
      this.getProduct();
     }
     else if(item.equals(value2)&&c.equals(multiply))
     {
      this.getProduct();
     }
    }
    
    private void getProduct()
    {
     if(!value.getString().equals("")&&!value2.getString().equals(""))
     {
    try
    {
    float v1=Float.parseFloat(value.getString()),
            v2=Float.parseFloat(value2.getString());
    result.setString(""+(v1*v2));
    screen.setCurrentItem(result);
    }
    catch(Exception ex)
   {
       screen.setCurrent(empty);
   }
     }
     else if(value.getString().equals(""))
     {
     screen.setCurrent(empty);
     screen.setCurrentItem(value);
     }
     else if(value2.getString().equals(""))
     {
     screen.setCurrent(empty);
     screen.setCurrentItem(value2);
     }
    }
}

