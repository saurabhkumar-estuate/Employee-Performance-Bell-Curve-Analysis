package com.est.employee.performance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.est.employee.performance.BellCurveService.BellCurveService;
import com.est.employee.performance.EmployeeRepository.EmployeeRepository;
import com.est.employee.performance.model.Category;

@SpringBootTest
class EmployeePerformanceApplicationTests {

	private final EmployeeRepository repository = new EmployeeRepository();
    private final BellCurveService service = new BellCurveService(repository);

    @Test
    public void testCalculateActualPercentages() {
        Map<String, Double> percentages = service.calculateActualPercentages();
        assertEquals(20.0, percentages.get("A"));
        assertEquals(13.33, Math.round(percentages.get("B") * 100.0) / 100.0);
    }

    @Test
    public void testCalculateDeviation() {
        Map<String, Double> actual = service.calculateActualPercentages();
        List<Category> categories = Arrays.asList(
                new Category("A", 10.0),
                new Category("B", 20.0),
                new Category("C", 40.0),
                new Category("D", 20.0),
                new Category("E", 10.0)
        );
        Map<String, Double> deviation = service.calculateDeviation(actual, categories);
        assertEquals(10.0, deviation.get("A"));
        assertEquals(-6.67, Math.round(deviation.get("B") * 100.0) / 100.0);
    }
}
