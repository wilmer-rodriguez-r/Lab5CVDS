package edu.eci.cvds.servlet;
import edu.eci.cvds.servlet.model.Todo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;

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
            Integer id = optName.isPresent() && !optName.get().isEmpty() ? Integer.parseInt(optName.get()) : null;
            Todo service = Service.getTodo(id);
            resp.setStatus(HttpServletResponse.SC_OK);
            responseWriter.write(Service.todosToHTMLTable(new ArrayList<Todo>(Arrays.asList(service))));
            responseWriter.flush();
        } catch (NumberFormatException | NullPointerException  e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } catch (FileNotFoundException e) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } catch (MalformedURLException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer responseWriter = resp.getWriter();
        Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
        try {
            Integer id = optName.isPresent() && !optName.get().isEmpty() ? Integer.parseInt(optName.get()) : null;
            Todo service = Service.getTodo(id);
            resp.setStatus(HttpServletResponse.SC_OK);
            responseWriter.write(Service.todosToHTMLTable(new ArrayList<Todo>(Arrays.asList(service))));
            responseWriter.flush();
        } catch (NumberFormatException | NullPointerException  e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } catch (FileNotFoundException e) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } catch (MalformedURLException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}