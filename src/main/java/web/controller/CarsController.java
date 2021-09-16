package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarsController {

    private final List<Car> cars = Arrays.asList(
            new Car("BMW",232,(short) 1992),
            new Car("Lada",5454,(short)1994),
            new Car("Ford",4345,(short) 2005),
            new Car("Honda",3435,(short) 2009),
            new Car("Infinity",5454,(short) 2021));

    @Autowired
    private CarService carService;

    @GetMapping
    public String printAllCars(@RequestParam(value = "count", defaultValue = "5") int count, ModelMap model) {
        List<Car> listCars = carService.getCars(cars, count);
        model.addAttribute("listCars",listCars);
        return "cars";
    }
}
