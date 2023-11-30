/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappclient.sesija;

import fon.ai.maventransportappcommon.domain.User;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author stackOverflow
 */
public class Sesija {
    private Socket socket;
    private static Sesija sesija;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private User ulogovaniKorisnik;

    private Sesija() throws IOException {
    }

    public static Sesija getSesija() throws IOException {
        if(sesija == null)
            sesija = new Sesija();
        return sesija;
    }

    public ObjectInputStream getOis() {
        return ois;
    }

    public void setOis(ObjectInputStream ois) {
        this.ois = ois;
    }

    public ObjectOutputStream getOos() {
        return oos;
    }

    public void setOos(ObjectOutputStream oos) {
        this.oos = oos;
    }

    public User getUlogovaniKorisnik() {
        return ulogovaniKorisnik;
    }

    public void setUlogovaniKorisnik(User ulogovaniKorisnik) {
        this.ulogovaniKorisnik = ulogovaniKorisnik;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
    
}
