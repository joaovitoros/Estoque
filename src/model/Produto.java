package model;

public class Produto {
		int codigo;
		String nome;
		Double valor;
		int quantidade;
		public int getQuantidade() {
			return quantidade;
		}

		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}

		public int getCodigo() {
			return codigo;
		}
		
		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}
		
		public String getNome() {
			return nome;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public Double getValor() {
			return valor;
		}
		
		public void setValor(Double valor) {
			this.valor = valor;
		}

}