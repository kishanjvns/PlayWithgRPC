package com.tech.kj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Configuration
public class AppConnfig {

    @Bean
    RestTemplate restTemplate(ProtobufHttpMessageConverter hmc) {
        return new RestTemplate(Arrays.asList(hmc));
    }

    @Bean
    ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }

    @Bean
    public CourseRepository createTestCourses() {
        Map<Integer, Training.Course> courses = new HashMap<>();

        Training.Course course1 = Training.Course.newBuilder().setId(1).setCourseName("REST with Spring").addAllStudent(createTestStudents()).build();

        Training.Course course2 = Training.Course.newBuilder().setId(2).setCourseName("Learn Spring Security").addAllStudent(new ArrayList<>()).build();

        courses.put(course1.getId(), course1);
        courses.put(course2.getId(), course2);

        return new CourseRepository(courses);
    }

    private List<Training.Student> createTestStudents() {
        Training.Student.PhoneNumber phone1 = createPhone("123456", Training.Student.PhoneType.MOBILE);
        Training.Student student1 = createStudent(1, "John", "Doe", "john.doe@baeldung.com", Arrays.asList(phone1));

        Training.Student.PhoneNumber phone2 = createPhone("234567", Training.Student.PhoneType.LANDLINE);
        Training.Student student2 = createStudent(2, "Richard", "Roe", "richard.roe@baeldung.com", Arrays.asList(phone2));

        Training.Student.PhoneNumber phone3_1 = createPhone("345678", Training.Student.PhoneType.MOBILE);
        Training.Student.PhoneNumber phone3_2 = createPhone("456789", Training.Student.PhoneType.LANDLINE);
        Training.Student student3 = createStudent(3, "Jane", "Doe", "jane.doe@baeldung.com", Arrays.asList(phone3_1, phone3_2));

        return Arrays.asList(student1, student2, student3);
    }

    private Training.Student createStudent(int id, String firstName, String lastName, String email, List<Training.Student.PhoneNumber> phones) {
        return Training.Student.newBuilder().setId(id).setFirstName(firstName).setLastName(lastName).setEmail(email).addAllPhone(phones).build();
    }

    private Training.Student.PhoneNumber createPhone(String number, Training.Student.PhoneType type) {
        return Training.Student.PhoneNumber.newBuilder().setNumber(number).setType(type).build();
    }
}
