package femass.gui;

import femass.dao.DaoAutor;
import femass.model.Autor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiAutor {
    private JButton btnCadastrar;
    private JTextField txtNome;
    private JTextField txtSobrenome;
    private JTextField txtNacionalidade;
    private JList lstAutores;
    private JPanel jPainel;
    private JButton btnVoltar;
    private JFrame telaFechar;

    public GuiAutor(){
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DaoAutor daoAutor = new DaoAutor();
                    daoAutor.gravar(new Autor(txtNome.getText(), txtSobrenome.getText(), txtNacionalidade.getText()));
                    atualizarLista();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
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
        tela.setTitle("Cadastro de Autores");
        tela.setContentPane(jPainel);
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        try{
            atualizarLista();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        tela.pack();
        tela.setVisible(true);
    }

    private void atualizarLista() throws Exception{
        DaoAutor daoAutor = new DaoAutor();
        lstAutores.setListData(daoAutor.consultar().toArray());
    }


}
