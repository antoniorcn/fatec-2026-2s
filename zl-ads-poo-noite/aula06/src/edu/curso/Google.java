package edu.curso;

public class Google { 
    Funcionario f1 = new Funcionario("Arquiteto de Sistemas", 26000.00);
    Funcionario f2 = new Funcionario("Engenheiro de Dados", 12000.00);
    Funcionario f3 = new Funcionario("Estagiario", 2300.00);

    FolhaPagamento fp = new FolhaPagamentoNova();


    public void fecharMes() { 
        fp.fazerPagamento( f1 );
        fp.fazerPagamento( f2 );
        fp.fazerPagamento( f3 );
    }
}