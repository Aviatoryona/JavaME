/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package currencyconvertor;
import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemCommandListener;
import javax.microedition.lcdui.TextField;
/**
 *
 * @author simon nzioki
 */
public class Convertor implements ItemCommandListener
{
private TextField value=new TextField("Value in KSh.","",10,TextField.DECIMAL),
        result=new TextField("Value in ","",100,TextField.ANY);
private ChoiceGroup primary=new ChoiceGroup("Primary Currency",Choice.POPUP);
public Form mum=Midlet.mum;
private String[] currs={"Dollar","Rupee","Yen","Euro"};
public Command convert=new Command("Convert",Command.OK,0);
public Convertor()
{
    for(int y=0;y<currs.length;y++)
    {
    primary.append(currs[y],null);
    }
    mum.append(primary);
    value.addCommand(convert);
    value.setItemCommandListener(this);
    mum.append(value);
    mum.append(result);
}

    public void commandAction(Command c,Item item)
    {
     if(c.equals(convert)&&item.equals(value))
     {
     float  vle=0f;
     try
     {
     vle=Float.parseFloat(value.getString());
     }
     catch(Exception ex){}
     if(primary.getString(primary.getSelectedIndex()).equals("Rupee"))
     {
     this.convertRupee(vle);
     }
     else if(primary.getString(primary.getSelectedIndex()).equals("Dollar"))
     {
     this.convertDollar(vle);
     }
      else if(primary.getString(primary.getSelectedIndex()).equals("Euro"))
     {
     this.convertEuro(vle);
     }
      else if(primary.getString(primary.getSelectedIndex()).equals("Yen"))
     {
     this.convertYen(vle);
     }
     }
    }
    private void convertRupee(float f) 
    {
     double t=(f*0.74319);
     result.setString(Double.toString(t)+" Yens");
    }

    private void convertDollar(float f) 
    {
     double t=(f*0.00983);
     result.setString(Double.toString(t)+" Dolars");
    }

    private void convertEuro(float f)
    {
     double t=(f*0.00887);
     result.setString(Double.toString(t)+" Euros");
    }

    private void convertYen(float f)
    {
     double t=(f*1.11898);
     result.setString(Double.toString(t)+" Yens");
    }

}
