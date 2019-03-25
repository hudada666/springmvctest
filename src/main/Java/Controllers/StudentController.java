package Controllers;

import Entity.Student;
import Service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/Student")
public class StudentController {
    @Autowired
    private IStudentService service;

    @GetMapping("tt")
    public String Get() {
        List<Student> students = service.selectByCondition(new Student());
        String jsonResult = com.alibaba.fastjson.JSON.toJSONString(students);
        return jsonResult;
    }

    @PostMapping("get/username")
    public String getByUsername(String username) {
        System.out.println(username);
        Student student = new Student();
        student.setName(username);
        List<Student> students = service.selectByCondition(student);
        String jsonResult = com.alibaba.fastjson.JSON.toJSONString(students);
        System.out.println(jsonResult);
        return jsonResult;
    }

    //    @PostMapping("get/user")
    @RequestMapping(value = "get/user", method = RequestMethod.POST)
    public Student getByUser(String username, String name, String age, Student student) {
        System.out.println(student);
        Student fromRedis = service.getFromRedis(name, age);
        return fromRedis;
    }

    @RequestMapping(value = "set/user", method = RequestMethod.POST)
    public String setUser(String name, Integer age) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        service.setRedis(student);
        return "success";
    }

    @RequestMapping(value = "get/map", method = RequestMethod.POST)
    public Student getByUser(@RequestBody Map map) {
        System.out.println(map);
//        Student fromRedis = service.getFromRedis(name, age);
        return null;
    }

    @RequestMapping(value = "get/json", method = RequestMethod.POST)
    public Student getJson(@RequestBody Student student) {
        System.out.println(1);
//        Student fromRedis = service.getFromRedis(name, age);
        return null;
    }

}