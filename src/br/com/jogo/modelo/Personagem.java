package br.com.jogo.modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Personagem {
    private int posicaoEmX;
    private int posicaoEmY;
    private int deslocamentoX;
    private int deslocamentoY;
    private int larguraImagem;
    private int alturaImagem;
    private Image personagem;

    public static final int POSICAO_INICIAL_X = 100;
    public static final int POSICAO_INICIAL_Y = 100;
    public static final int DESLOCAMENTO = 3;
    public Personagem(){
        this.posicaoEmX = POSICAO_INICIAL_X;
        this.posicaoEmY = POSICAO_INICIAL_Y;
    }
    public void carregar(){
        ImageIcon nave = new ImageIcon("recursos\\nave.png");
        this.personagem = nave.getImage();
        this.alturaImagem = this.personagem.getWidth(null);
        this.larguraImagem = this.personagem.getHeight(null);
    }

    public void atualizar(){
        this.posicaoEmX += this.deslocamentoX;
        this.posicaoEmY += this.deslocamentoY;
    }

    public void mover(KeyEvent tecla){
        int codigo = tecla.getKeyCode();
        switch(codigo){
            case KeyEvent.VK_UP:
                this.deslocamentoY = -DESLOCAMENTO;
                break;
            case KeyEvent.VK_DOWN:
                this.deslocamentoY = DESLOCAMENTO;
                break;
            case KeyEvent.VK_LEFT:
                this.deslocamentoX = -DESLOCAMENTO;
                break;
            case KeyEvent.VK_RIGHT:
                this.deslocamentoX = DESLOCAMENTO;
                break;
            default:
                break;
        }
    }
    public void parar(KeyEvent tecla){
        int codigo = tecla.getKeyCode();
        switch (codigo){
            case KeyEvent.VK_UP, KeyEvent.VK_DOWN:
                this.deslocamentoY = 0;
                break;
            case KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT:
                this.deslocamentoX = 0;
                break;
            default:
                break;
        }
    }

    public int getPosicaoEmX() {
        return posicaoEmX;
    }

    public void setPosicaoEmX(int posicaoEmX) {
        this.posicaoEmX = posicaoEmX;
    }

    public int getPosicaoEmY() {
        return posicaoEmY;
    }

    public void setPosicaoEmY(int posicaoEmY) {
        this.posicaoEmY = posicaoEmY;
    }

    public int getDeslocamentoX() {
        return deslocamentoX;
    }

    public void setDeslocamentoX(int deslocamentoX) {
        this.deslocamentoX = deslocamentoX;
    }

    public int getDeslocamentoY() {
        return deslocamentoY;
    }

    public void setDeslocamentoY(int deslocamentoY) {
        this.deslocamentoY = deslocamentoY;
    }

    public int getLarguraImagem() {
        return larguraImagem;
    }

    public void setLarguraImagem(int larguraImagem) {
        this.larguraImagem = larguraImagem;
    }

    public int getAlturaImagem() {
        return alturaImagem;
    }

    public void setAlturaImagem(int alturaImagem) {
        this.alturaImagem = alturaImagem;
    }

    public Image getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Image personagem) {
        this.personagem = personagem;
    }
}