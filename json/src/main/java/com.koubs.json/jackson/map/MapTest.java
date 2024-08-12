package com.koubs.json.jackson.map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.koubs.json.jackson.entity.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author KouBeisi
 * @since 2021/8/20
 */
public class MapTest {

    static final ObjectMapper mapper = new ObjectMapper();

    @BeforeAll
    static void beforeAll() {
        //在反序列化时忽略在 json 中存在但 Java 对象不存在的属性
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //在序列化时日期格式默认为 yyyy-MM-dd'T'HH:mm:ss.SSSZ
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //在序列化时忽略值为 null 的属性
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //忽略值为默认值的属性
        mapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_DEFAULT);
    }

    @Test
    void object() throws JsonProcessingException {

        final Student student = new Student(1L, "李四", 12, 1);

        final ObjectMapper mapper = new ObjectMapper();
        final String string = mapper.writeValueAsString(student);
        System.out.println(string);

        final Student value = mapper.readValue(string, Student.class);
        System.out.println(value.toString());
    }

    @Test
    void arrayToJson() throws JsonProcessingException {
        final Student student1 = new Student(1L, "李四", 12, 1);
        final Student student2 = new Student(2L, "李四", 12, 0);
        final Student student3 = new Student(3L, "李四", 12, 0);

        List<Student> list = Arrays.asList(student1, student2, student3);
        ObjectMapper mapper = new ObjectMapper();
        final String string = mapper.writeValueAsString(list);
        System.out.println(string);

        Student[] list1 = mapper.readValue(string, Student[].class);
        System.out.println(Arrays.toString(list1));

        final List<Student> list2 = mapper.readValue(string, new TypeReference<List<Student>>() {
        });
        System.out.println(list2);
    }
}
