package tn.esprit.devops_project.services;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.dto.OperatorDto;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
 class OperatorServiceImplTest {

    @Mock
    private OperatorRepository operatorRepository;

    @InjectMocks
    private OperatorServiceImpl operatorService;

    @BeforeEach
    void setUp() {
        // Any setup before each test can go here
    }

    @Test
    void retrieveAllOperators_ShouldReturnOperatorList() {
        // Arrange
        when(operatorRepository.findAll()).thenReturn(Collections.singletonList(new Operator()));

        // Act
        List<Operator> result = operatorService.retrieveAllOperators();

        // Assert
        assertFalse(result.isEmpty());
        verify(operatorRepository).findAll();
    }

    @Test
    void addOperator_ShouldReturnNewOperator() {
        // Arrange
        OperatorDto operatorDto = new OperatorDto();
        Operator operator = new Operator();
        when(operatorRepository.save(any(Operator.class))).thenReturn(operator);

        // Act
        Operator result = operatorService.addOperator(operatorDto);

        // Assert
        assertNotNull(result);
        verify(operatorRepository).save(any(Operator.class));
    }

    @Test
    void deleteOperator_ShouldInvokeRepositoryDelete() {
        // Arrange
        Long operatorId = 1L;
        doNothing().when(operatorRepository).deleteById(anyLong());

        // Act
        operatorService.deleteOperator(operatorId);

        // Assert
        verify(operatorRepository).deleteById(operatorId);
    }

    @Test
    void updateOperator_ShouldReturnUpdatedOperator() {
        // Arrange
        OperatorDto operatorDto = new OperatorDto();
        Operator operator = new Operator();
        when(operatorRepository.save(any(Operator.class))).thenReturn(operator);

        // Act
        Operator result = operatorService.updateOperator(operatorDto);

        // Assert
        assertNotNull(result);
        verify(operatorRepository).save(any(Operator.class));
    }

    @Test
    void retrieveOperator_ShouldReturnOperator() {
        // Arrange
        Long operatorId = 1L;
        Operator operator = new Operator();
        when(operatorRepository.findById(operatorId)).thenReturn(Optional.of(operator));

        // Act
        Operator result = operatorService.retrieveOperator(operatorId);

        // Assert
        assertNotNull(result);
        verify(operatorRepository).findById(operatorId);
    }

    // Additional test cases...
}
