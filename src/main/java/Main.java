import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;


public class Main {
    public static void main(String[] args) {

        final Configuration configuration = new Configuration(new Version(2, 3, 21));
        configuration.setClassForTemplateLoading(Main.class, "/");

        studentService student_service = new studentService();

        student_service.insert(new student(20140984, "Luis", "Capellan", "8093770342"));

        get("/", (request, response) -> {
            response.redirect("/home");
            return null;
        });

        get("/home", ((request, response) -> {
            Template home = configuration.getTemplate("templates/home.ftl");
            StringWriter stringWriter = new StringWriter();
            Map<String, Object> params = new HashMap<>();
            params.put("title", "Crud Web");
            params.put("header", "Estudiantes:");
            params.put("insertS", "Ingresar nuevo estudiante");
            params.put("lista", student_service.getAll());
            params.put("tamanio", student_service.getAll().size());
            home.process(params, stringWriter);
            return stringWriter;
        }));


        //Insert
        get("/insert", (request, response) -> {
            return configuration.getTemplate("templates/insertS.ftl");
        });
        post("/listinsert", (request, response) -> {
            StringWriter stringWriter = new StringWriter();
            try {
                String matricula = request.queryParams("matricula");
                String nombre = request.queryParams("nombre");
                String apellido = request.queryParams("apellido");
                String telefono = request.queryParams("telefono");
                student e = new student(Integer.parseInt(matricula), nombre, apellido, telefono);
                student_service.insert(e);
                response.redirect("/");
            } catch (Exception e) {
                e.printStackTrace();
                response.redirect("/insert");
            }
            return stringWriter;
        });


        //Delete
        get("/listdelete/:matricula", (request, response) -> {
            StringWriter stringWriter = new StringWriter();
            int matricula = Integer.parseInt(request.params("matricula"));
            student_service.delete(student_service.getByMatricula(matricula));
            response.redirect("/");
            return stringWriter;
        });


        //Update
        get("/update/:matricula", (request, response) -> {
            Template result = configuration.getTemplate("templates/updateS.ftl");
            StringWriter stringWriter = new StringWriter();
            int matricula = Integer.parseInt(request.params("matricula"));
            return getObject(student_service, result, stringWriter, matricula);
        });

        post("/listupdate", (request, response) -> {
            StringWriter stringWriter = new StringWriter();

            try {
                int matricula = Integer.parseInt(request.queryParams("matricula"));
                student e = student_service.getByMatricula(matricula);

                e.setNombre(request.queryMap().get("nombre").value());
                e.setApellido(request.queryMap().get("apellido").value());
                e.setTelefono(request.queryMap().get("telefono").value());

                student_service.update(e);
                response.redirect("/home");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Student not found");
                response.redirect("/");
            }

            return stringWriter;
        });

        //Show
        get("/check/:matricula", (request, response) -> {
            Template result = configuration.getTemplate("templates/checkEstudiante.ftl");
            StringWriter stringWriter = new StringWriter();

            int matricula = Integer.parseInt(request.params("matricula"));
            student e = student_service.getByMatricula(matricula);
            if(e!=null){
                return getObject(student_service, result, stringWriter, matricula);
            }
            else {
                return stringWriter;
            }
        });
    }

    private static Object getObject(studentService student_service, Template result, StringWriter stringWriter, int matricula) throws TemplateException, IOException {
        Map<String, Object> params = new HashMap<>();
        params.put("actual", student_service.getByMatricula(matricula)!=null?student_service.getByMatricula(matricula):new student());

        result.process(params, stringWriter);
        return stringWriter;
    }

}
