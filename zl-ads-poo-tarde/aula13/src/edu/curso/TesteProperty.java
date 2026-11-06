package edu.curso;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;


public class TesteProperty { 

    public void executar() { 
        System.out.println("Inicio do Programa");
        StringProperty nome = new SimpleStringProperty("Joao"); 

        Assinante a1 = new Assinante();
        Assinante a2 = new Assinante();

        nome.addListener( (obs, antigo, novo) -> {
            a1.alterado( antigo, novo );
        });

        nome.set( "Pedro" );
        nome.set( "Alberto" );
        nome.set( "Camila" );
        nome.set( "Ana" );
        nome.set( "João" );
        System.out.println("Fim do Programa");
    }

    public static void main(String[] args) { 
        TesteProperty ts = new TesteProperty();
        ts.executar();
    }

}