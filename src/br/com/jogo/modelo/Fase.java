package br.com.jogo.modelo;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public abstract class Fase extends JPanel implements ActionListener, KeyListener{
    
    protected Image fundo;
    protected Personagem personagem;
    protected ArrayList<Inimigo> inimigos;
    protected Timer timer;
    protected boolean emJogo = true;
    protected ArrayList<Asteroide> asteroides;

    public static final int DELAY = 5;
    public static final int QUANTIDADE_INIMIGOS = 40;
    public static final int QUANTIDADE_ASTEROIDES = 40;

    public Fase(){
        setFocusable(true);
        setDoubleBuffered(true);
        addKeyListener(this);
    }

    public abstract void inicializarInimigo();
    public abstract void verificarColisoes();
    public abstract void inicializarElementosGraficosAdicionais();

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
