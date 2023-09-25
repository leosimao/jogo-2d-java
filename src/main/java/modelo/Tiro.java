package modelo;

import javax.swing.ImageIcon;

public class Tiro extends Grafico{

    public static final int VELOCIDADE_TIRO = 2;

    public Tiro(int posicaoTiroX, int posicaoTiroY){
        this.carregar();
        super.setPosicaoEmX(posicaoTiroX);
        super.setPosicaoEmY(posicaoTiroY - (super.getAlturaImagem() / 2));
    }

    @Override
    public void carregar(){
        ImageIcon imagem = new ImageIcon(getClass().getResource("/tiro.png"));
        super.setImagem(imagem.getImage());
        super.setAlturaImagem(super.getImagem().getWidth(null));
        super.setLarguraImagem(super.getImagem().getWidth(null));
    }
    public void atualizar(){
        super.setPosicaoEmX(super.getPosicaoEmX() + VELOCIDADE_TIRO);
    }
}
