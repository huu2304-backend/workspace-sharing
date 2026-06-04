package com.workspacesharing.model;

import com.workspacesharing.enums.WorkspaceStatus;
import com.workspacesharing.enums.WorkspaceType;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WorkspaceTest {
    private Validator validator;
    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    public void whenAllFieldsAreValid_thenNoViolations() {
        Workspace workspace = new Workspace();
        workspace.setName("Valid Workspace Name");
        workspace.setDescription("Valid Workspace Description");
        workspace.setCapacity(10);
        workspace.setStatus(WorkspaceStatus.available);
        workspace.setType(WorkspaceType.hot_desk);
        workspace.setPrice(new BigDecimal("15000"));
        Set<ConstraintViolation<Workspace>> violations = validator.validate(workspace);
        violations.forEach(v -> System.out.println("👉 Thiếu hoặc sai ở trường: [" + v.getPropertyPath() + "] - Lý do: " + v.getMessage()));
        assertTrue(violations.isEmpty(), "Workspace hợp lệ thì không được có lỗi validation");
    }
}
