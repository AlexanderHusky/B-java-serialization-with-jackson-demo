package com.thoughtworks.capability.gtb.controller.annotation;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
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
 * 场景四：结构不一致，在序列化时将对象拍平
 * 使用@JsonUnwrapped
 *
 * @author itutry
 * @create 2020-05-21_11:39
 */
@RestController
@Slf4j
public class StructureMismatchController {

  @PostMapping("/employees")
  public void createEmployee(@RequestBody Employee employee) {
    log.info("create employee: {}", employee);
  }

  @GetMapping("/employees/{id}")
  public Employee getStudentById(@PathVariable("id") String id) {
    return new Employee(id, new Name("John", "Doe"));
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  private static class Employee {

    private String id;
    @JsonUnwrapped
    private Name name;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  private static class Name {

    private String firstName;
    private String lastName;
  }
}
