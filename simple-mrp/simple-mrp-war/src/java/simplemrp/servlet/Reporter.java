/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemrp.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.log4j.Logger;
import simplemrp.util.DBConnector;

/**
 *
 * @author Golf
 */
public class Reporter extends HttpServlet {

    public static final String KEY_REPORT_PARAM_MAP = "REPORT_PARAM_MAP";
    public static final String KEY_REPORT_NAME = "REPORT_NAME";

    public static final String PARAM_REPORT_NAME = "reportname";
    
    public static final String REPORT_TYPE_PDF = "PDF";
    public static final String REPORT_TYPE_XLS = "XLS";

    private Logger log = Logger.getLogger(this.getClass());

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();

        try {
            String reportFileName = null;

            Map mapParam = new TreeMap();
            Enumeration enr = request.getParameterNames();

            while(enr.hasMoreElements()) {
                String strParamName = (String)enr.nextElement();
                String strValue = request.getParameterValues(strParamName)[0];

                log.debug(strParamName + ", " + strValue);

                if(strParamName.equals(PARAM_REPORT_NAME)) {
                    reportFileName = strValue;
                } else {
                    mapParam.put(strParamName, strValue);
                }
            }

            File reportFile = new File(getServletContext().getRealPath(reportFileName + ".jasper"));

            if (!reportFile.exists()) {
                throw new Exception("Report file not found");
            }

            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile.getPath());

            generatePDFOutput(response, mapParam, jasperReport);

        } catch(Exception ex) {
            throw new ServletException(ex.getMessage(), ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>



    private void generatePDFOutput(HttpServletResponse resp, Map parameters, JasperReport jasperReport) throws Exception {
        Connection con = DBConnector.getConnection();
        ServletOutputStream ouputStream = resp.getOutputStream();

        try {
            resp.setContentType("application/pdf");
            resp.setHeader("Content-Disposition", "inline; filename=\"report.pdf\"");

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con);

            JRExporter exporter = exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ouputStream);

            exporter.exportReport();

        } catch (Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        } finally {
            con.close();
            ouputStream.close();
        }
    }
}
