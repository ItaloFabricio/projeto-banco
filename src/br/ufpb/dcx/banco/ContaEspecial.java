/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.dcx.banco;

/**
 *
 * @author danielfelizardo
 */
public class ContaEspecial extends Conta {
  
  private double credito;
  
  public ContaEspecial(
    String cpf,
    String numC, 
    String numAg,
    double saldo,
    double credito
  ) {
		super(cpf, numC, numAg, saldo);
    this.credito = credito;
	}

  @Override
  public double getSaldoDisponivel() {
    return this.credito + super.getSaldo();
  }

  public double getCredito() {
    return credito;
  }

  public void setCredito(double credito) {
    this.credito = credito;
  }
}
