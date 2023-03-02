package com.kh.demo1.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/product")
public class TestController {

  @GetMapping("/1")
  public String t1(){
    return "상품";
  }
  @GetMapping("/2")
  public Person t2(){
    Person p = new Person("홍길동", 30);
    return p;
  }
  @GetMapping("/3")
  public ArrayList<Person> t3(){
    ArrayList<Person> persons = new ArrayList<>();
    persons.add(new Person("홍길동1",10));
    persons.add(new Person("홍길동2",20));
    persons.add(new Person("홍길동3",30));
    return persons;
  }


  static class Person{
    String name;
    int age;

    public Person(String name, int age) {
      this.name = name;
      this.age = age;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }

    @Override
    public String toString() {
      return "Person{" +
          "name='" + name + '\'' +
          ", age=" + age +
          '}';
    }
  }
}
