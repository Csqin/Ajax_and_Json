package it.cast.test;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.cast.domain.Person;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.*;

public class Tset {

   // @Test
    public  void PersonTest1() throws Exception {
       //设置Pesrson对象的值
        Person p=new Person();
        p.setName("张三");
        p.setAge(21);
        p.setGender("man");
        //Jackson核心对象
        ObjectMapper om=new ObjectMapper();

        //writeValueAsString()方法将对象转为Json字符串；
        String Json  = om.writeValueAsString(p);
        System.out.println(Json);

        /*
            writeValue(参数1，obj)
                            参数1：
                                        File：将obj对象转为Json字符串，并保存到指定的文件中
                                        Writer：将obj对象转为Json字符串，并将其填充到字符输出流中
                                         OutputStream：将obj对象转为Json字符串，并将其填充到字节输出流中
       */
        om.writeValue(new File("C://Users//ShmilyCSQ//Desktop//Others//a.txt"),p);
        om.writeValue(new FileWriter("C://Users//ShmilyCSQ//Desktop//Others//b.txt"),p);
        om.writeValue(new FileOutputStream("C://Users//ShmilyCSQ//Desktop//Others//c.txt"),p);
    }

    //Json注解演示
    //@JsonIgnore
    //@JsonFormat(pattern = "yyyy年MM月dd日")
    //@Test
    public  void PersonTest2() throws Exception {
        //设置Pesrson对象的值
        Person p=new Person();
        p.setName("张三");
        p.setAge(21);
        p.setGender("man");
        p.setBirthday(new Date());

        //Jackson核心对象
        ObjectMapper om=new ObjectMapper();
        String Json  = om.writeValueAsString(p);
        System.out.println(Json);
        //{"name":"张三","age":21,"gender":"man","birthday":1557457176578}
        //@JsonIgnore {"name":"张三","age":21,"gender":"man"}
        //@JsonFormat {"name":"张三","age":21,"gender":"man","birthday":"2019年05月10日"}
    }

    //List集合转Json
    //@Test
    public  void PersonTest3() throws Exception {
        //设置Pesrson对象的值
        Person p=new Person();
        p.setName("张三");
        p.setAge(21);
        p.setGender("man");
        p.setBirthday(new Date());

        Person p1=new Person();
        p1.setName("张三");
        p1.setAge(21);
        p1.setGender("man");
        p1.setBirthday(new Date());

        Person p2=new Person();
        p2.setName("张三");
        p2.setAge(21);
        p2.setGender("man");
        p2.setBirthday(new Date());


        List<Person> list=new ArrayList<Person>();
        list.add(p);
        list.add(p1);
        list.add(p2);
        //Jackson核心对象
        ObjectMapper om=new ObjectMapper();
        String Json  = om.writeValueAsString(list);
        System.out.println(Json);
        //List 是一个数组格式 ：[]
        /*
                [
                    {"name":"张三","age":21,"gender":"man","birthday":"2019年05月10日"},
                    {"name":"张三","age":21,"gender":"man","birthday":"2019年05月10日"},
                    {"name":"张三","age":21,"gender":"man","birthday":"2019年05月10日"}
                ]
        */
    }

//Map转Json
   // @Test
    public  void PersonTest4() throws Exception {

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("name","张三");
        map.put("age",23);
        map.put("gender","男");
        //Jackson核心对象
        ObjectMapper om=new ObjectMapper();
        String Json  = om.writeValueAsString(map);
        System.out.println(Json);
        //{"gender":"男","name":"张三","age":23}
    }

    //Json转对象类
    //@Test
    public  void PersonTest5() throws Exception {

      String json="{\"gender\":\"男\",\"name\":\"张三\",\"age\":23}";
        //Jackson核心对象
        ObjectMapper om=new ObjectMapper();
        Person person = om.readValue(json, Person.class);
        System.out.println(person);
        //Person{name='张三', age=23, gender='男', birthday=null}
    }
}
