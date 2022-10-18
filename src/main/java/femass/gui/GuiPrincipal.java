package femass.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiPrincipal {
    private JPanel jPainel;
    private JButton btnCadAutores;
    private JButton btnCadLivro;
    private JButton btnCadLeitor;
    private JComboBox cboUsuario;
    private JLabel lblBibliotecario;
    private JLabel lblAtendente;
    private JButton btnRelAtraso;
    private JButton btnRealizarEmp;
    private JButton btnDevolverEmp;
    private JFrame telaFechar;
    private static final String funcionario0 = "";
    private static final String funcionario1 = "Bibliotecario";
    private static final String funcionario2 = "Atendente";

    public GuiPrincipal() {
        btnCadAutores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiAutor guiAutor = new GuiAutor();
                telaFechar.dispose();
                guiAutor.abrirTela(new GuiPrincipal().toString());
            }
        });
        btnCadLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiLivro guiLivro = new GuiLivro();
                telaFechar.dispose();
                guiLivro.abrirTela();
            }
        });
        btnCadLeitor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiLeitor guiLeitor = new GuiLeitor();
                telaFechar.dispose();
                guiLeitor.abrirTela(new GuiPrincipal().toString());
            }
        });
        btnRelAtraso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiRelatorio guiRelatorio = new GuiRelatorio();
                telaFechar.dispose();
                guiRelatorio.abrirTela();
            }
        });
        btnRealizarEmp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiEmprestimo guiEmprestimo = new GuiEmprestimo();
                telaFechar.dispose();
                guiEmprestimo.abrirTela();
            }
        });
        btnDevolverEmp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiDevolver guiDevolver = new GuiDevolver();
                telaFechar.dispose();
                guiDevolver.abrirTela();
            }
        });
        cboUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cboUsuario.getSelectedItem().toString().equals(funcionario1)){
                    lblAtendente.setVisible(false);
                    btnCadLeitor.setVisible(false);
                    btnRealizarEmp.setVisible(false);
                    btnDevolverEmp.setVisible(false);

                    lblBibliotecario.setVisible(true);
                    btnCadLivro.setVisible(true);
                    btnRelAtraso.setVisible(true);
                    btnCadAutores.setVisible(true);
                }
                else{
                    if(cboUsuario.getSelectedItem().toString().equals(funcionario2)){
                        lblAtendente.setVisible(true);
                        btnCadLeitor.setVisible(true);
                        btnRealizarEmp.setVisible(true);
                        btnDevolverEmp.setVisible(true);

                        lblBibliotecario.setVisible(false);
                        btnCadLivro.setVisible(false);
                        btnRelAtraso.setVisible(false);
                        btnCadAutores.setVisible(false);
                    }
                    else{
                        if(cboUsuario.getSelectedItem().toString().equals(funcionario0)){
                            lblAtendente.setVisible(false);
                            btnCadLeitor.setVisible(false);
                            btnRealizarEmp.setVisible(false);
                            btnDevolverEmp.setVisible(false);

                            lblBibliotecario.setVisible(false);
                            btnCadLivro.setVisible(false);
                            btnRelAtraso.setVisible(false);
                            btnCadAutores.setVisible(false);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Erro ao carregar as opções de Menu.", "Alerta", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                telaFechar.pack();
            }
        });
    }

    public void abrirTela(){
        JFrame tela = new JFrame("Biblioteca");
        telaFechar = tela;
        tela.setContentPane(jPainel);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cboUsuario.addItem(funcionario0);
        cboUsuario.addItem(funcionario1);
        cboUsuario.addItem(funcionario2);

        tela.pack();
        tela.setVisible(true);

    }
    @Override
    public String toString() {
        return "Principal";
    }
}
