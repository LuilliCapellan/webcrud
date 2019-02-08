import java.util.List;

public interface studentDAO {
    void insert(student e);

    void update(student e);

    void delete(student e);

    List<student> getAll();

    student getByMatricula(int matricula);
}
