package br.com.jogo.modelo;

import javax.swing.ImageIcon;
import java.awt.Image;

public class Tiro {
    private int posicaoEmX;
    private int posicaoEmY;
    private int larguraImagem;
    private int alturaImagem;
    private Image tiro;

    public static final int VELOCIDADE_TIRO = 2;
    public Tiro(int posicaoTiroX, int posicaoTiroY){
        this.posicaoEmX = posicaoTiroX;
        this.posicaoEmY = posicaoTiroY;
    }
    public void carregar(){
        ImageIcon tiro = new ImageIcon("recursos\\tiro.png");
        this.tiro = tiro.getImage();
        this.alturaImagem = this.tiro.getWidth(null);
        this.larguraImagem = this.tiro.getHeight(null);
    }

    public void atualizar(){
        this.posicaoEmX += VELOCIDADE_TIRO;
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

    public Image getTiro() {
        return tiro;
    }

    public void setTiro(Image tiro) {
        this.tiro = tiro;
    }
}
