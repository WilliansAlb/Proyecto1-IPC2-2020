/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author yelbetto
 */
public class Detectar implements Runnable{
    private boolean corriendo = true;
    int tiempo = 500;

    @Override
    public void run() {
        while (corriendo) {
            try {
                Thread.sleep(getTiempo());
                corriendo = false;
                
            } catch (InterruptedException e) {
                corriendo = false;
            }
        }
    }

    public boolean isCorriendo() {
        return corriendo;
    }

    public void setCorriendo(boolean corriendo) {
        this.corriendo = corriendo;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public void alternando() {
        corriendo = true;
    }
    
}
