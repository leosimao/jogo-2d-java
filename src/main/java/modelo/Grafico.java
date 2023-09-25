package modelo;

import java.awt.Image;
import java.awt.Rectangle;

public abstract class Grafico {
    private int posicaoEmX;
    private int posicaoEmY;
    private int alturaImagem;
    private int larguraImagem;
    private Image imagem;
    private boolean ehVisivel = true;

    public boolean getEhVisivel() {
        return ehVisivel;
    }

    public void setEhVisivel(boolean ehVisivel) {
        this.ehVisivel = ehVisivel;
    }

    public abstract void carregar();
    public abstract void atualizar();

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

    public int getAlturaImagem() {
        return alturaImagem;
    }

    public void setAlturaImagem(int alturaImagem) {
        this.alturaImagem = alturaImagem;
    }

    public int getLarguraImagem() {
        return larguraImagem;
    }

    public void setLarguraImagem(int larguraImagem) {
        this.larguraImagem = larguraImagem;
    }

    public Image getImagem() {
        return imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    public Rectangle getRectangle(){
        return new Rectangle(posicaoEmX, posicaoEmY, larguraImagem, alturaImagem);
    }
}