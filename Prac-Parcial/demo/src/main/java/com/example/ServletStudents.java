package com.example;

import com.example.model.Student;
import com.example.service.IStudentService;
import jakarta.servlet.ServletConfig; //Contiene la configuración del servlet.
import jakarta.servlet.ServletException; //Excepción propia de los servlets.
import jakarta.servlet.annotation.WebServlet; //Anotación que le dice la URL a Tomcat de las petaciones que va a responder.
import jakarta.servlet.http.HttpServlet; // Nos da los metodos de doGet y doPost para manejar las peticiones.
import jakarta.servlet.http.HttpServletRequest; //Contiene la información de la petición del cliente.
import jakarta.servlet.http.HttpServletResponse; //Contiene la información de la respuesta que se le va a mandar al cliente.
import java.io.IOException; //Excepción propia de la entrada y salida de datos.

@WebServlet ("/students")
public class ServletStudents extends HttpServlet {
    private IStudentService studentService; //Interfaz que nos permite acceder a los metodos de la capa de servicio.

    @Override
    public void init(ServletConfig config) throws ServletException { //Método que se ejecuta
        studentService = Application.getContext().getBean(IStudentService.class); //Obtiene el bean de la capa de servicio desde el contenedor de Spring.   
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String id = request.getParameter("id");
        if (id != null) {
            Student student = studentService.getStudentById(Integer.parseInt(id));
            if (student != null) {
                response.getWriter().println("<h1>Estudiante encontrado " + id + "</h1>");
                response.getWriter().println("<p>" + student + "</p>");
            } else {
                response.getWriter().println("<h1>Estudiante no encontrado " + id + "</h1>");
            }
        } else {
            response.getWriter().println("<h1>Lista de estudiantes</h1>");
            response.getWriter().println("<ul>");
            for (Student student : studentService.getStudents()) {
                response.getWriter().println("<li>" + student + "</li>");
            }
            response.getWriter().println("</ul>");
        }
    }

    @Override 
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            studentService.deleteStudent(Integer.parseInt(id));
        }
     response.sendRedirect("students");
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String program = request.getParameter("program");
        String courseId = request.getParameter("courseId");

        Student student = new Student(Integer.parseInt(id),code,name,program,Integer.parseInt(courseId));
        studentService.updateStudent(student);
        response.sendRedirect("students");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("_method");

        if ("DELETE".equals(method)) {
            doDelete(request, response);
        } else if ("PUT".equals(method)) {
            doPut(request, response);
        } else {
            int id = Integer.parseInt(request.getParameter("id")); //se lee el valor
            String code = request.getParameter("code"); //se lee el valor del campo name.
            String name = request.getParameter("name"); //se lee el valor del campo name.
            String program = request.getParameter("program"); //se lee el valor del campo name.
            int courseId = Integer.parseInt(request.getParameter("courseId")); //Necesitamos saber en que curso se va a inscribir, courseId es el id del curso al que va pertenecer el estudiante.

            //objetos que no tienen dependencias, son solamente datos entonces eso si los manejo yo y no Spring, Spring maneja los objetos a los cuales se les debe agregar dependencias.
            Student student = new Student( id, code, name, program, courseId);
            studentService.addStudent(student);
            response.sendRedirect("students"); //Esto le dice al navegador que hay un nuevo get en students, así despues de registrar el estudiante, el usuario va a la lista actualizada  con el esstudiante.
        }
    }
}

