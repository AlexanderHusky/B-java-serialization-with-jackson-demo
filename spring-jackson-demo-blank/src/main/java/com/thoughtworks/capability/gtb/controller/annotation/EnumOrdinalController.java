package com.thoughtworks.capability.gtb.controller.annotation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 场景五：JSON中的枚举是数字形式，在序列化时使用枚举的序数值
 * 使用@JsonValue
 *
 * @author itutry
 * @create 2020-05-21_14:03
 */
@RestController
public class EnumOrdinalController {

  @GetMapping("/users/v1/{id}")
  public UserVo getUserById(@PathVariable String id) {
    return new UserVo(id, "小红", Gender.FEMALE);
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  private static class UserVo {

    private String id;
    private String name;
    private Gender gender;
  }

  private static enum Gender {
    MALE, FEMALE;

    public int getOrdinal() {
      return ordinal();
    }
  }
}
