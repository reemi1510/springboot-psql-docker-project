package com.project.userprofile.controller.advice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class ControllerAdvisorTest {

    @InjectMocks
    ControllerAdvisor controllerAdvisor;

    @Test
    public void should_handle_duplicate_email_exception() {
        DuplicateEmailException duplicateEmailException = mock(DuplicateEmailException.class);

        ResponseEntity<Object> responseEntity = controllerAdvisor.handleDuplicateEmailException(duplicateEmailException);

        assertThat(HttpStatus.BAD_REQUEST).isEqualTo(responseEntity.getStatusCode());
    }

    @Test
    public void should_handle_null_email_exception() {
        MethodArgumentNotValidException argumentNotValidException = mock(MethodArgumentNotValidException.class);

        ResponseEntity<Object> responseEntity = controllerAdvisor.handleMethodArgumentNotValid(argumentNotValidException, null, null, null);

        assertThat(HttpStatus.BAD_REQUEST).isEqualTo(responseEntity.getStatusCode());
    }
}
