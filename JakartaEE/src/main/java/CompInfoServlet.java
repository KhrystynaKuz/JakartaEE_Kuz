import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;

@WebServlet(name = "compInfoServlet", value = "/compInfo-servlet")
public class CompInfoServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        SystemInfo si = new SystemInfo();

        int cpuCores = si.getHardware().getProcessor().getLogicalProcessorCount();

        GlobalMemory memory = si.getHardware().getMemory();
        long totalRAM = memory.getTotal();
        long availableRAM = memory.getAvailable();

        String os = System.getProperty("os.name");

        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Computer Info</h2>");
        out.println("<p>CPU Cores: " + cpuCores + "</p>");
        out.println("<p>Total RAM: " + totalRAM + " bytes</p>");
        out.println("<p>Available RAM: " + availableRAM + " bytes</p>");
        out.println("<p>OS: " + os + "</p>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}