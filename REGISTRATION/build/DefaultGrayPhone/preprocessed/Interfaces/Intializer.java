/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.DateField;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;


/**
 *
 * @author Aviator
 */
public interface Intializer {
    public StringItem progress=new StringItem("Progress","");
    public DateField dateF=new DateField("Today",DateField.DATE);
                            // all commands
     public static final Command Exit=new Command("Exit",Command.EXIT,1) ,
          cont=new Command("Continue",Command.OK,0),
          addData=new Command("Add Details",Command.OK,0),
          inputData=new Command("Add",Command.OK,0),
          change=new Command("change",Command.OK,0),
          yes=new Command("Ok",Command.OK,0),
          yess=new Command("Yes",Command.OK,0),
          Save=new Command("Save",Command.OK,0) ,
          Cancel=new Command("Cancel",Command.CANCEL,6) ,
          View=new Command("View",Command.OK,4) ,
          Next=new Command("Next",Command.OK,0) ,
          Edit=new Command("Edit",Command.OK,3) ,
          Ok=new Command("Ok",Command.OK,0),
          Delete=new Command("Delete",Command.OK,5) ,
          back=new Command("Back",Command.OK,1) ,
          logIn=new Command("Log in",Command.OK,0),
          help=new Command("Help",Command.OK,2),
          forget=new Command("Forgot Password",Command.OK,1),
          reset=new Command("Reset",Command.OK,0),
          New=new Command("New",Command.OK,1) ;
     
                     //New form Fields
      public static final TextField TName=new TextField("NAME","",20,TextField.ANY),
              TDOA=new TextField("Date Of Admission","",20,TextField.ANY),
              TCourse=new TextField("Course","",20,TextField.ANY),
              TReg=new TextField("Reg.NO","",20,TextField.ANY),
              TMail=new TextField("Email","",40,TextField.EMAILADDR),
              pass2=new TextField("Re-Type Password","",8,TextField.PASSWORD),
              pass=new TextField("Password","",8,TextField.PASSWORD);
      
      
                     //viewing Details Fields
      public static final TextField Name=new TextField("NAME","",35,TextField.UNEDITABLE),
              DOA=new TextField("Date Of Admission","",35,TextField.UNEDITABLE),
              Course=new TextField("Course","",35,TextField.UNEDITABLE),
              Reg=new TextField("Reg.NO","",20,TextField.UNEDITABLE),
              faculty=new TextField("Faculty","",35,TextField.UNEDITABLE),
              year=new TextField("Year Of Study","",20,TextField.UNEDITABLE),
              sem=new TextField("Year Of Study","",20,TextField.UNEDITABLE),
              //Delete data
              registrationNO=new TextField("Reg.NO","",20,TextField.ANY),
              //Edit
              passwordEdit=new TextField("Password","",8,TextField.PASSWORD),
              NEWITEM=new TextField("New","",40,TextField.ANY),
              password=new TextField("Password","",8,TextField.PASSWORD),   
              Mail=new TextField("Email","",35,TextField.UNEDITABLE);
                        
               
                               // all ChoiceGroups
      public static final ChoiceGroup Yr=new ChoiceGroup("Year Of Study",ChoiceGroup.POPUP),
              Sem=new ChoiceGroup("Semester",ChoiceGroup.POPUP),
                //Edit
              edit=new ChoiceGroup("SELECT ITEM TO EDIT",ChoiceGroup.POPUP),
              Faculty=new ChoiceGroup("Faculty",ChoiceGroup.POPUP);      
}
