/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.test;

/**
 *
 * @author Golf
 */
import java.util.Properties;
import javax.naming.InitialContext;

public class ContextFactory {

    public static InitialContext getContext() {
        Properties props = new Properties();
        props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
        props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
        props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");

        props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
        props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");

        System.out.println("=============================================================");
        System.out.println("EJB From " + props.getProperty("org.omg.CORBA.ORBInitialHost"));
        System.out.println("=============================================================");

        try {
            return new InitialContext(props);
        } catch (Exception e) {
            System.out.println("Exception = " + e.getMessage());
            return null;
        }
    }
}
