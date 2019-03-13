package view;

import java.awt.Font;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import controller.ControleMenu;

public class Menu extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField TFCodigoP;
	private JTextField TFNomeP;
	private JTextField TFValorP;
	private JTextField TFQuantidadeP;
	private JTextField TFNomeC;
	private JTextField TFValorC;
	private JTextField TFNome;
	private JTextField TFValor;
	private JTextField TFData;

	
	public Menu() {
		setTitle("Estoque");
        setSize(455,330);
        setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 450, 300);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 450, 300);
		panel.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Produto", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblControleDeProdutos = new JLabel("Controle de Produtos:");
		lblControleDeProdutos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblControleDeProdutos.setBounds(20, 22, 168, 14);
		panel_1.add(lblControleDeProdutos);
		
		JLabel lblCdigo = new JLabel("Código:");
		lblCdigo.setBounds(20, 65, 46, 14);
		panel_1.add(lblCdigo);
		
		TFCodigoP = new JTextField();
		TFCodigoP.setBounds(65, 62, 86, 20);
		panel_1.add(TFCodigoP);
		TFCodigoP.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(20, 93, 46, 14);
		panel_1.add(lblNome);
		
		TFNomeP = new JTextField();
		TFNomeP.setBounds(65, 90, 125, 20);
		panel_1.add(TFNomeP);
		TFNomeP.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(20, 122, 46, 14);
		panel_1.add(lblValor);
		
		TFValorP = new JTextField();
		TFValorP.setBounds(65, 119, 86, 20);
		panel_1.add(TFValorP);
		TFValorP.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(20, 150, 60, 14);
		panel_1.add(lblQuantidade);
		
		TFQuantidadeP = new JTextField();
		TFQuantidadeP.setBounds(90, 147, 86, 20);
		panel_1.add(TFQuantidadeP);
		TFQuantidadeP.setColumns(10);
		
		JButton Bcadastrar = new JButton("Cadastrar/Alterar");

		Bcadastrar.setBounds(52, 202, 126, 23);
		panel_1.add(Bcadastrar);
		
		JButton Bpesquisar = new JButton("Pesquisar");
		Bpesquisar.setBounds(199, 202, 89, 23);
		panel_1.add(Bpesquisar);
		
		JButton Bapagar = new JButton("Apagar");
		Bapagar.setBounds(309, 202, 89, 23);
		panel_1.add(Bapagar);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Cliente", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblControleDeClientes = new JLabel("Controle de Clientes:");
		lblControleDeClientes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblControleDeClientes.setBounds(21, 24, 168, 14);
		panel_2.add(lblControleDeClientes);
		
		JLabel label_2 = new JLabel("Nome:");
		label_2.setBounds(21, 95, 46, 14);
		panel_2.add(label_2);
		
		TFNomeC = new JTextField();
		TFNomeC.setColumns(10);
		TFNomeC.setBounds(64, 92, 136, 20);
		panel_2.add(TFNomeC);
		
		JLabel lblValorDivida = new JLabel("Valor Divida:");
		lblValorDivida.setBounds(21, 124, 61, 14);
		panel_2.add(lblValorDivida);
		
		TFValorC = new JTextField();
		TFValorC.setColumns(10);
		TFValorC.setBounds(92, 121, 86, 20);
		panel_2.add(TFValorC);
		
		JButton BcadastrarC = new JButton("Cadastrar/Alterar");

		BcadastrarC.setBounds(53, 204, 126, 23);
		panel_2.add(BcadastrarC);
		
		JButton BpesquisarC = new JButton("Pesquisar");
		BpesquisarC.setBounds(200, 204, 89, 23);
		panel_2.add(BpesquisarC);
		
		JButton BapagarC = new JButton("Apagar");
		BapagarC.setBounds(310, 204, 89, 23);
		panel_2.add(BapagarC);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Vendas", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblAdicionarVendaAo = new JLabel("Adicionar Venda ao Histórico");
		lblAdicionarVendaAo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdicionarVendaAo.setBounds(23, 21, 189, 14);
		panel_3.add(lblAdicionarVendaAo);
		
		JLabel lblNomeComprador = new JLabel("Nome Comprador:");
		lblNomeComprador.setBounds(23, 80, 104, 14);
		panel_3.add(lblNomeComprador);
		
		TFNome = new JTextField();
		TFNome.setColumns(10);
		TFNome.setBounds(121, 77, 136, 20);
		panel_3.add(TFNome);
		
		JLabel lblValor_1 = new JLabel("Valor:");
		lblValor_1.setBounds(23, 109, 61, 14);
		panel_3.add(lblValor_1);
		
		TFValor = new JTextField();
		TFValor.setColumns(10);
		TFValor.setBounds(55, 106, 86, 20);
		panel_3.add(TFValor);
		
		JButton BCancelarV = new JButton("Cancelar");
		BCancelarV.setBounds(105, 166, 89, 23);
		panel_3.add(BCancelarV);
		
		JButton BSalvarV = new JButton("Salvar");
		BSalvarV.setBounds(253, 166, 89, 23);
		panel_3.add(BSalvarV);
		
		JButton BVendaCalc = new JButton("Calculadora");
		BVendaCalc.setBounds(184, 216, 89, 23);
		panel_3.add(BVendaCalc);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(23, 134, 46, 14);
		panel_3.add(lblData);
		
		TFData = new JTextField();
		TFData.setBounds(55, 134, 86, 20);
		panel_3.add(TFData);
		TFData.setColumns(10);
		TFData.setEditable(false);
		
		//Obtenção da data atual para ser usada no histórico de vendas
		Date data = new Date();
		String DataString = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(data); //Conversão do tipo Date para String
				
		TFData.setText(DataString);
		
        Bcadastrar.setActionCommand("Cadastrar Produto");//Modificando id do ActionListener
            
        
        Bpesquisar.setActionCommand("Pesquisar Produto");
        
        
        Bapagar.setActionCommand("Excluir Produto");
        
        BcadastrarC.setText("Cadastrar/Alterar ");
        BcadastrarC.setActionCommand("Cadastrar Cliente");
        
        
        BpesquisarC.setActionCommand("Pesquisar Cliente");
        
        
        BapagarC.setActionCommand("Excluir Cliente");
        
        
        
        //Instancia da classe ControleMenu para atrubir funçoes para os botoes
        ControleMenu controle = new ControleMenu(TFCodigoP, TFNomeP, TFValorP, TFQuantidadeP, TFNomeC, 
        		TFValorC, TFNome, TFValor, TFData);
        
        //Atrubuindo aos botoes o ActionListener por meio da instancia da controle 
        Bcadastrar.addActionListener(controle);
        Bpesquisar.addActionListener(controle);
        Bapagar.addActionListener(controle);
        BcadastrarC.addActionListener(controle);
        BpesquisarC.addActionListener(controle);
        BapagarC.addActionListener(controle);
        BSalvarV.addActionListener(controle);
        BCancelarV.addActionListener(controle);
        BVendaCalc.addActionListener(controle);

	}
	public static void main(String[] args) {
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
        
	}
}
