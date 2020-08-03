package com.thoughtworks.capability.gtb.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring MVC默认使用Jackson的示例
 */
@RestController
@Slf4j
public class DemoController {

  // @RequestBody接收对象时自动用Jackson反序列化
  @PostMapping("/students")
  public void createStudent(@RequestBody Student student) {
    log.info("create student: {}", student);
  }

  // 返回对象时自动用Jackson序列化
  @GetMapping("/students/{id}")
  public Student getStudentById(@PathVariable("id") String id) {
    return new Student(id, "小红");
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  private static class Student {

    private String id;
    private String name;
  }
}
