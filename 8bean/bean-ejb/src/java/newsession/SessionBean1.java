/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsession;
import javax.ejb.Stateless;

@Stateless
public class SessionBean1 implements SessionBean1Local {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public int add(int a, int b) {
        return a+b;
    }
    @Override
    public int sub(int a, int b) {
        return a-b;
    }
    @Override
    public int mul(int a, int b) {
        return a*b;
    }
    @Override
    public int div(int a, int b) {
        return a/b;
    }
}
