package com.poly.controler;


import com.poly.jpa.dao.StudentDao;
import com.poly.jpa.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api")
public class StudentRestApiController {

    @Autowired
    StudentDao studentDao;

    @GetMapping("getstudent")
    public List<Student> getstuden(){
        return studentDao.findAll();
    }

    @GetMapping("getstudent/{email}")
    public Student getemail(@PathVariable("email") String email){
        return studentDao.getEmail(email);
    }

    @PostMapping("createstudent")
    public Student createsudent(@RequestBody Student student){
        studentDao.save(student);
        return student;
    }

    @PutMapping("updatestudent")
    public Student put(@RequestBody Student student){
        Student s = studentDao.getEmail(student.getEmail());
        if(s != null){
            student.setId(s.getId());
            studentDao.save(student);
        }
        return student;
    }

    @DeleteMapping("deletestudent/{email}")
    public void delete(@PathVariable("email") String email){
        Student student = studentDao.getEmail(email);
        studentDao.delete(student);
    }

}
