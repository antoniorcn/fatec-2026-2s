package edu.curso;
public class Animal { 
    double peso;
    public Animal(double peso) {
        super(); 
        this.peso = peso;
        System.out.println("Criando um novo Animal...");
    }
    public Animal() {
        this( 1.0 );
    }

    public void comer() { 
        System.out.println("Comendo ...");
        peso += 1.0;
    }
}