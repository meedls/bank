import java.util.Objects;

class Car implements Comparable<Car> {

    private String vin;
    private String model;
    private String manufacturer;
    private int year;
    private int mileage;
    private double price;
    private CarType type;

    public Car(String vin, String model, String manufacturer, int year, int mileage, double price) {
        this(vin, model, manufacturer, year, mileage, price, CarType.SEDAN);
    }

    public Car(String vin, String model, String manufacturer, int year, int mileage, double price, CarType type) {
        this.vin = vin;
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
        this.type = type;
    }

    public String getManufacturer() { return manufacturer; }
    public int getMileage() { return mileage; }
    public double getPrice() { return price; }
    public int getYear() { return year; }
    public CarType getType() { return type; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(vin, car.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vin);
    }

    @Override
    public int compareTo(Car other) {
        return other.year - this.year;
    }

    @Override
    public String toString() {
        return manufacturer + " " + model + " (" + year + ") - $" + price;
    }
}