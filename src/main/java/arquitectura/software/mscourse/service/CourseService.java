package arquitectura.software.mscourse.service;

import arquitectura.software.mscourse.entity.Student;
import arquitectura.software.mscourse.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentService studentService;

    public List<Student> getAllStudentByCourse(Integer course) throws Exception{
        List<Integer> studentsId = courseRepository.getStudentsByCourse(course);
        List<Student> students = studentService.getAllStudent();
        ArrayList<Student> studentIdByCourse = new ArrayList<>();
        for (int i=0;i<studentsId.size();i++){
            for (int j=0;j<students.size();j++){
                if(studentsId.get(i)==students.get(j).getStudentId()){
                    studentIdByCourse.add(students.get(j));
                }
            }
        }
        if(studentIdByCourse!=null){
            return studentIdByCourse;
        }else {
            throw new Exception("No existe ningun estudiante escrito en un curso");
        }
    }

}
