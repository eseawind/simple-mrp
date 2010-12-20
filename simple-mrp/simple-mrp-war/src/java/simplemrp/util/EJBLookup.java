/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.util;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import simplemrp.facade.CoFacadeRemote;
import simplemrp.facade.IcFacadeRemote;
import simplemrp.facade.MaFacadeRemote;
import simplemrp.facade.PoFacadeRemote;
import simplemrp.facade.PpFacadeRemote;

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

    public static Object getEJBInstance(String classname) {
        Object o = null;
        try {

            Context context = new InitialContext();
            o = context.lookup(classname);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return o;
    }

    public static CoFacadeRemote getCoFacade() throws Exception {
        if (ctx == null) {
            initContext();
        }
        return (CoFacadeRemote) ctx.lookup(BindingName.CoFacadeRemote);
    }

    public static PoFacadeRemote getPoFacade() throws Exception {
        if (ctx == null) {
            initContext();
        }
        return (PoFacadeRemote) ctx.lookup(BindingName.PoFacadeRemote);
    }

    public static MaFacadeRemote getMaFacade() throws Exception {
        if (ctx == null) {
            initContext();
        }
        return (MaFacadeRemote) ctx.lookup(BindingName.MaFacadeRemote);
    }

    public static IcFacadeRemote getIcFacade() throws Exception {
        if (ctx == null) {
            initContext();
        }
        return (IcFacadeRemote) ctx.lookup(BindingName.IcFacadeRemote);
    }

    public static PpFacadeRemote getPpFacade() throws Exception {
        if (ctx == null) {
            initContext();
        }
        return (PpFacadeRemote) ctx.lookup(BindingName.PpFacadeRemote);
    }
}
