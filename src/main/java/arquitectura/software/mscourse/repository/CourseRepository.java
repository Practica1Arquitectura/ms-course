package arquitectura.software.mscourse.repository;

import arquitectura.software.mscourse.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseRepository  extends JpaRepository<Course, Integer> {

    @Query("SELECT e.studentId FROM Course e WHERE e.course = :course")
    List<Integer> getStudentsByCourse(Integer course);

}
