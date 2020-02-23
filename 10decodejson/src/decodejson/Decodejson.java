/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decodejson;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Decodejson 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        String s="{\"Password\":786,\"Class\":14,\"Rollno\":13,\"Name\":\"Amaan\"}";
        Object ol=JSONValue.parse(s);
        JSONObject jsonObj=(JSONObject) ol;
        String name=(String) jsonObj.get("Name");
        int pass=Integer.parseInt((String) jsonObj.get("Password").toString());
        int rollno=Integer.parseInt((String) jsonObj.get("Rollno").toString());
        int Class=Integer.parseInt((String) jsonObj.get("Class").toString());
        System.out.println("Name :"+name);
        System.out.println("Roll no :"+rollno);
        System.out.println("Class :"+Class);
        System.out.println("Password :"+pass);
    }
}