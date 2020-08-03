package com.thoughtworks.capability.gtb.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 枚举序列化成数字的另一种实现
 * 使用自定义序列化器
 */
@RestController
public class CustomSerializationController {

  @GetMapping("/users/{id}")
  public User getUserById(@PathVariable String id) {
    return new User(id, "小红", Gender.FEMALE);
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  private static class User {

    private String id;
    private String name;
    private Gender gender;
  }

  private static enum Gender {
    MALE, FEMALE;
  }
}
