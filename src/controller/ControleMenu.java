package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import conexão.connect;
import model.Cliente;
import model.Produto;
import model.Venda;

public class ControleMenu implements ActionListener {

	private JTextField TFCodigoP;
	private JTextField TFNomeP;
	private JTextField TFValorP;
	private JTextField TFQuantidadeP;
	private JTextField TFNomeC;
	private JTextField TFValorC;
	private JTextField TFNome;
	private JTextField TFValor;
	private JTextField TFData;

	
	//Construtor da classe COntroleMenu
	public ControleMenu(JTextField TFCodigoP, JTextField tFNomeP2,
			JTextField TFValorP, JTextField TFQuantidadeP, JTextField tFNomeC2,
			JTextField TFValorC, JTextField tFNome2, JTextField TFValor,
			JTextField TFData) {
		this.TFCodigoP = TFCodigoP;
		this.TFNomeP = tFNomeP2;
		this.TFValorP = TFValorP;
		this.TFQuantidadeP = TFQuantidadeP;
		this.TFNomeC = tFNomeC2;
		this.TFValorC = TFValorC;
		this.TFNome = tFNome2;
		this.TFValor = TFValor;
		this.TFData = TFData;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//passando para um String o id dos botoes
		String cmd = e.getActionCommand();
		// conexão com banco de dados
		connect c = new connect();
		c.conectar();
		if ("Cadastrar Produto".equals(cmd)) {
			// Atribuindo ao botão Bcadastrar a função de enviar os dados do
			// usuario para o cadastro de novos produtos

			Produto produto = new Produto();

			produto.setCodigo(Integer.parseInt(TFCodigoP.getText()));
			produto.setCodigo(Validacoes.ValCodProduto(TFCodigoP,
					produto.getCodigo()));

			produto.setNome(TFNomeP.getText());
			produto.setNome(Validacoes.ValNomeProduto(TFNomeP,
					produto.getNome()));

			produto.setValor(Double.parseDouble(TFValorP.getText()));
			produto.setValor(Validacoes.ValValorProduto(TFValorP,
					produto.getValor()));

			produto.setQuantidade(Integer.parseInt(TFQuantidadeP.getText()));
			produto.setQuantidade(Validacoes.ValQTDProduto(TFQuantidadeP,
					produto.getQuantidade()));

			try {
				String sql = "insert into produto (cod, nome, valor, quantidade) values (?,?,?,?)";
				PreparedStatement pst = c.conexao.prepareStatement(sql);
				pst.setInt(1, produto.getCodigo());
				pst.setString(2, produto.getNome());
				pst.setDouble(3, produto.getValor());
				pst.setInt(4, produto.getQuantidade());
				pst.execute();
				pst.close();
				JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
			} catch (SQLException e1) {
				//se o nome de produto que foi solicitado para cadastrar já houver um cadastro associado é 
				//solicitado ao usuario se ele quer atualizar este cadastro
				int i = Integer.parseInt(JOptionPane.showInputDialog(null,
						"ERROR: Gravação de produto não concluida!\n"
								+ "Deseja atualizar o produto?\n" 
								+ "1 - sim\n"
								+ "2 - não\n"));
				if (i == 1) {
					try {
						String sql = "update produto set cod = ?, valor = ?, quantidade = ? where nome = ?";
						PreparedStatement pst = c.conexao.prepareStatement(sql);
						produto.setCodigo(Integer.parseInt(TFCodigoP.getText()));
						produto.setCodigo(Validacoes.ValCodProduto(TFCodigoP,
								produto.getCodigo()));

						produto.setValor(Double.parseDouble(TFValorP.getText()));
						produto.setValor(Validacoes.ValValorProduto(TFValorP,
								produto.getValor()));

						produto.setQuantidade(Integer.parseInt(TFQuantidadeP
								.getText()));
						produto.setQuantidade(Validacoes.ValQTDProduto(
								TFQuantidadeP, produto.getQuantidade()));

						pst.setInt(1, produto.getCodigo());
						pst.setDouble(2, produto.getValor());
						pst.setInt(3, produto.getQuantidade());
						pst.setString(4, produto.getNome());
						pst.execute();
						pst.close();
						JOptionPane.showMessageDialog(null,
								"Atualizado com sucesso!");
					} catch (SQLException ee) {
						JOptionPane.showMessageDialog(null,
								"Erro durante Alteração!");
					}
				}
				e1.printStackTrace();
			}

			TFCodigoP.setText("");
			TFNomeP.setText("");
			TFValorP.setText("");
			TFQuantidadeP.setText("");

		} else if ("Pesquisar Produto".equals(cmd)) {
			// Atribuindo ao botão Bpesquisar a função de pesquisar por produtos
			// cadastrados

			String nome = JOptionPane
					.showInputDialog("Digite o nome do produto que deseja buscar: ");
			try {
				String sql = "select * from produto where nome = ?";
				PreparedStatement pst = c.conexao.prepareStatement(sql);
				pst.setString(1, nome);
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					TFCodigoP.setText(Integer.toString(rs.getInt("cod")));
					TFNomeP.setText(rs.getString("nome"));
					TFValorP.setText(Double.toString(rs.getDouble("valor")));
					TFQuantidadeP.setText(Integer.toString(rs
							.getInt("quantidade")));
				}
				pst.execute();
				pst.close();
			} catch (SQLException e2) {
				JOptionPane.showMessageDialog(null,
						"ERRO: Pesquisa não concluida!");
				e2.printStackTrace();
			}
		} else if ("Excluir Produto".equals(cmd)) {
			// Atribuindo ao botão Bapagar a função de apagar registros de
			// produtos

			String nome = JOptionPane
					.showInputDialog("Digite o nome do produto que deseja apagar o cadastro: ");
			try {
				String sql = "delete produto where nome = ?";
				PreparedStatement pst = c.conexao.prepareStatement(sql);
				pst.setString(1, nome);
				pst.execute();
				pst.close();
				JOptionPane.showMessageDialog(null,
						"Produto deletado com sucesso!");
			} catch (SQLException e3) {
				JOptionPane
						.showMessageDialog(
								null,
								"ERROR: Exclusão não concluida adequadamente. "
										+ "Provavelmente o produto solicitado não tivesse um cadastro!");
				e3.printStackTrace();
			}
			TFCodigoP.setText("");
			TFNomeP.setText("");
			TFValorP.setText("");
			TFQuantidadeP.setText("");
		} else if ("Cadastrar Cliente".equals(cmd)) {
			// Atribuindo ao botão BcadastrarC a função de enviar os dados do
			// usuario para o cadastro de novos clientes

			Cliente cliente = new Cliente();

			cliente.setNome(TFNomeC.getText());
			cliente.setNome(Validacoes.ValNomeCliente(TFNomeC,
					cliente.getNome()));

			cliente.setValordivida(Double.parseDouble(TFValorC.getText()));
			cliente.setValordivida(Validacoes.ValValorDCliente(TFValorC,
					cliente.getValordivida()));
			try {
				String sql = "insert into cliente (nome, divida) values (?,?)";
				PreparedStatement pst = c.conexao.prepareStatement(sql);
				pst.setString(1, cliente.getNome());
				pst.setDouble(2, cliente.getValordivida());
				pst.execute();
				pst.close();
				JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
			} catch (SQLException e4) {
				//se o nome de cliente que foi solicitado para cadastrar já houver um cadastro associado é 
				//solicitado ao usuario se ele quer atualizar este cadastro
				int i = Integer.parseInt(JOptionPane.showInputDialog(null,
						"ERROR: Gravação de cliente não concluida!\n"
								+ "Deseja atualizar o cliente?\n" 
								+ "1 - sim\n"
								+ "2 - não\n"));
				if (i == 1) {
					try {
						String sql = "update cliente set divida = ? where nome = ?";
						PreparedStatement pst = c.conexao.prepareStatement(sql);
						cliente.setValordivida(Double.parseDouble(TFValorC
								.getText()));
						cliente.setValordivida(Validacoes.ValValorDCliente(
								TFValorC, cliente.getValordivida()));

						pst.setDouble(1, cliente.getValordivida());
						pst.setString(2, cliente.getNome());
						pst.execute();
						pst.close();
						JOptionPane.showMessageDialog(null,
								"Alterado com sucesso!");
					} catch (SQLException ee) {
						JOptionPane.showMessageDialog(null,
								"Erro durante Alteração!");
					}
				}
			}

			TFValorC.setText("");
			TFNomeC.setText("");

		} else if ("Pesquisar Cliente".equals(cmd)) {
			// Atribuindo ao botão BpesquisarC a função de pesquisar por
			// clientes cadastrados
			String nome = JOptionPane
					.showInputDialog("Digite o nome do cliente que deseja buscar: ");
			try {
				String sql = "select * from cliente where nome = ?";
				PreparedStatement pst = c.conexao.prepareStatement(sql);
				pst.setString(1, nome);
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					TFNomeC.setText(rs.getString("nome"));
					TFValorC.setText(Double.toString(rs.getDouble("divida")));
				}
				pst.execute();
				pst.close();

			} catch (SQLException e5) {
				JOptionPane.showMessageDialog(null,
						"ERRO: Pesquisa não concluida!");
				e5.printStackTrace();
			}
		} else if ("Excluir Cliente".equals(cmd)) {
			// Atribuindo ao botão BapagarC a função de apagar registros de
			// clientes
			String nome = JOptionPane
					.showInputDialog("Digite o nome do cliente que deseja apagar o cadastro: ");
			try {
				String sql = "delete cliente where nome = ?";
				PreparedStatement pst = c.conexao.prepareStatement(sql);
				pst.setString(1, nome);
				pst.execute();
				pst.close();
				JOptionPane.showMessageDialog(null,
						"Cliente deletado com sucesso!");
			} catch (SQLException e6) {
				JOptionPane.showMessageDialog(null,
						"ERROR: Exclusão não concluida adequadamente!");
				e6.printStackTrace();
			}
			TFValorC.setText("");
			TFNomeC.setText("");
		} else if ("Salvar".equals(cmd)) {
			// Atribuindo ao botão BSalvarV a função de enviar os dados do
			// usuario para o cadastro de novas vendas

			Venda venda = new Venda();

			venda.setNomeComprador(TFNome.getText());
			venda.setNomeComprador(Validacoes.ValNomeVenda(TFNome,
					venda.getNomeComprador()));

			venda.setValor(Double.parseDouble(TFValor.getText()));
			venda.setValor(Validacoes.ValValorVenda(TFValor, venda.getValor()));

			venda.setData(TFData.getText());

			try {
				String sql = "insert into venda (nome, valor, data) values (?,?,?)";
				PreparedStatement pst2 = c.conexao.prepareStatement(sql);

				pst2.setString(1, venda.getNomeComprador());
				pst2.setDouble(2, venda.getValor());
				pst2.setString(3, venda.getData());
				pst2.execute();
				pst2.close();
				try 
				{
					// verificando se existe um cliente cadastrado com o nome
					// solicitado na venda
					// e se sim vendo se ainda pode efetuar compras
					String sql2 = "select * from cliente where nome = ?";
					PreparedStatement pst = c.conexao.prepareStatement(sql2);
					pst.setString(1, venda.getNomeComprador());
					ResultSet rs = pst.executeQuery();

					double dividaCliente = 0;
					String nome = "";
					if (rs.next()) {
						dividaCliente = rs.getDouble("divida");
						nome = rs.getString("nome");
					}
					if (nome != "") 
					{
						if (dividaCliente >= 200) 
						{
							JOptionPane.showMessageDialog(null,
											"Divida do cliente acima do permitido. Venda não finalizada!");
							try {
								String sql3 = "delete venda where nome = ? and valor = ? and data = ?";
								PreparedStatement pst3 = c.conexao.prepareStatement(sql3);
								pst3.setString(1, venda.getNomeComprador());
								pst3.setDouble(2, venda.getValor());
								pst3.setString(3, venda.getData());
								pst3.execute();
								pst3.close();
							} catch (SQLException e6) {
								JOptionPane.showMessageDialog(null,
										"ERRO durante cancelamento de venda!" +e6);
								e6.printStackTrace();
							}
						}
					}else{
						JOptionPane.showMessageDialog(null, "Cliente não cadastrado!");
					}
					pst.execute();
					pst.close();
				} 
				catch (SQLException e7) 
				{
					e7.printStackTrace();
				}
				
			} catch (SQLException e9) {
				JOptionPane.showMessageDialog(null,
						"ERRO durante o salvamento da venda!");
				e9.printStackTrace();
			}
			

			TFNome.setText("");
			TFValor.setText("");
		} else if ("Cancelar".equals(cmd)) {
			// Atribuindo ao botão BCancelarV a função de limpar os campos da
			// tela
			TFNome.setText("");
			TFValor.setText("");
		} else if ("Calculadora".equals(cmd)) {
			// Atribuindo ao botão BVendaCalc a função de abrir a calculadora do
			// sistema operacional

			try {
				Runtime.getRuntime().exec("calc");
			} catch (IOException e8) {
				JOptionPane.showMessageDialog(null,
						"ERRO durante a abertura da calculadora!");
				e8.printStackTrace();
			}
		}
	}
}
