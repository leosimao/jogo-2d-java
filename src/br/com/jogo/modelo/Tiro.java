package br.com.jogo.modelo;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Tiro extends Grafico{

    private Image imageSuperTiro;
    private int alturaImagemSuperTiro;
    private int larguraImagemSuperTiro;

    public static final int VELOCIDADE_TIRO = 2;
    public static final int VELOCIDADE_SUPER = 5;

    public Tiro(int posicaoTiroX, int posicaoTiroY){
        this.carregar();
        this.superTiro();
        super.setPosicaoEmX(posicaoTiroX);
        super.setPosicaoEmY(posicaoTiroY - (super.getAlturaImagem() / 2));
    }

    @Override
    public void carregar(){
        ImageIcon imagem = new ImageIcon("recursos\\tiro.png");
        super.setImagem(imagem.getImage());
        super.setAlturaImagem(super.getImagem().getWidth(null));
        super.setLarguraImagem(super.getImagem().getWidth(null));
    }

    public void superTiro(){
        ImageIcon superTiro = new ImageIcon("recursos\\super_tiro.png");
        this.imageSuperTiro = superTiro.getImage();
        this.alturaImagemSuperTiro = imageSuperTiro.getWidth(null);
        this.larguraImagemSuperTiro = imageSuperTiro.getWidth(null);
    }

    public void atualizar(){
        super.setPosicaoEmX(super.getPosicaoEmX() + VELOCIDADE_TIRO);
    }

    public void atualizarSuper(){
        super.setPosicaoEmX(this.getPosicaoEmX() + VELOCIDADE_SUPER);
    }
}
