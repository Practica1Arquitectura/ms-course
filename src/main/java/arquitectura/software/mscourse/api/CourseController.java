package arquitectura.software.mscourse.api;

import arquitectura.software.mscourse.entity.Course;
import arquitectura.software.mscourse.entity.Student;
import arquitectura.software.mscourse.repository.CourseRepository;
import arquitectura.software.mscourse.service.CourseService;
import arquitectura.software.mscourse.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v3/api/course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @RequestMapping(path = "/test",method = RequestMethod.GET)
    public String testCourse(){
        return "Ms-Course";
    }

    @RequestMapping(path = "/save",method = RequestMethod.POST)
    public Course saveCourse(@RequestBody Course course){
        return courseRepository.save(course);
    }

    @RequestMapping(path = "/students",method = RequestMethod.GET)
    public List<Student> getAllStudentByCourse(@RequestParam Integer course) throws Exception{
        return courseService.getAllStudentByCourse(course);
    }

}
