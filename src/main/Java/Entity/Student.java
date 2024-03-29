package Entity;

import java.io.Serializable;
import java.util.Arrays;

public class Student implements Serializable{
    private byte[] uid;

    private String name;

    private Integer age;

    private Integer classid;

    public byte[] getUid() {
        return uid;
    }

    public void setUid(byte[] uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "uid=" + Arrays.toString(uid) +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", classid=" + classid +
                '}';
    }
}
