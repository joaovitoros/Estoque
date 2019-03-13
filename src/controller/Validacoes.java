package controller;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Validacoes {
	//validação se o codigo do produto for igual a 0 ou negativo
	public static int ValCodProduto(JTextField TFCodigoP ,int codigo){
		int cod = codigo;
		while(cod<=0){
			cod = Integer.parseInt(JOptionPane.showInputDialog("Codigo invalido, digite outro: "));
			TFCodigoP.setText(Integer.toString(cod));
		}
		return cod;
	}
	//validação se o nome do produto for igual espaços
	public static String ValNomeProduto(JTextField tFNomeP , String nome){
		String nom = nome;
		while(nom.equals(null) || nom.equals(" ")){
			nom = JOptionPane.showInputDialog("Nome invalido, digite outro: ");
			tFNomeP.setText(nom);
		}
		return nom;
	}
	//validação se o valor do produto for igual a 0 ou negativo
	public static double ValValorProduto(JTextField TFValorP, double valor){
		double val = valor;
		while(val<=0){
			val = Double.parseDouble(JOptionPane.showInputDialog("Valor invalido, digite outro: "));
			TFValorP.setText(Double.toString(val));
		}
		return val;
	}
	//validação se a  quantidade do produto for igual a 0 ou negativo
	public static int ValQTDProduto(JTextField TFQuantidadeP, int quantidade){
		int qtd = quantidade;
		while(qtd<=0){
			qtd = Integer.parseInt(JOptionPane.showInputDialog("Quantidade invalida, digite outra: "));
			TFQuantidadeP.setText(Integer.toString(qtd));
		}
		return qtd;
	}
	//validação se o nome do cliente for igual espaços
	public static String ValNomeCliente(JTextField tFNomeC , String nome){
		String nom = nome;
		while(nom.equals(null) || nom.equals(" ")){
			nom = JOptionPane.showInputDialog("Nome invalido, digite outro: ");
			tFNomeC.setText(nom);
		}
		return nom;
	}
	//validação se o valor da divida do cliente for negativa
	public static double ValValorDCliente(JTextField TFValorC, double valor){
		double val = valor;
		while(val<0){
			val = Double.parseDouble(JOptionPane.showInputDialog("Valor invalido, digite outro: "));
			TFValorC.setText(Double.toString(val));
		}
		return val;
	}
	//validação se o nome do cliente for igual espaços
	public static String ValNomeVenda(JTextField tFNome , String nome){
		String nom = nome;
		while(nom ==" " || nom ==null){
			nom = JOptionPane.showInputDialog("Nome invalido, digite outro: ");
			tFNome.setText(nom);
		}
		return nom;
	}
	//validação se o valor da compra for igual a 0 ou negativo
	public static double ValValorVenda(JTextField TFValor, double valor){
		double val = valor;
		while(val<0){
			val = Double.parseDouble(JOptionPane.showInputDialog("Valor invalido, digite outro: "));
			TFValor.setText(Double.toString(val));
		}
		return val;
	}
}
