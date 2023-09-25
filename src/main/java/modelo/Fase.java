package modelo;
//Alterar os pacotes do projeto

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

//Alterar o nome da classe par Principal, pois será a classe que irá controlar tudo.
public abstract class Fase extends JPanel implements ActionListener, KeyListener{
    
    protected Image fundo;
    protected Personagem personagem;
    protected ArrayList<Inimigo> inimigos;
    protected Timer timer;
    protected boolean emJogo = true;
    protected ArrayList<Asteroide> asteroides;

    public static final int DELAY = 5;
    public static final int QUANTIDADE_INIMIGOS = 40;
    public static final int QUANTIDADE_ASTEROIDES = 20;

    public Fase(){
        setFocusable(true);
        setDoubleBuffered(true);
        addKeyListener(this);
    }

    public abstract void inicializarInimigo();
    public abstract void verificarColisoes();
    public abstract void inicializarElementosGraficosAdicionais();

    public void desenhaPontuacao(Graphics2D graficos){
        String textoPontuacao = "Pontos " + personagem.getPontuacao();
        graficos.setFont(new java.awt.Font("Segoe UI",java.awt.Font.PLAIN, 22));
        graficos.setColor(new java.awt.Color(255, 255, 255));
        graficos.drawString(textoPontuacao, 20, 25);
    }

    public void desenhaVidas(Graphics2D graficos){
        String textoVida = "Vidas Restantes " + personagem.getVidas();
        graficos.setFont(new java.awt.Font("Segoe UI",java.awt.Font.PLAIN, 22));
        graficos.setColor(new java.awt.Color(255, 255, 255));
        graficos.drawString(textoVida, 20, 50);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public abstract void keyPressed(KeyEvent e);

    @Override
    public abstract void keyReleased(KeyEvent e);

    @Override
    public abstract void actionPerformed(ActionEvent e);
}
