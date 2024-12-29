package com.est.employee.performance.BellCurveController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.est.employee.performance.BellCurveService.BellCurveService;
import com.est.employee.performance.model.Category;
import com.est.employee.performance.model.Employee;

@RestController
public class BellCurveController {
	
	private final BellCurveService service;

    public BellCurveController(BellCurveService service) {
        this.service = service;
    }

    @GetMapping("/bellcurve")
    public String analyzeBellCurve() {
        // Standard categories
        List<Category> categories = Arrays.asList(
                new Category("A", 10.0),
                new Category("B", 20.0),
                new Category("C", 40.0),
                new Category("D", 20.0),
                new Category("E", 10.0)
        );

        Map<String, Double> actualPercentages = service.calculateActualPercentages();
        Map<String, Double> deviation = service.calculateDeviation(actualPercentages, categories);
        List<Employee> suggestedRevisions = service.suggestRevisions(deviation);

        return "Actual Percentages: " + actualPercentages + "\n" +
                "Deviation: " + deviation + "\n" +
                "Suggested Revisions: " + suggestedRevisions;
    }

}
