package br.com.jogo.modelo;

import javax.swing.*;
import java.awt.*;

public class Fase extends JPanel{
    private Image fundo;
    private Personagem nave;

    public Fase(){
        ImageIcon carregar = new ImageIcon("recursos\\fundo.jpg");
        fundo = carregar.getImage();

        Personagem nave = new Personagem();
        nave.carregar();
    }

    public void paint(Graphics g){
        Graphics2D graficos = (Graphics2D)  g;
        graficos.drawImage(fundo, 0, 0, null);
        graficos.drawImage(nave.getPersonagem(), nave.getPosicaoEmX(), nave.getPosicaoEmY(), this);
        g.dispose();
    }
}