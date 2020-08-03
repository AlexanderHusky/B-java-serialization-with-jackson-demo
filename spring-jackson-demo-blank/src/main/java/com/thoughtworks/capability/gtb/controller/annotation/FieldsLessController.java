package com.thoughtworks.capability.gtb.controller.annotation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 场景二：JSON比JavaBean少字段，在序列化时忽略多余字段
 * 用@JsonIgnore在字段级别忽略
 * 用@JsonIgnoreType在类级别忽略
 */
@RestController
public class FieldsLessController {

  @GetMapping("/teachers/{id}")
  public Teacher getStudentById(@PathVariable("id") String id) {
    return new Teacher(id, "刘老师", Gender.FEMALE);
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  private static class Teacher {

    private String id;
    private String name;
    private Gender gender;
  }

  private enum Gender {
    MALE, FEMALE;
  }
}
