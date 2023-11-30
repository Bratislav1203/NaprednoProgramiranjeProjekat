/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappcommon.transfer;

import java.io.Serializable;
import fon.ai.maventransportappcommon.util.ResponseStatus;

/**
 * Klasa koja objedinjuje objekte koji se salju kroz mrezu. Serverski odgovor -
 * od servera ka klijentu.
 *
 * @author Vladimir
 * @version 1.0
 */
public class ResponseObject implements Serializable{

    /**
     *Privatni atribut koji predstavlja vrstu podatka koji se prima.
     */
    private Object data;

    /**
     *Privatni atribut koji predstavlja vrstu izuzetka koji se eventualno uhvati.
     */
    private Exception exception;

    /**
     *Privatni atribut koji predstavlja status odgovora servera.
     */
    private ResponseStatus status;

    /**
     *Parametrizovani konstruktor klase ResponseObject koji inicijalizuje novi objekat ove klase.
     * @param data podatak
     * @param exception izuzetak
     * @param status status odgovora
     */
    public ResponseObject(Object data, Exception exception, ResponseStatus status) {
        this.data = data;
        this.exception = exception;
        this.status = status;
    }
    
    /**
     *Neparametrizovani konstruktor klase ResponseObject.
     */
    public ResponseObject() {
    }

    /**
     *Parametrizovani konstruktor klase ReponseObject koji inicijalizuje vrednosti objekta ove klase.
     * @param data podatak
     * @param exception izuzetak
     */
    public ResponseObject(Object data, Exception exception) {
        this.data = data;
        this.exception = exception;
    }

    /**
     *Metoda koja vraca uhvaceni izuzetak.
     * @return izuzetak
     */
    public Exception getException() {
        return exception;
    }

    /**
     *Metoda koja postavlja uhvaceni izuzetak.
     * @param exception izuzetak
     */
    public void setException(Exception exception) {
        this.exception = exception;
    }

    /**
     *Metoda koja vraca konkretan podatak.
     * @return podatak
     */
    public Object getData() {
        return data;
    }

    /**
     *Metoda koja postavlja konkretan podatak.
     * @param data podatak
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     *Metoda koja vraca status odgovora.
     * @return status status
     */
    public ResponseStatus getStatus() {
        return status;
    }

    /**
     *Metoda koja postavlja status odgovora.
     * @param status status
     */
    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
    
    
}
