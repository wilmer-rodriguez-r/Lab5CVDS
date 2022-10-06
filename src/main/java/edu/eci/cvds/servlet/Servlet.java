package edu.eci.cvds.servlet;
import edu.eci.cvds.servlet.model.Todo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(
        urlPatterns = "/lab5"
)
public class Servlet extends HttpServlet {
    static final long serialVersionUID = 35L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer responseWriter = resp.getWriter();
        Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
        try {
            int id = optName.isPresent() && !optName.get().isEmpty() ? Integer.parseInt(optName.get()) : 0;
            System.out.println("aqui");
            Todo service = Service.getTodo(id);
            System.out.println(service);
            resp.setStatus(HttpServletResponse.SC_OK);
            responseWriter.write(Integer.toString(service.getId()));
            responseWriter.flush();
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } catch (FileNotFoundException e) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }
}