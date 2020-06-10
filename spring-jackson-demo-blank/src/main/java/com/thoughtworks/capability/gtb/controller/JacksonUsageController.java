package com.thoughtworks.capability.gtb.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot中Jackson的使用示例
 */
@RestController
@Slf4j
public class JacksonUsageController {

  // 注入objectMapper


  @PostMapping("/jackson")
  public void jackson() throws JsonProcessingException {
    Student student = new Student("1", "小明");
    // 使用objectMapper序列化，并输出到日志
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  private static class Student {

    private String id;
    private String name;
  }
}
