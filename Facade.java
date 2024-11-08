class CoffeeGrinder {
    void grind() {
        System.out.println("Moendo os grãos de café...");
    }
}


class CoffeeMachine {
    void brew() {
        System.out.println("Preparando o café...");
    }
}


class MilkSteamer {
    void steam() {
        System.out.println("Aquecendo o leite...");
    }
}


class CafeteriaFacade {
    private final CoffeeGrinder grinder;
    private final CoffeeMachine machine;
    private final MilkSteamer steamer;

    public CafeteriaFacade() {
        this.grinder = new CoffeeGrinder();
        this.machine = new CoffeeMachine();
        this.steamer = new MilkSteamer();
    }

    public void makeCoffee() {
        grinder.grind();
        machine.brew();
    }

    public void makeCappuccino() {
        grinder.grind();
        machine.brew();
        steamer.steam();
        System.out.println("Cappuccino pronto!");
    }
}

public class Main {
    public static void main(String[] args) {
        
        System.out.println("Fazendo café simples...");
        CafeteriaFacade cafeteria = new CafeteriaFacade();
        cafeteria.makeCoffee(); 
        
        
        System.out.println("\nFazendo cappuccino...");
        cafeteria.makeCappuccino(); 
    }
}
