package com.thoughtworks.capability.gtb.controller.annotation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 场景三：字段名不一致，在序列化和反序列化时改变字段名
 * 使用@JsonProperty
 *
 * @author itutry
 * @create 2020-05-21_11:31
 */
@RestController
public class FieldsNameMismatchController {

  @GetMapping("/articles/{id}")
  public Article getStudentById(@PathVariable("id") String id) {
    return new Article(id, "论持久战");
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  private static class Article {

    @JsonProperty("articleId")
    private String id;
    @JsonProperty("articleTitle")
    private String title;
  }
}
