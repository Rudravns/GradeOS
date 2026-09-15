
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created so it could be saved 
 * 
 */
public class StudentDatabase implements Serializable {

    private static final long serialVersionUID = 1L;

    //It belongs to this database instance.
    private ArrayList<Student> studentList = new ArrayList<>();

    public ArrayList<Student> toArray() {
        return studentList;
    }

    public Student remove(int index){
        return studentList.remove(index);
    }

    public boolean isEmpty(){
        return studentList.isEmpty();
    }
    
    public void add(Student item){
        studentList.add(item);
    }

    public Student get(int index){
        return studentList.get(index);
    }

    public int size(){
        return studentList.size();
    }
}
