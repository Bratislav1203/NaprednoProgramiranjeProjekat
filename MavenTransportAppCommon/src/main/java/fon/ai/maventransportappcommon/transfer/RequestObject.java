/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappcommon.transfer;

import java.io.Serializable;

/**
 * Klasa koja objedinjuje objekte koji se salju kroz mrezu. Zahtev - od klijenta
 * ka serveru.
 *
 * @author Vladimir
 * @version 1.0
 */
public class RequestObject implements Serializable {

    /**
     *Privatni atribut koji predstavlja vrstu operacije.
     */
    private int operation;

    /**
     *Privatni atribut koji predstavlja vrstu podatka koji se salje.
     */
    private Object data;
    
    /**
     *Neparametrizovani konstruktor klase RequestObject.
     */
    public RequestObject(){
    
    }

    /**
     *Parametrizovani konstruktor klase RequestObject koji inicijalizuje novi objekat ove klase.
     * @param operation operacija
     * @param data podatak opsteg tipa
     */
    public RequestObject(int operation, Object data) {
        this.operation = operation;
        this.data = data;
    }

    /**
     *Metoda koja vraca operaciju za konkretan RequestObject.
     * @return operacija
     */
    public int getOperation() {
        return operation;
    }

    /**
     *Metoda koja postavlja operaciju za konkretan RequestObject.
     * @param operation operacija
     */
    public void setOperation(int operation) {
        this.operation = operation;
    }

    /**
     *Metoda koja vraca podatak za konkretan RequestObject.
     * @return podatak
     */
    public Object getData() {
        return data;
    }

    /**
     *Metoda koja postavlja podatak za konkretan RequestObject.
     * @param data podatak
     */
    public void setData(Object data) {
        this.data = data;
    }
    
    
}
