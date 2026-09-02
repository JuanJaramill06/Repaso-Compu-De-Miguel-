package com.example;

import com.example.model.Course;
import com.example.service.ICourseService;
import jakarta.servlet.ServletConfig; //Contiene la configuración del servlet.
import jakarta.servlet.ServletException; //Excepción propia de los servlets.
import jakarta.servlet.annotation.WebServlet; //Anotación que le dice la URL a Tomcat de las petaciones que va a responder.
import jakarta.servlet.http.HttpServlet; // Nos da los metodos de doGet y doPost para manejar las peticiones.
import jakarta.servlet.http.HttpServletRequest; //Contiene la información de la petición del cliente.
import jakarta.servlet.http.HttpServletResponse; //Contiene la información de la respuesta que se le va a mandar al cliente.
import java.io.IOException; //Excepción propia de la entrada y salida de datos.

@WebServlet("/courses") //Anotación que le dice la URL a Tomcat de las petaciones que va a responder.
public class ServletCourses extends HttpServlet {
    private ICourseService courseService; //Interfaz que nos permite acceder a los metodos de la capa de servicio.

    @Override
    public void init(ServletConfig config) throws ServletException { //Método que se ejecuta cuando se crea el servlet, se usa para inicializar el servlet.
        courseService = Application.getContext().getBean(ICourseService.class); //Obtiene el bean de la capa de servicio desde el contenedor de Spring.
    }

    @Override
    //Protected solo puede ser llamado en la clase misma y sus subclases. Se pone asi porque solo Tomcat puede llamarlo.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //Método que se ejecuta cuando se recibe una petición GET, devolver la lista de cursos.
        response.setContentType("text/html"); //define el tipo de contenido de la respuesta.
        String id = request.getParameter("id"); //lee el valor del parámetro id de la petición.
        if (id != null) { //si el id no es nulo, entonces se
            Course course = courseService.getCourseById(Integer.parseInt(id)); //obtiene el curso con ese id, se convierte el id de String a int porque en el formulario todo llega como texto.
            if (course != null) { //si el curso no es nulo, entonces se
                response.getWriter().println("<h1>Curso encontrado " + id + "</h1>"); //Escribe en la respuesta el título del curso con ese id.
                response.getWriter().println("<p>" + course + "</p>"); //Escribe en la respuesta el curso con ese id.
            } else {
                response.getWriter().println("<h1>Curso no encontrado " + id + "</h1>"); //Escribe en la respuesta que no se encontró un curso con ese id.
            }
        } else {
            response.getWriter().println("<h1>Lista de cursos</h1>"); //Escribe en la respuesta el título de la lista de cursos.
            response.getWriter().println("<ul>"); 
            for (Course course : courseService.getAllCourses()) {
                response.getWriter().println("<li>" + course + "</li>"); //Escribe en la respuesta cada curso de la lista de cursos.
            }
            response.getWriter().println("</ul>"); //Escribe en la respuesta un enlace para agregar un curso.
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            courseService.deleteCourse(Integer.parseInt(id));
            response.getWriter().println("Curso eliminado" + id);
        }else {
            response.getWriter().println("No se puede eliminar el curso, id nulo");
        }
        response.sendRedirect("courses");
    }

    @Override 
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id")); //se lee el valor del campo id, luego se convierte el id de String a int porque en el formulario todo llega como texto.
        String name = request.getParameter("name"); //se lee el valor del campo name.
        String professorName = request.getParameter("professorName"); //se lee el valor del campo professorName.
        String schedule = request.getParameter("schedule"); //se lee el valor del campo schedule.

        Course course = new Course (id, name, professorName, schedule); //se crea un objeto Course con los valores leidos del formulario, yo creo los modelos.
        courseService.updateCourse(course);
        response.sendRedirect("courses"); //Esto le dice al navegador que hay un nuevo get en courses, así despues de registrar el curso, el usuario va a la lista actualizada  con el curso.
    }

    @Override 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,  IOException {
        String method = request.getParameter("_method");

        if ("DELETE".equals(method)) {
            doDelete(request, response);
        } else if ("PUT".equals(method)) {
            doPut(request, response);
        } else {
       
            int id = Integer.parseInt(request.getParameter("id")); //se lee el valor del campo id, luego se convierte el id de String a int porque en el formulario todo llega como texto.
            String name = request.getParameter("name"); //se lee el valor del campo name.
            String professorName = request.getParameter("professorName"); //se lee el valor del campo professorName.
            String schedule = request.getParameter("schedule"); //se lee el valor del campo schedule.

            Course course = new Course (id, name, professorName, schedule); //se crea un objeto Course con los valores leidos del formulario, yo creo los modelos.
            courseService.addCourse(course);
            response.sendRedirect("courses"); //Esto le dice al navegador que hay un nuevo get en courses, así despues de registrar el curso, el usuario va a la lista actualizada  con el curso.
        }
    } 
}
