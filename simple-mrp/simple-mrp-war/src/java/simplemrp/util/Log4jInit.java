/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.util;

import org.apache.log4j.PropertyConfigurator;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;

/**
 *
 * @author Golf
 */
public class Log4jInit extends HttpServlet {

    @Override
    public void init() {
        String prefix = getServletContext().getRealPath("/");
        String file = getInitParameter("log4j-init-file");
        // if the log4j-init-file is not set, then no point in trying
        if(file != null) {
            PropertyConfigurator.configure(prefix + file);
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) {
    }
}
