import java.util.*;
import java.util.stream.Collectors;

class CarDealership {

    private Set<Car> cars = new HashSet<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> findByManufacturer(String manufacturer) {
        return cars.stream()
                .filter(c -> c.getManufacturer().equalsIgnoreCase(manufacturer))
                .collect(Collectors.toList());
    }

    public double averagePriceByType(CarType type) {
        return cars.stream()
                .filter(c -> c.getType() == type)
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);
    }

    public List<Car> sortedByYear() {
        return cars.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public void printStatistics() {
        Map<CarType, Long> stats = cars.stream()
                .collect(Collectors.groupingBy(Car::getType, Collectors.counting()));

        System.out.println("Статистика по типам: " + stats);

        cars.stream().min(Comparator.comparing(Car::getYear))
                .ifPresent(c -> System.out.println("Самая старая: " + c));

        cars.stream().max(Comparator.comparing(Car::getYear))
                .ifPresent(c -> System.out.println("Самая новая: " + c));
    }
}