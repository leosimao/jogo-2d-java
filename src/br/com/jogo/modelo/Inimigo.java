package br.com.jogo.modelo;

import javax.swing.ImageIcon;

public class Inimigo extends Grafico {

    public final static int VELOCIDADE_INIMIGO = 2; 

    public Inimigo(int xAleatorio, int yAleatorio){
        super.setPosicaoEmX(super.getPosicaoEmX() + yAleatorio);
        super.setPosicaoEmX(super.getPosicaoEmY() + yAleatorio);
    }
    
    public void carregar(){
        ImageIcon imagem = new ImageIcon("recursos//inimigo.png");
        super.setImagem(imagem.getImage());
        super.setAlturaImagem(getImagem().getHeight(null));
        super.setLarguraImagem(getImagem().getHeight(null));
    }

    public void atualizar(){
        super.setPosicaoEmX(getPosicaoEmX() - VELOCIDADE_INIMIGO);
    }

    public void add(Inimigo inimigo) {
    }
}
