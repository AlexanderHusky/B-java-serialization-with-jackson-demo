package com.thoughtworks.capability.gtb.controller.annotation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 场景一：JSON比JavaBean多字段，在反序列化时忽略未知字段
 * 使用@JsonIgnoreProperties：可以忽略指定字段，也可以忽略本类所有未知字段
 *
 * @author itutry
 * @create 2020-05-21_10:38
 */
@RestController
@Slf4j
public class FieldsMoreController {

  @PostMapping("/cars")
  public void createCar(@RequestBody CarVo car) {
    log.info("create car: {}", car);
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonIgnoreProperties(value = "year")
//  @JsonIgnoreProperties(ignoreUnknown = true)
  private static class CarVo {

    private String color;
    private String type;
  }
}
