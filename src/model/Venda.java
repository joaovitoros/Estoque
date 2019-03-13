package model;

public class Venda {
	String NomeComprador;
	double Valor;
	String Data;
	public String getNomeComprador() {
		return NomeComprador;
	}
	public void setNomeComprador(String nomeComprador) {
		NomeComprador = nomeComprador;
	}
	public double getValor() {
		return Valor;
	}
	public void setValor(double valor) {
		Valor = valor;
	}
	public String getData() {
		return Data;
	}
	public void setData(String data) {
		Data = data;
	}
}
