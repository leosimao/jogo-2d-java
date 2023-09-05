package br.com.jogo.modelo;

import javax.swing.*;

import br.com.jogo.principal.Principal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class FaseUm extends Fase {
    
    public FaseUm(){
        super();
        ImageIcon carregar = new ImageIcon("recursos\\fundo.jpg");
        fundo = carregar.getImage();

        personagem = new Personagem();
        personagem.carregar();

        this.inicializarInimigo();
        this.inicializarElementosGraficosAdicionais();

        addKeyListener(this);

        timer = new Timer(DELAY, this);
        timer.start();        
    }

    public void paint(Graphics g){
        Graphics2D graficos = (Graphics2D)  g;
        if(emJogo){
            graficos.drawImage(fundo, 0, 0, null);
            graficos.drawImage(personagem.getImagem(), personagem.getPosicaoEmX(), personagem.getPosicaoEmY(), this);
            
            for (Asteroide asteroide : asteroides) {
                graficos.drawImage(asteroide.getImagem(), asteroide.getPosicaoEmX(), asteroide.getPosicaoEmY(), this);
            }
            
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
            ImageIcon gameOver = new ImageIcon("recursos\\game_over.jpg");
            graficos.drawImage(gameOver.getImage(), 0, 0, this);
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
        
       for (Asteroide asteroide : asteroides) {
            asteroide.atualizar();
        }

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
        
        verificarColisoes();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
            personagem.atirar();
        if(e.getKeyCode() == KeyEvent.VK_Q)
            personagem.atirarSuper();
        else
            personagem.mover(e);  
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        personagem.parar(e);
    }

    @Override
    public void verificarColisoes() {
        Rectangle formaPersonagem = this.personagem.getRectangle();
        for(int i = 0; i < inimigos.size(); i++){
            Inimigo inimigo = inimigos.get(i);
            Rectangle formaInimigo = inimigo.getRectangle();
            if(formaInimigo.intersects(formaPersonagem)){
                this.personagem.setEhVisivel(false);
                inimigo.setEhVisivel(false);
                emJogo = false;
            }

            ArrayList<Tiro> tiros = this.personagem.getTiros();
            for (int j = 0; j < tiros.size(); j++){
                Tiro tiro = tiros.get(j);
                Rectangle formaTiro = tiro.getRectangle();
                if(formaInimigo.intersects(formaTiro)){
                    inimigo.setEhVisivel(false);
                    tiro.setEhVisivel(false);
                }
            }
        }
    }

    @Override
    public void inicializarElementosGraficosAdicionais() {
       super.asteroides = new ArrayList<Asteroide>();
       for(int i = 0; i < QUANTIDADE_ASTEROIDES; i++){
        int x = (int) (Math.random() * Principal.LARGURA_DA_TELA);
        int y = (int) (Math.random() * Principal.ALTURA_DA_TELA);
        Asteroide asteroide = new Asteroide(x, y);
        super.asteroides.add(asteroide);
       } 
    }

}