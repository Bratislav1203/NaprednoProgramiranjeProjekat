/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappcommon.domain;

/**
 * Enum koji predstavlja vrstu troska.
 *
 * @author Bratislav
 * @version 1.0
 * @see CostType
 */
public enum CostType {

    /**
     *Atribut koji predstavlja trosak plate zaposlenom.
     */
    driverSallary,

    /**
     *Atribut koji predstavlja trosak za gorivo.
     */
    fuel,

    /**
     *Atribut koji predstavlja trosak putarine.
     */
    toll,

    /**
     *Atribut koji predstavlja ostale troskove.
     */
    other
}
