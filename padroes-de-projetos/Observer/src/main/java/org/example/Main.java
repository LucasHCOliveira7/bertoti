package org.example;

public class Main {
    public static void main(String[] args) {
        // Criando o subject (sujeito)
        ConcreteSubject subject = new ConcreteSubject();

        // Criando observers (observadores)
        Observer observer1 = new ConcreteObserver("Observer 1");
        Observer observer2 = new ConcreteObserver("Observer 2");
        Observer observer3 = new ConcreteObserver("Observer 3");

        // Registrando os observers no subject
        subject.registerObserver(observer1);
        subject.registerObserver(observer2);
        subject.registerObserver(observer3);

        // Mudando o estado do subject e notificando os observers
        subject.setMessage("First Message");
        subject.setMessage("Second Message");

        // Removendo um observer e enviando uma nova notificação
        subject.removeObserver(observer1);
        subject.setMessage("Third Message");
    }
}