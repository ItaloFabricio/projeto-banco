package br.ufpb.dcx.banco;

import java.util.ArrayList;
import java.util.List;

public class ProgramaBanco {
	public static void main(String[] args) {
		SistemaBanco meuBanco = new BancoList("Ayla's Bank", "123/321", 
				new ArrayList<Conta>());
		Conta contaAyla = new ContaSimples("233.333.345-44", "111-1", 
				"222-2", 200.00);
		meuBanco.abrirConta(contaAyla);
		System.out.println(meuBanco.consultarSaldoDisponivelDeConta(
				"111-1", "222-2"));
		meuBanco.sacarDeConta(
				"111-1", "222-2", 200);
		System.out.println(meuBanco.consultarSaldoDisponivelDeConta(
				"111-1", "222-2"));
    Conta contaEspecial = new ContaEspecial("434454-74", "333-9", "44-3", 0, 300);
    meuBanco.abrirConta(contaEspecial);
    
    if (contaEspecial.getSaldoDisponivel()==300) {
      System.out.println("[OK] A conta possui R$ 300,00 de saldo disponível.");
    } else {
      System.out.println("[ERROR] A conta não possui R$ 300,00 de saldo disponível.");
    }
    
    Conta outraContaEspecial = new ContaEspecial("434454-74", "444-5", "44-3", 0, 1000);
    meuBanco.abrirConta(outraContaEspecial);
    
    meuBanco.sacarDeConta("444-5", "44-3", 10);
    double novoSaldoOutraContaEspecial = meuBanco.consultarSaldoDisponivelDeConta("444-5", "44-3");
    System.out.println("[OK] A conta de número 444-5 e na agência 44-3, tem saldo: R$ "+novoSaldoOutraContaEspecial);
    
    List<Conta> contasEncontradas = meuBanco.pesquisarContasDoCliente("434454-74");
    System.out.println("[OK] A quantidade de contas encontradas do CPF 434454-74: "+contasEncontradas.size()+" contas.");
    
	}
}