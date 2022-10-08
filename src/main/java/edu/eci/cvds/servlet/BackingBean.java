package edu.eci.cvds.servlet;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.Random;

@ManagedBean(name = "guessBean")
@ApplicationScoped
public class BackingBean {
    private int number;
    private int tries;
    private int pool;
    private String gameState;

    public BackingBean() {
        pool = 100000;
    }

    public void guess(int guessNumber) {
        if(number == guessNumber) {
            gameState = "Ganaste con numero de intentos : " + tries + "Y con un premio de : " + pool;
        } else {
            pool -= 10000;
            tries ++;
        }
    }

    public void restart() {
        Random numberRandom = new Random();
        number = numberRandom.nextInt(100);
        pool = 100000;
        tries = 0;
        gameState = "Jugando";
    }

    public int getNumber() {
        return number;
    }

    public int getTries() {
        return tries;
    }

    public int getPool() {
        return pool;
    }

    public String getGameState() {
        return gameState;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }

    public void setPool(int pool) {
        this.pool = pool;
    }

    public void setGameState(String gameState) {
        this.gameState = gameState;
    }
}
