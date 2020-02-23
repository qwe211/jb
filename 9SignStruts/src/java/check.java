/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class check {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String pass;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    public check(){}
    public String execute(){
        if(name.equals("jc") && pass.equals("786"))
        {
            return "success";
        }
        else
        {
            return "error";
        }
    }
}
