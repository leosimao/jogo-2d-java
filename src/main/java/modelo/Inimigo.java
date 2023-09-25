package modelo;

import javax.swing.ImageIcon;

public class Inimigo extends Grafico {

    public final static int VELOCIDADE_INIMIGO = 2; 

    public Inimigo(int xAleatorio, int yAleatorio){
        this.carregar();
        super.setPosicaoEmX(xAleatorio);
        super.setPosicaoEmY(yAleatorio);
    }
    
    @Override
    public void carregar(){
        ImageIcon imagem = new ImageIcon(getClass().getResource("/inimigo.png"));
        super.setImagem(imagem.getImage());
        super.setAlturaImagem(getImagem().getHeight(null));
        super.setLarguraImagem(getImagem().getHeight(null));
    }

    public void atualizar(){
        super.setPosicaoEmX(getPosicaoEmX() - VELOCIDADE_INIMIGO);
    }
} 
