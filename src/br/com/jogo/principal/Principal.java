package br.com.jogo.principal;

import br.com.jogo.modelo.Fase;
import br.com.jogo.modelo.Personagem;

import javax.swing.*;

public class Principal extends JFrame {
    public static void main(String[] args) {
        new Principal();
    }
    public Principal() {
        Fase fase = new Fase();
        super.add(fase);
        super.setTitle("Jogo Java 2D - POO");
        super.setSize(1920, 1080);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        super.setVisible(true);

    }
}
