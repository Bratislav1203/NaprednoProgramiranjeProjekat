/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappcommon.util;

/**
 * Klasa u kojoj su navedene sve konstante operacija koje odredjuju tip
 * klijentskog zahteva ili serverskog odgovora.
 *
 * @author Vladimir
 * @version 1.0
 */
public class Operation {

    /**
     *Privatni atribut koji predstavlja vrstu operacije.
     */
    public static final int LOGIN = 1; //u seminarskom slucaj koriscenja 1 : Prijavljivanje na sistem

    /**
     *Privatni atribut koji predstavlja vrstu operacije.
     */
    public static final int SAVE_DRIVER = 2;

    /**
     *Privatni atribut koji predstavlja vrstu operacije.
     */
    public static final int SAVE_VEHICLE = 3;

    /**
     *Privatni atribut koji predstavlja vrstu operacije.
     */
    public static final int SAVE_DRIVE = 4;

    /**
     *Privatni atribut koji predstavlja vrstu operacije.
     */
    public static final int SAVE_TRUCK = 5;

    /**
     *Privatni atribut koji predstavlja vrstu operacije.
     */
    public static final int SAVE_TRAILER = 6;

    /**
     *Privatni atribut koji predstavlja vrstu operacije.
     */
    public static final int VRATI_VOZACE = 7;

    /**
     *Privatni atribut koji predstavlja vrstu operacije.
     */
    public static final int TAKE_TRUCKS = 8;

    /**
     *Privatni atribut koji predstavlja vrstu operacije.
     */
    public static final int TAKE_TRAILERS = 9;

    /**
     *Privatni atribut koji predstavlja vrstu operacije.
     */
    public static final int TAKE_DRIVES = 10;

    /**
     *Privatni atribut koji predstavlja vrstu operacije.
     */
    public static final int DELETE_DRIVE = 11;

    /**
     *Privatni atribut koji predstavlja vrstu operacije.
     */
    public static final int TAKE_DRIVE_BY_ID = 12;

    /**
     *Privatni atribut koji predstavlja vrstu operacije.
     */
    public static final int UPDATE_DRIVE = 13;

    /**
     *Privatni atribut koji predstavlja vrstu operacije.
     */
    public static final int TAKE_COST = 14;
    
}
