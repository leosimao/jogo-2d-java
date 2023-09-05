package br.com.jogo.principal;

import br.com.jogo.modelo.FaseUm;
import br.com.jogo.modelo.Personagem;

import javax.swing.*;

public class Principal extends JFrame {
    public static void main(String[] args) {
        new Principal();
    }
    
    public static final int LARGURA_DA_TELA = 1920;
    public static final int ALTURA_DA_TELA = 1080; 
    public Principal() {
        FaseUm fase = new FaseUm();
        super.add(fase);
        super.setTitle("Jogo Java 2D - POO");
        super.setSize(1920, 1080);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        super.setVisible(true);

    }
}
