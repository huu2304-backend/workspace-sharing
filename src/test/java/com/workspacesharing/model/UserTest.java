    package com.workspacesharing.model;
    import com.workspacesharing.enums.Role;
    import jakarta.validation.ConstraintViolation;
    import jakarta.validation.Validation;
    import jakarta.validation.Validator;
    import jakarta.validation.ValidatorFactory;
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;

    import java.util.Set;

    import static org.junit.jupiter.api.Assertions.assertFalse;

    public class UserTest {
        private Validator validator ;
        @BeforeEach
        void setUp(){
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            validator = factory.getValidator();

        }
        @Test
        void whenEmailBlank_thenValidationFails(){
            User user = new User();
            user.setName("Long Thanh Nguyen");
            user.setPassword("Strong@Password123");
            user.setEmail("");
            user.setRole(Role.CUSTOMER);
            Set<ConstraintViolation<User>> violations = validator.validate(user);
            assertFalse(violations.isEmpty());
        }
        @Test
        void whenNameBlank_thenValidationFails(){
            User user = new User();
            user.setName("");
            user.setEmail("huu2342003@gmail.com");
            user.setPassword("Strong@Password123");
            user.setRole(Role.CUSTOMER);
            Set<ConstraintViolation<User>> violations = validator.validate(user);
            assertFalse(violations.isEmpty());
        }
        @Test
        void whenPasswordBlank_thenValidationFails(){
            User user = new User();
            user.setName("Long Thanh Nguyen");
            user.setEmail("huu2342003@gmail.com");
            user.setPassword("");
            user.setRole(Role.CUSTOMER);
            Set<ConstraintViolation<User>> violations = validator.validate(user);
            assertFalse(violations.isEmpty());
        }
        @Test
        void whenRoleBlank_thenValidationFails(){
            User user = new User();
            user.setName("Long Thanh Nguyen");
            user.setPassword("Strong@Password123");
            user.setEmail("huu23420230@gmail.com");
            Set<ConstraintViolation<User>> violations = validator.validate(user);
            assertFalse(violations.isEmpty());
        }
        @Test
        void whenEmailAndNameAndPasswordBlank_thenValidationFails(){
            User user = new User();
            user.setName("");
            user.setPassword("");
            user.setEmail("");
            user.setRole(Role.CUSTOMER);
            Set<ConstraintViolation<User>> violations = validator.validate(user);
            assertFalse(violations.isEmpty());

        }

    }
