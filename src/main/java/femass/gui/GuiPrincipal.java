package femass.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiPrincipal {
    private JPanel jPainel;
    private JButton btnCadAutores;
    private JButton btnCadExemplares;
    private JButton btnCadLeitor;
    private JFrame telaFechar;

    public GuiPrincipal() {
        btnCadAutores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiAutor guiAutor = new GuiAutor();
                telaFechar.dispose();
                guiAutor.abrirTelaModal();
            }
        });
        btnCadExemplares.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnCadLeitor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiLeitor guiLeitor = new GuiLeitor();
                telaFechar.dispose();
                guiLeitor.abrirTelaModal();
            }
        });
    }

    public void abrirTela(){
        JFrame tela = new JFrame("Biblioteca");
        telaFechar = tela;
        tela.setContentPane(jPainel);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.pack();
        tela.setVisible(true);
    }

}
