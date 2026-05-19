import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "compInfoServlet", value = "/compInfo-servlet")
public class CompInfoServlet extends HttpServlet {
    private String message;

    public void init() {

        message = "";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        Runtime runtime = Runtime.getRuntime();

        int cpu = runtime.availableProcessors();
        long ram = runtime.totalMemory();
        String os = System.getProperty("os.name");

        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Computer Info</h2>");
        out.println("<p>CPU Cores: " + cpu + "</p>");
        out.println("<p>RAM: " + ram + " bytes</p>");
        out.println("<p>OS: " + os + "</p>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}