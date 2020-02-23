/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
public class Json {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JSONObject obj=new JSONObject();
        obj.put("Userame","Amaan");
        obj.put("Roll_no",new Integer(13));
        obj.put("Class",new Integer(12));
        obj.put("Password",new Integer(786));
        System.out.println(obj);
    }
}
