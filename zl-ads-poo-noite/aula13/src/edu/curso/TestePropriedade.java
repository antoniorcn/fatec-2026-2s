package edu.curso;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class TestePropriedade { 

    private StringProperty nome = new SimpleStringProperty("");

    public TestePropriedade() { 
        nome.addListener(      
            (obs, valorAntigo, valorNovo) -> {
                System.out.printf("Valor Antigo: %s\tValor Novo: %s\n",
                   valorAntigo, valorNovo);
            }
        );
    }

    public void executar() { 
        nome.set("João");
        nome.set("Pedro");
        nome.set("Maria");
        nome.set("Katia");
    }

    public static void main(String args[]) { 
        System.out.println("Inicio do Programa");
        TestePropriedade tp = new TestePropriedade();
        tp.executar();
        System.out.println("Termino do Programa");
    }

}