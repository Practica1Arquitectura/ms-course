package arquitectura.software.mscourse.api;

import arquitectura.software.mscourse.entity.Course;
import arquitectura.software.mscourse.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v3/api/course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @RequestMapping(path = "/test",method = RequestMethod.GET)
    public String testCourse(){
        return "Ms-Course";
    }

    @RequestMapping(path = "/save",method = RequestMethod.POST)
    public Course saveCourse(@RequestBody Course course){
        return courseRepository.save(course);
    }

}
