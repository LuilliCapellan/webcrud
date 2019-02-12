import java.util.List;

public class studentService implements studentDAO {
    private RunStudentDAO runStudentDAO;

    public studentService() {
        runStudentDAO = new RunStudentDAO();
    }

    @Override
    public void insert(student e) {
        runStudentDAO.insert(e);
    }

    @Override
    public void update(student e) {
        runStudentDAO.update(e);
    }

    @Override
    public void delete(student e) {
        runStudentDAO.delete(e);
    }

    @Override
    public List<student> getAll() {
        return  runStudentDAO.getAll();
    }

    @Override
    public student getByMatricula(int matricula) {
        return runStudentDAO.getByMatricula(matricula);
    }
}
