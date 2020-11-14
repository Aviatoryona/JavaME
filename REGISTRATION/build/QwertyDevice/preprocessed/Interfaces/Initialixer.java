/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author Aviator
 */
public class Initialixer {
     public void Initialixer(){
           String values[]={"Faculty Of Education","Faculty Of Information Science & Technology","Faculty Of Law"
           ,"Faculty Of Business & Statistics","Faculty Of Health Sciences","Faculty Of Pure And Applied Sciences"};    
           for(int i=0;i<values.length;i++){
           Intializer.Faculty.append(values[i], null);   
              }
           
           String yr[]={"4","3","2","1"};
           for(int i=0;i<yr.length;i++){
           Intializer.Yr.append(yr[i], null);   
              }
           
           String sem[]={"2","1"};
           for(int i=0;i<sem.length;i++){
           Intializer.Sem.append(sem[i], null);   
              }
                           //1       3        4           5             6          7                 8
           String edit[]={"Name","Faculty","Course","Year Of Study","Semester","EMail Address","Date Of Admission"};
           for(int i=0;i<edit.length;i++){
           Intializer.edit.append(edit[i], null);   
              }
     }
}
