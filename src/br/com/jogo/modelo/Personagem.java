package br.com.jogo.modelo;

import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Personagem extends Grafico {
    private int deslocamentoX;
    private int deslocamentoY;
    private ArrayList<Tiro> tiros;

    public static final int POSICAO_INICIAL_X = 100;
    public static final int POSICAO_INICIAL_Y = 100;
    public static final int DESLOCAMENTO = 3;

    public Personagem(){
        super.setPosicaoEmX(POSICAO_INICIAL_X);
        super.setPosicaoEmY(POSICAO_INICIAL_Y);
        this.tiros = new ArrayList<Tiro>();
    }
    
    @Override
    public void carregar(){
        ImageIcon imagem = new ImageIcon("recursos//nave.png");
        super.setImagem(imagem.getImage());
        super.setAlturaImagem(super.getImagem().getWidth(null));
        super.setLarguraImagem(super.getImagem().getHeight(null));
    }

    public void atualizar(){
        setPosicaoEmX(getPosicaoEmX() + this.deslocamentoX);
        setPosicaoEmY(getPosicaoEmY() + this.deslocamentoY);
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
        int frenteDaNave = super.getPosicaoEmX() + super.getLarguraImagem();
        int meioDaNave = super.getPosicaoEmY() + (super.getAlturaImagem() / 2);
        Tiro tiros = new Tiro(frenteDaNave, meioDaNave);
        this.tiros.add(tiros);
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

    public ArrayList<Tiro> getTiros() {
        return tiros;
    }

    public void setTiros(ArrayList<Tiro> tiros) {
        this.tiros = tiros;
    }
}