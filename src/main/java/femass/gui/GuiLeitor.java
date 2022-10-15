package femass.gui;

import femass.dao.DaoAutor;
import femass.dao.DaoLeitor;
import femass.model.Aluno;
import femass.model.Autor;
import femass.model.Leitor;
import femass.model.Professor;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
    private JButton btnCadastrar;
    private JButton btnVoltar;
    private JFrame telaFechar;

    public GuiLeitor() {
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DaoLeitor leitor = new DaoLeitor();

                    if(cboLeitor.getSelectedItem().toString().equals("Professor")){
                        leitor.gravar(
                                new Professor(
                                    txtNome.getText(), txtEndereco.getText(), txtTelefone.getText(), txtDisciplina.getText()
                                ));
                    }
                    else{
                        leitor.gravar(
                                new Aluno(
                                        txtNome.getText(), txtEndereco.getText(), txtTelefone.getText(), txtMatricula.getText()
                                ));
                    }

                    atualizarLista();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
               }
            }
        });
        cboLeitor.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                if(cboLeitor.getSelectedItem().toString().equals("Professor")){
                    txtMatricula.setEditable(true);
                    txtDisciplina.setEditable(false);
                }
                else{
                    if(cboLeitor.getSelectedItem().toString().equals("Aluno")){
                        txtMatricula.setEditable(false);
                        txtDisciplina.setEditable(true);
                    }
                    else{
                        txtMatricula.setEditable(true);
                        txtDisciplina.setEditable(true);
                    }
                }
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
            }
            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {

            }
        });
        lstLeitor.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(lstLeitor.getSelectedValue().getClass().getName().equals("Professor")){
                    Professor professor = (Professor) lstLeitor.getSelectedValue();
                    if (professor==null) return;
                    txtCodigo.setText(professor.getCodigo().toString());
                    txtNome.setText(professor.getNome());
                    txtEndereco.setText(professor.getEndereco());
                    txtTelefone.setText(professor.getTelefone());
                    txtDevolucao.setText(professor.getPrazoMaximoDevolucao().toString());
                    txtDisciplina.setText(professor.getDisciplina());
                    cboLeitor.setSelectedItem("Professor");
                }
                else{
                    Aluno aluno = (Aluno) lstLeitor.getSelectedValue();
                    if (aluno==null) return;
                    txtCodigo.setText(aluno.getCodigo().toString());
                    txtNome.setText(aluno.getNome());
                    txtEndereco.setText(aluno.getEndereco());
                    txtTelefone.setText(aluno.getTelefone());
                    txtDevolucao.setText(aluno.getPrazoMaximoDevolucao().toString());
                    txtMatricula.setText(aluno.getMatricula());
                    cboLeitor.setSelectedItem("Aluno");
                }
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

    public void abrirTelaModal(){
        JFrame tela = new JFrame();
        telaFechar = tela;
        tela.setTitle("Cadastro de Leitores");
        tela.setContentPane(jPainel);
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        try{
            atualizarLista();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        cboLeitor.addItem("");
        cboLeitor.addItem("Professor");
        cboLeitor.addItem("Aluno");

        tela.pack();
        tela.setVisible(true);
    }

    private void atualizarLista() throws Exception{
        DaoLeitor leitores = new DaoLeitor();
        lstLeitor.setListData(leitores.consultar().toArray());
    }

}
