package br.com.jogo.modelo;

import javax.swing.ImageIcon;

import br.com.jogo.principal.Principal;

public class Asteroide extends Grafico {

    private static final int VELOCIDADE_ASTEROIDE = 1;

    public Asteroide(int xAleatorio, int yAleatorio ){
        this.carregar();
        super.setPosicaoEmX(xAleatorio);
        super.setPosicaoEmY(yAleatorio);
    }

    @Override
    public void carregar() {
        ImageIcon carregando = new ImageIcon("recursos\\asteroide.png");
        super.setImagem(carregando.getImage());
    }

    @Override
    public void atualizar() {
        if(this.getPosicaoEmX() < 0){
            int y = (int) (Math.random() * Principal.ALTURA_DA_TELA);
            super.setPosicaoEmX(Principal.LARGURA_DA_TELA);
            super.setPosicaoEmY(y);

        }else {
            super.setPosicaoEmX(super.getPosicaoEmX() - VELOCIDADE_ASTEROIDE);
        }
    }
    
}
