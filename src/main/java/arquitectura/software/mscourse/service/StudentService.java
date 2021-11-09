package arquitectura.software.mscourse.service;

import arquitectura.software.mscourse.entity.Course;
import arquitectura.software.mscourse.entity.Student;
import arquitectura.software.mscourse.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@FeignClient(name = "ms-student")
public interface StudentService{

    @RequestMapping(path = "/v1/api/student/all", method = RequestMethod.GET)
    public List<Student> getAllStudent();
}
