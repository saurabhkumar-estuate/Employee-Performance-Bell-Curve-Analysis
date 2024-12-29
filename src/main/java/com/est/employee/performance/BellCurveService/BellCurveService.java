package com.est.employee.performance.BellCurveService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.est.employee.performance.EmployeeRepository.EmployeeRepository;
import com.est.employee.performance.model.Category;
import com.est.employee.performance.model.Employee;



@Service
public class BellCurveService {
	private final EmployeeRepository repository;

    public BellCurveService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Map<String, Double> calculateActualPercentages() {
        List<Employee> employees = repository.findAll();
        long totalEmployees = employees.size();

        Map<String, Long> counts = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCategory, Collectors.counting()));

        Map<String, Double> percentages = new HashMap<>();
        counts.forEach((category, count) -> percentages.put(category, (count * 100.0) / totalEmployees));

        return percentages;
    }

    public Map<String, Double> calculateDeviation(Map<String, Double> actualPercentages, List<Category> standardCategories) {
        Map<String, Double> deviation = new HashMap<>();
        standardCategories.forEach(category -> {
            double actual = actualPercentages.getOrDefault(category.getName(), 0.0);
            double standard = category.getStandardPercentage();
            deviation.put(category.getName(), actual - standard);
        });
        return deviation;
    }

    public List<Employee> suggestRevisions(Map<String, Double> deviation) {
        return repository.findAll().stream()
                .filter(employee -> deviation.get(employee.getCategory()) > 0)
                .collect(Collectors.toList());
    }

}
