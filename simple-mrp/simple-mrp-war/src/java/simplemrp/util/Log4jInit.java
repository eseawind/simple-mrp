/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.util;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.log4j.PropertyConfigurator;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;

/**
 *
 * @author Golf
 */
public class Log4jInit extends HttpServlet {

    @Override
    public void init() {
        initialLog4j();
    }
    private String initialLog4j(){
        String prefix = getServletContext().getRealPath("/");
        String file = getInitParameter("log4j-init-file");
        // if the log4j-init-file is not set, then no point in trying
        if(file != null) {
            System.out.println("log4j-init-file="+prefix+file);
            PropertyConfigurator.configure(prefix + file);
        }
        return prefix+file;
    }
    
    public void processRequest(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
       res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        try {
            String logpath = initialLog4j();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Log4j</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Log4j at " + req.getContextPath () + "</h1>");
            out.println("<h1>Servlet Log4j Path at " + logpath + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
        } finally { 
            out.close();
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        processRequest(req, res);
    }
    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
        processRequest(req, res);
    }
}
