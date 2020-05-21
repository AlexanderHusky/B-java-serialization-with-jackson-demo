package com.thoughtworks.capability.gtb.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot中Jackson的使用示例
 *
 * @author itutry
 * @create 2020-05-20_21:27
 */
@RestController
@Slf4j
public class JacksonUsageController {

  // 注入objectMapper
  private final ObjectMapper objectMapper;

  @Autowired
  public JacksonUsageController(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  @PostMapping("/jackson")
  public void jackson() throws JsonProcessingException {
    Student student = new Student("1", "小明");
    // 使用objectMapper序列化
    String json = objectMapper.writeValueAsString(student);
    log.info(json);
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  private static class Student {

    private String id;
    private String name;
  }
}
