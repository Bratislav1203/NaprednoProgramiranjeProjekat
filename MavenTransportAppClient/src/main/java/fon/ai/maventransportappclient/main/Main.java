/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappclient.main;

import fon.ai.maventransportappclient.client.forms.FLogin;
import javax.swing.JFrame;

/**
 *
 * @author stackOverflow
 */
public class Main {
    public static void main(String[] args){
        JFrame login = new FLogin();
        login.setVisible(true);
        System.out.println("Just test Client");
    }
}
