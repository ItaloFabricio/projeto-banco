package br.ufpb.dcx.banco;

import java.util.ArrayList;
import java.util.List;

public interface SistemaBanco {

	public double consultarSaldoDeConta(String numConta, String numAgencia);

	public double consultarSaldoDisponivelDeConta(String numConta, String numAgencia);

	public List<Conta> pesquisarContasDoCliente(String cpfCliente);

	public void transferir(String numContaO, String numAgenciaO, String numContaD, 
			String numAgenciaD, double valor);

	public void abrirConta(Conta novaConta);

	public ArrayList<Conta> pesquisarContasComSaldoNegativo();
	
	public boolean sacarDeConta(String numConta, String numAgencia, double valor);
	
	public boolean depositarConta(String numConta, String numAgencia, double valor);
	
}
