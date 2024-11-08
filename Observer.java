import java.util.ArrayList;
import java.util.List;


interface Observer {
    void atualizar(String estado);
}


class StatusCafeteria {
    private List<Observer> observers = new ArrayList<>();
    private String estado;

    
    void adicionarObserver(Observer observer) {
        observers.add(observer);
    }

    
    void removerObserver(Observer observer) {
        observers.remove(observer);
    }

        void setEstado(String novoEstado) {
        this.estado = novoEstado;
        notificarObservers();
    }

        private void notificarObservers() {
        for (Observer observer : observers) {
            observer.atualizar(estado);
        }
    }
}

class DisplayCafeteria implements Observer {
    private String nome;

    DisplayCafeteria(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String estado) {
        System.out.println(nome + " atualizado com o status: " + estado);
    }
}


public class Main {
    public static void main(String[] args) {
	StatusCafeteria statusCafeteria = new StatusCafeteria();

        
        DisplayCafeteria display1 = new DisplayCafeteria("Display 1");
        DisplayCafeteria display2 = new DisplayCafeteria("Display 2");

        
        statusCafeteria.adicionarObserver(display1);
        statusCafeteria.adicionarObserver(display2);

        
        statusCafeteria.setEstado("Preparando Café");
        statusCafeteria.setEstado("Aquecendo Leite");
        statusCafeteria.setEstado("Preparando Cappuccino");
        statusCafeteria.setEstado("Café Pronto");
    }
}


