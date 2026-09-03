package edu.curso;
public class Passaro extends Animal { 
    public Passaro() {
        super(5.0);
        System.out.println("Construindo novo Passaro...");
    }
    public void voar() { 
        System.out.println("Voando...");
    }
}