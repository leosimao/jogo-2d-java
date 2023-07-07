package br.com.jogo.modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Fase extends JPanel implements ActionListener, KeyListener {
    private Image fundo;
    private Personagem nave;
    private ArrayList<Inimigo> inimigos;
    private Timer timer;
    private boolean emJogo = true;

    public static final int DELAY = 5;
    public static final int QTD_INIMIGOS = 40;
    
    public Fase(){
        setFocusable(true);
        setDoubleBuffered(true);
        ImageIcon carregar = new ImageIcon("recursos\\fundo.jpg");
        fundo = carregar.getImage();

        nave = new Personagem();
        nave.carregar();

        this.inicializandoInimigo();

        addKeyListener(this);

        timer = new Timer(DELAY, this);
        timer.start();        
    }

    public void paint(Graphics g){
        Graphics2D graficos = (Graphics2D)  g;
        if(emJogo){
            graficos.drawImage(fundo, 0, 0, null);
            graficos.drawImage(nave.getImagem(), nave.getPosicaoEmX(), nave.getPosicaoEmY(), this);
            ArrayList<Tiro> tiros = nave.getTiros();
            ArrayList<SuperTiro> superTiros = nave.getSuperTiros();
            
            for (Tiro tiro : tiros) {
                graficos.drawImage(tiro.getImagem(), tiro.getPosicaoEmX(), tiro.getPosicaoEmY(), this);
            }

            for(SuperTiro superTiro: superTiros){
                graficos.drawImage(superTiro.getImagem(), superTiro.getPosicaoEmX(), superTiro.getPosicaoEmY(), this);
            }

            for (Inimigo inimigo : inimigos) {
                graficos.drawImage(inimigo.getImagem(), inimigo.getPosicaoEmX(), inimigo.getPosicaoEmY(), this);
            }
            
            g.dispose();
        }
        else{
            ImageIcon gameOver = new ImageIcon("recursos\\game_over.jpeg");
            graficos.drawImage(gameOver.getImage(), 960, 540, this);
        }
    }

    public void inicializandoInimigo(){
        inimigos = new ArrayList<Inimigo>();

        for(int i = 0; i < QTD_INIMIGOS; i++){
            int x = (int) (Math.random() * 8000 + 1024);
            int y = (int) (Math.random() * 650 + 30);
            Inimigo inimigo = new Inimigo(x, y);
            inimigos.add(inimigo);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        nave.atualizar();
        ArrayList<Tiro> tiros = nave.getTiros();
        for (Tiro tiro : tiros) {
            tiro.atualizar();
        }

        for (int i = 0; i < this.inimigos.size(); i++) {
            Inimigo inimigo = this.inimigos.get(i);
            if(inimigo.getPosicaoEmX() < 0){
                this.inimigos.remove(inimigo);
            }
            else{
                inimigo.atualizar();
            }
            
        }
        
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
            nave.atirar();
        else
            nave.mover(e);  
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        nave.parar(e);
    }

}