import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
          //1 Задание
//        BankAccount acc1 = new BankAccount("Иван");
//        BankAccount acc2 = new BankAccount("Петр");
//
//        acc1.deposit(1000);
//        acc1.transfer(acc2, 400);
//
//        System.out.println(acc1);
//        System.out.println();
//        System.out.println(acc2);

        //2 Задание
        Random random = new Random();
        int[] years = new int[50];
        int currentYear = 2025;
        int totalAge = 0;

        System.out.println("Машины после 2015 года:");

        for (int i = 0; i < years.length; i++) {
            years[i] = 2000 + random.nextInt(26);

            if (years[i] > 2015) {
                System.out.println("Год выпуска: " + years[i]);
            }

            totalAge += (currentYear - years[i]);
        }

        double averageAge = (double) totalAge / years.length;
        System.out.println("Средний возраст авто: " + averageAge);


        List<String> models = new ArrayList<>();
        models.add("Toyota Camry");
        models.add("BMW X5");
        models.add("Tesla Model S");
        models.add("BMW X5");
        models.add("Audi A6");

        Set<String> uniqueModels = new HashSet<>(models);

        List<String> sortedModels = new ArrayList<>(uniqueModels);
        sortedModels.sort(Comparator.reverseOrder());

        System.out.println("\nОтсортированные модели:");

        for (int i = 0; i < sortedModels.size(); i++) {
            String model = sortedModels.get(i);

            if (model.contains("Tesla")) {
                model = "ELECTRO_CAR";
            }

            System.out.println(model);
        }

        Set<String> finalSet = new HashSet<>(sortedModels);


        Car car1 = new Car("VIN1", "Camry", "Toyota", 2020, 30000, 20000);
        Car car2 = new Car("VIN1", "Camry", "Toyota", 2020, 30000, 20000);
        Car car3 = new Car("VIN2", "X5", "BMW", 2022, 20000, 50000);

        Set<Car> carSet = new HashSet<>();
        carSet.add(car1);
        carSet.add(car2);
        carSet.add(car3);

        System.out.println("\nКоличество машин в HashSet (без дублей): " + carSet.size());

        List<Car> sortedCars = new ArrayList<>(carSet);
        Collections.sort(sortedCars);

        System.out.println("Сортировка по году:");
        sortedCars.forEach(System.out::println);


        List<Car> cars = new ArrayList<>();
        cars.add(new Car("VIN3", "Model S", "Tesla", 2023, 10000, 70000));
        cars.add(new Car("VIN4", "Q7", "Audi", 2018, 60000, 40000));
        cars.add(new Car("VIN5", "X3", "BMW", 2021, 30000, 45000));
        cars.add(new Car("VIN6", "Civic", "Honda", 2019, 40000, 20000));

        System.out.println("\nТоп-3 самых дорогих:");

        cars.stream()
                .filter(c -> c.getMileage() < 50000)
                .sorted(Comparator.comparing(Car::getPrice).reversed())
                .limit(3)
                .forEach(System.out::println);

        double avgMileage = cars.stream()
                .mapToInt(Car::getMileage)
                .average()
                .orElse(0);

        System.out.println("Средний пробег: " + avgMileage);

        Map<String, List<Car>> grouped =
                cars.stream().collect(Collectors.groupingBy(Car::getManufacturer));

        System.out.println("Группировка по производителю:");
        System.out.println(grouped);


        CarDealership dealership = new CarDealership();
        dealership.addCar(new Car("VIN7", "Model X", "Tesla", 2022, 15000, 80000, CarType.ELECTRIC));
        dealership.addCar(new Car("VIN8", "RAV4", "Toyota", 2020, 25000, 30000, CarType.SUV));

        dealership.printStatistics();
    }
}






