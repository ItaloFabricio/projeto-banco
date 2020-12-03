package br.ufpb.dcx.banco;

import java.util.ArrayList;
import java.util.List;

public class BancoList implements SistemaBanco{
	private String nome;
	private String cnpj;
	private ArrayList<Conta> contas;

	public BancoList(String nome, String cnpj, 
			ArrayList<Conta> contas) {
		this.setNome(nome);
		this.setCnpj(cnpj);
		this.contas = contas;
	}
	
	@Override
	public ArrayList<Conta> pesquisarContasComSaldoNegativo(){
		ArrayList<Conta> contasNeg = new ArrayList<Conta>();
		for (Conta c: this.contas) {
			if (c.getSaldo()<0) {
				contasNeg.add(c);
			}
		}
		return contasNeg;
	}
	

	@Override
	public void abrirConta(Conta novaConta) {
		this.contas.add(novaConta);
	}
	
	@Override
	public void transferir(String numContaO, String numAgenciaO, String numContaD, String numAgenciaD, double valor) {
		Conta contaO = null;
		Conta contaD = null;
		for (Conta c: this.contas) {
			if (c.getNumeroAgencia().equals(numAgenciaO) && c.getNumeroConta().equals(numContaO)){
				contaO = c;
			}
			if (c.getNumeroAgencia().equals(numAgenciaD) && c.getNumeroConta().equals(numContaD)){
				contaD = c;
			}
		}
		if (contaO!=null && contaD!=null) {
			contaO.debitar(valor);
			contaD.creditar(valor);
		}
		
	}
	
	@Override
	public List<Conta> pesquisarContasDoCliente(String cpfCliente){
		List<Conta> contasEncontradas = new ArrayList<Conta>();

    for (Conta conta: this.contas) {
      if (conta.getCpfTitular().equals(cpfCliente)) {
        contasEncontradas.add(conta);
      }
    }

		return contasEncontradas;
	}
	
	
	@Override
	public double consultarSaldoDisponivelDeConta(String numConta, String numAgencia) {
		for (Conta c : this.contas) {
			if (c.getNumeroConta().equals(numConta) 
					&& c.getNumeroAgencia().equals(numAgencia)) {
				return c.getSaldoDisponivel();
			}
		}
    return 0.0;
	}
	
	
	@Override
	public double consultarSaldoDeConta(String numConta, String numAgencia) {
		double saldo = 0;
		for (Conta c : this.contas) {
			if (c.getNumeroConta().equals(numConta) 
					&& c.getNumeroAgencia().equals(numAgencia)) {
				saldo = c.getSaldo();
			}
		}
		return saldo;
	}// ...

	@Override
	public boolean sacarDeConta(String numConta, String numAgencia, double valor) {
		for (Conta c: this.contas) {
			if (c.getNumeroAgencia().equals(numAgencia) && c.getNumeroConta().equals(numConta)){
				c.debitar(valor);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean depositarConta(String numConta, String numAgencia, double valor) {
		for (Conta c: this.contas) {
			if (c.getNumeroAgencia().equals(numAgencia) && c.getNumeroConta().equals(numConta)){
				c.creditar(valor);
				return true;
			}
		}
		return false;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
