/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplemrp.util;

import java.util.Properties;
import javax.naming.InitialContext;
import simplemrp.facade.CoFacadeRemote;

/**
 *
 * @author Golf
 */
public class EJBLookup {
    private static InitialContext ctx;

    public static void initContext() throws Exception {
        Properties props = new Properties();
        props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
        props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
        props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
        props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
        props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");

        try {
            ctx = new InitialContext(props);
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    public static CoFacadeRemote getCoFacade() throws Exception {
        if(ctx == null) {
            initContext();
        }
        return (CoFacadeRemote) ctx.lookup(BindingName.CoFacadeRemote);
    }
}