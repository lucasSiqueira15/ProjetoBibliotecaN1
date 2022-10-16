package femass.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiLeitor {
    private JPanel jPainel;
    private JList lstLeitor;
    private JTextField txtCodigo;
    private JTextField txtNome;
    private JTextField txtEndereco;
    private JTextField txtTelefone;
    private JTextField txtDevolucao;
    private JComboBox cboLeitor;
    private JTextField txtDisciplina;
    private JTextField txtMatricula;
    private JButton btnCadastrarProf;
    private JButton btnVoltar;
    private JButton btnCadastrarAluno;
    private JFrame telaFechar;

    public GuiLeitor() {
        btnCadastrarProf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiProfessor telaProfessor = new GuiProfessor();
                telaFechar.dispose();
                telaProfessor.abrirTela();
            }
        });
        btnCadastrarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiAluno telaAluno = new GuiAluno();
                telaFechar.dispose();
                telaAluno.abrirTela();
            }
        });
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiPrincipal telaPrincipal = new GuiPrincipal();
                telaFechar.dispose();
                telaPrincipal.abrirTela();
            }
        });
    }

    public void abrirTela(){
        JFrame tela = new JFrame();
        telaFechar = tela;
        tela.setTitle("Opções de Cadastro de Leitores");
        tela.setContentPane(jPainel);
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.pack();
        tela.setVisible(true);
    }

}
