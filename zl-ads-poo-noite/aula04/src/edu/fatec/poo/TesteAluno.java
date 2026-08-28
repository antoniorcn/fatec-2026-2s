package edu.fatec.poo;

public class TesteAluno { 
    public static void main(String[] args) { 
        Aluno a1 = new Aluno();
        a1.nome = "Jackson";
        a1.ra = "11111";
        a1.exibir();
        float mediaA1 = a1.calcularMedia(3.0f, 2.0f);

        Aluno a2 = new Aluno();
        a2.nome = "Julia";
        a2.ra = "2222";
        a2.exibir();
        float mediaA2 = a2.calcularMedia(7.0f, 3.0f);

        System.out.printf("%s tirou %f de media e foi %s\n",
        a1.nome, mediaA1, mediaA1 >= 6.0 ? "APROVADO" : "REPROVADO");
        System.out.printf("%s tirou %f de media e foi %s\n",
        a2.nome, mediaA2, mediaA2 >= 6.0 ? "APROVADO" : "REPROVADO");
    }
}