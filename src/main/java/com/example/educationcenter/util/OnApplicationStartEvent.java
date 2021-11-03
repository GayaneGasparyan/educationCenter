package com.example.educationcenter.util;

import com.example.educationcenter.model.Course;
import com.example.educationcenter.model.User;
import com.example.educationcenter.model.UserType;
import com.example.educationcenter.repository.CourseRepository;
import com.example.educationcenter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OnApplicationStartEvent implements ApplicationListener<ApplicationReadyEvent> {


    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final CourseRepository courseRepository;


    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        if (!userRepository.findByEmail("admin@mail.com").isPresent()) {

            Course course = courseRepository.save(Course.builder()
                    .name("Java course")
                    .duration("java")
                    .build());
            userRepository.save(User.builder()
                    .email("admin@mail.com")
                    .password(passwordEncoder.encode("admin"))
                    .surname("admin")
                    .name("admin")
                    .userType(UserType.ADMIN)
                    .course(course)
                    .build());
        }
    }

}