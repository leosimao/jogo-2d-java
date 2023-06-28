package br.com.jogo.modelo;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Personagem {
    private int posicaoEmX;
    private int posicaoEmY;
    private int deslocamentoX;
    private int deslocamentoY;
    private int larguraImagem;
    private int alturaImagem;
    private Image personagem;
    private ArrayList<Tiro> tiros;

    public static final int POSICAO_INICIAL_X = 100;
    public static final int POSICAO_INICIAL_Y = 100;
    public static final int DESLOCAMENTO = 3;
    public Personagem(){
        this.posicaoEmX = POSICAO_INICIAL_X;
        this.posicaoEmY = POSICAO_INICIAL_Y;
        this.tiros = new ArrayList<Tiro>();
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
            case KeyEvent.VK_UP, KeyEvent.VK_W:
                this.deslocamentoY = -DESLOCAMENTO;
                break;
            case KeyEvent.VK_DOWN, KeyEvent.VK_S:
                this.deslocamentoY = DESLOCAMENTO;
                break;
            case KeyEvent.VK_LEFT, KeyEvent.VK_A:
                this.deslocamentoX = -DESLOCAMENTO;
                break;
            case KeyEvent.VK_RIGHT, KeyEvent.VK_D:
                this.deslocamentoX = DESLOCAMENTO;
                break;
            default:
                break;
        }
    }
    public void parar(KeyEvent tecla){
        int codigo = tecla.getKeyCode();
        switch (codigo){
            case KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_W, KeyEvent.VK_S:
                this.deslocamentoY = 0;
                break;
            case KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_A, KeyEvent.VK_D:
                this.deslocamentoX = 0;
                break;
            default:
                break;
        }
    }
    public void atirar(){
        int frenteDaNave = this.posicaoEmX + this.larguraImagem;
        int meioDaNave = this.posicaoEmY + (this.alturaImagem / 2);
        Tiro tiros = new Tiro(frenteDaNave, meioDaNave);
        this.tiros.add(tiros);
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

    public ArrayList<Tiro> getTiros() {
        return tiros;
    }

    public void setTiros(ArrayList<Tiro> tiros) {
        this.tiros = tiros;
    }
}