package com.thoughtworks.capability.gtb.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 原生Jackson的使用示例
 *
 * @author itutry
 * @create 2020-05-20_20:17
 */
public class JacksonUsageDemo {

  public static void main(String[] args) throws JsonProcessingException {
    Address address1 = new Address("北京", "王府井12号", true);
    Address address2 = new Address("成都", "天府大道55号", false);
    Person person = new Person("张三", 18, Gender.MALE, Arrays.asList(address1, address2));

    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(person);
    System.out.println(json);

    Person result = objectMapper.readValue(json, Person.class);
    System.out.println(result);
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  private static class Person {

    private String name;
    private Integer age;
    private Gender gender;
    private List<Address> addressList;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  private static class Address {

    private String city;
    private String detail;
    private Boolean isPrimary;
  }

  private enum Gender {
    MALE, FEMALE;
  }
}
