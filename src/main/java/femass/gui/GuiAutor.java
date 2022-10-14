package femass.gui;

import femass.dao.DaoAutor;
import femass.model.Autor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiAutor {
    private JButton btnCadastrar;
    private JButton btnVoltar;
    private JTextField txtNome;
    private JTextField txtSobrenome;
    private JTextField txtNacionalidade;
    private JList lstAutores;
    private JPanel jPainel;
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
                telaFechar.dispose();
            }
        });
    }

    public void abrirTela(){
        JFrame tela = new JFrame("Cadastro de Autores");
        telaFechar = tela;
        tela.setContentPane(jPainel);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
