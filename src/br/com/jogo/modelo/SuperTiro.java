package br.com.jogo.modelo;

import javax.swing.ImageIcon;

public class SuperTiro extends Grafico{

    public static final int VELOCIDADE_SUPER = 5;

    public SuperTiro(int posicaoTiroX, int posicaoTiroY){
        this.carregar();
        super.setPosicaoEmX(posicaoTiroX);
        super.setPosicaoEmY(posicaoTiroY);
    }

    @Override
    public void carregar(){
        ImageIcon image = new ImageIcon("recursos\\super_tiro.png");
        super.setImagem(image.getImage());
        super.setAlturaImagem(getImagem().getWidth(null));
        super.setLarguraImagem(getImagem().getHeight(null));
    }

    public void atualizarSuper(){
        super.setPosicaoEmX(super.getPosicaoEmX() + VELOCIDADE_SUPER);
    }   
}
