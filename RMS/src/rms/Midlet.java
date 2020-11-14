/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rms;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import javax.microedition.rms.*;

public class Midlet extends MIDlet implements CommandListener{
private Display display;
private Form form;
private StringItem progress;
private Command exitCmd;

public Midlet(){
display = Display.getDisplay(this);
form = new Form("RMS Demo");
progress = new StringItem("Progress:", "");
exitCmd = new Command("Exit", Command.EXIT, 0);
}

public void startApp() {
form.append(progress);
form.addCommand(exitCmd);
form.setCommandListener(this);
rmsDemo();

display.setCurrent(form);
}

public void pauseApp() {
}

public void destroyApp(boolean unconditional) {
}

private void exit(){
System.gc();
destroyApp(false);
notifyDestroyed();
}

public void commandAction(Command c, Displayable d){
if(c == exitCmd){
exit();
}
}

private void rmsDemo(){
progress.setText(progress.getText() + "\n>>Attempting to create RecordStore &#039;RecStore&#039;");
RecordStore rs = null;
String ii="Yonathaniel";
try{
rs = RecordStore.openRecordStore(ii,true,0, true);
progress.setText(progress.getText() + "\n>>Created RecordStore");
progress.setText(progress.getText() + "\n>>Attempting to add records");
String[] records = {
"The first record",
"The second record",
"The third record",
"The fourth record",
};

for(int i = 0; i < records.length; i++){
rs.addRecord(records[i].getBytes(), 0, records[i].length());
}
progress.setText(progress.getText() + "\n>>Added records");
progress.setText(progress.getText() + "\n>>Attempting to read records: ");

for(int i=1;i<=rs.getNumRecords();i++){
 progress.setText(progress.getText() + "\n");   
for(int j = 0; j < rs.getRecord(i).length; j++){
progress.setText(progress.getText() + (char)(rs.getRecord(i)[j]));
}
}
progress.setText(progress.getText() + "\n");
progress.setText(progress.getText() + "\n>>Attempting to edit records");
  String newData ="This is a New Record";
/*for(int i = 1; i <= rs.getNumRecords(); i++){
String newData = records[i-1]+" edited";
rs.setRecord(i, newData.getBytes(), 0, newData.length());
}*/
rs.setRecord(1, newData.getBytes(), 0, newData.length());
progress.setText(progress.getText() + "\n>>Attempting to read new records: ");
for(int i = 1; i <= rs.getNumRecords(); i++){
progress.setText(progress.getText() + "\n");
for(int j = 0; j < rs.getRecord(i).length; j++){
progress.setText(progress.getText() + (char)(rs.getRecord(i)[j]));
}
}
progress.setText(progress.getText() + "\n");
progress.setText(progress.getText() + "\n>>Attempting to delete records");
for(int i = 1; i <= rs.getNumRecords(); i++){
rs.deleteRecord(i);
}
progress.setText(progress.getText() + "\n>>Deleted records");
progress.setText(progress.getText() + "\n>>Attempting to close RecordStore &#039;RecStore&#039;");
rs.closeRecordStore();
progress.setText(progress.getText() + "\n>>RecordStore closed");

progress.setText(progress.getText() + "\n>>Attempting to delete RecordStore &#039;RecStore&#039;");
RecordStore.deleteRecordStore("RecStore");
progress.setText(progress.getText() + "\n>>RecordStore deleted");

}catch(RecordStoreException e){
progress.setText(progress.getText() + "\n>>Fail: "+e.getMessage());
}
}}
