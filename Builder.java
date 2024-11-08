public class Coffeemaker {
    private String coffeeType;
    private String sugar;
    private String milk;

    public void setCoffeeType(String coffeeType) {
        this.coffeeType = coffeeType;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    public void setMilk(String milk) {
        this.milk = milk;
    }

    public void display() {
        System.out.println("Coffee Type: " + coffeeType);
        System.out.println("Sugar: " + sugar);
        System.out.println("Milk: " + milk);
    }
}


public interface CoffeemakerBuilder {
    void buildCoffeeType();
    void addSugar();
    void addMilk();
    Coffeemaker getResult();
}


public class EspressoCoffeemakerBuilder implements CoffeemakerBuilder {
    private Coffeemaker coffeemaker;

    public EspressoCoffeemakerBuilder() {
        this.coffeemaker = new Coffeemaker();
    }

    @Override
    public void buildCoffeeType() {
        coffeemaker.setCoffeeType("Espresso");
    }

    @Override
    public void addSugar() {
        coffeemaker.setSugar("No Sugar");
    }

    @Override
    public void addMilk() {
        coffeemaker.setMilk("No Milk");
    }

    @Override
    public Coffeemaker getResult() {
        return coffeemaker;
    }
}


public class CappuccinoCoffeemakerBuilder implements CoffeemakerBuilder {
    private Coffeemaker coffeemaker;

    public CappuccinoCoffeemakerBuilder() {
        this.coffeemaker = new Coffeemaker();
    }

    @Override
    public void buildCoffeeType() {
        coffeemaker.setCoffeeType("Cappuccino");
    }

    @Override
    public void addSugar() {
        coffeemaker.setSugar("With Sugar");
    }

    @Override
    public void addMilk() {
        coffeemaker.setMilk("With Milk");
    }

    @Override
    public Coffeemaker getResult() {
        return coffeemaker;
    }
}


public class CoffeemakerDirector {
    public Coffeemaker constructCoffeemaker(CoffeemakerBuilder builder) {
        builder.buildCoffeeType();
        builder.addSugar();
        builder.addMilk();
        return builder.getResult();
    }
}


public class Main {
    public static void main(String[] args) {
        CoffeemakerBuilder espressoBuilder = new EspressoCoffeemakerBuilder();
        CoffeemakerDirector director = new CoffeemakerDirector();

        Coffeemaker espresso = director.constructCoffeemaker(espressoBuilder);
        espresso.display(); 

        CoffeemakerBuilder cappuccinoBuilder = new CappuccinoCoffeemakerBuilder();
        Coffeemaker cappuccino = director.constructCoffeemaker(cappuccinoBuilder);
        cappuccino.display(); 
    }
}
