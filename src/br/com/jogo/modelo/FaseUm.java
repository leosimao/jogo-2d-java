package br.com.jogo.modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class FaseUm extends Fase {
    private boolean emJogo = true;

    public FaseUm(){
        super();
        ImageIcon carregar = new ImageIcon("recursos\\fundo.jpg");
        fundo = carregar.getImage();

        personagem = new Personagem();
        personagem.carregar();

        this.inicializarInimigo();

        addKeyListener(this);

        timer = new Timer(DELAY, this);
        timer.start();        
    }

    public void paint(Graphics g){
        Graphics2D graficos = (Graphics2D)  g;
        if(emJogo){
            graficos.drawImage(fundo, 0, 0, null);
            graficos.drawImage(personagem.getImagem(), personagem.getPosicaoEmX(), personagem.getPosicaoEmY(), this);
            ArrayList<Tiro> tiros = personagem.getTiros();
            ArrayList<SuperTiro> superTiros = personagem.getSuperTiros();
            
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

    @Override
    public void inicializarInimigo(){
        inimigos = new ArrayList<Inimigo>();

        for(int i = 0; i < QUANTIDADE_INIMIGOS; i++){
            int x = (int) (Math.random() * 8000 + 1024);
            int y = (int) (Math.random() * 650 + 30);
            Inimigo inimigo = new Inimigo(x, y);
            inimigos.add(inimigo);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        personagem.atualizar();
        ArrayList<Tiro> tiros = personagem.getTiros();
        for (Tiro tiro : tiros) {
            tiro.atualizar();
        }

        ArrayList<SuperTiro> superTiros = personagem.getSuperTiros();
        for(SuperTiro superTiro : superTiros){
            superTiro.atualizarSuper();
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
            personagem.atirar();
        if(e.getKeyCode() == KeyEvent.VK_C)
            personagem.atirarSuper();
        else
            personagem.mover(e);  
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        personagem.parar(e);
    }

}