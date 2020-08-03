package com.thoughtworks.capability.gtb.controller;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 枚举序列化成数字的另一种实现
 * 使用自定义序列化器
 *
 * @author itutry
 * @create 2020-05-20_17:29
 */
@RestController
public class CustomSerializationController {

  @GetMapping("/users/v2/{id}")
  public User getUserById(@PathVariable String id) {
    return new User(id, "小红", Gender.FEMALE);
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  private static class User {

    private String id;
    private String name;
    @JsonSerialize(using = GenderSerializer.class)
    private Gender gender;
  }

  private static enum Gender {
    MALE, FEMALE;
  }

  private static class GenderSerializer extends StdSerializer<Gender> {

    protected GenderSerializer() {
      super(Gender.class);
    }

    @Override
    public void serialize(Gender value, JsonGenerator gen, SerializerProvider provider)
        throws IOException {
      gen.writeNumber(value.ordinal());
    }
  }
}
