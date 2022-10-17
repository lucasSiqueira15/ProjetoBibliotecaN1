package femass.gui;

import femass.dao.DaoAutor;
import femass.model.Autor;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
    private JTextField txtId;
    private JFrame telaFechar;
    private String telaNova;

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
                if(telaNova.equals("Principal")){
                    GuiPrincipal telaPrincipal = new GuiPrincipal();
                    telaFechar.dispose();
                    telaPrincipal.abrirTela();
                }
                else{
                    if(telaNova.equals("Livro")){
                        GuiLivro telaLivro = new GuiLivro();
                        telaFechar.dispose();
                        telaLivro.abrirTela();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Erro ao carregar a tela anterior.");
                    }
                }
            }
        });
        lstAutores.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Autor autor = (Autor) lstAutores.getSelectedValue();
                if (autor==null) return;
                txtId.setText(autor.getId().toString());
                txtNome.setText(autor.getNome());
                txtSobrenome.setText(autor.getSobrenome());
                txtNacionalidade.setText(autor.getNacionalidade());
            }
        });
    }

    public void abrirTela(String telaAnterior){
        JFrame tela = new JFrame();
        telaFechar = tela;
        telaNova = telaAnterior;
        tela.setTitle("Cadastro de Autores");
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
