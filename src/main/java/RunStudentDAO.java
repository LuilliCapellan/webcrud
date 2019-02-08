import java.util.List;

public class RunStudentDAO implements studentDAO {
    @Override
    public void insert(student e) {
        studentDB.estudianteList.add(e);
    }

    @Override
    public void update(student e) {
        for (student actual : getAll()) {
            if (actual.getMatricula() == e.getMatricula()) {
                actual.setNombre(e.getNombre());
                actual.setApellido(e.getApellido());
                actual.setTelefono(e.getTelefono());
            }
        }
    }

    @Override
    public void delete(student e) {
        studentDB.estudianteList.remove(e);
    }

    @Override
    public List<student> getAll() {
        return studentDB.estudianteList;
    }

    @Override
    public student getByMatricula(int matricula) {
        for (student estudiante : getAll()) {
            if (estudiante.getMatricula() == matricula) {
                return estudiante;
            }
        }
        return null;
    }
}
