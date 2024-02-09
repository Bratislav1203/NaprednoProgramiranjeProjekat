/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappserver.so.impl;


import fon.ai.maventransportappcommon.domain.IGeneralEntity;
import fon.ai.maventransportappcommon.domain.Drive;
import fon.ai.maventransportappserver.so.AbstractGenericOperation;

/**
 * Klasa {@code UpdateDriveOperation} specijalizovana je za operaciju ažuriranja
 * vožnji (Drive) u bazi podataka. Ova operacija proverava da li je prosleđeni
 * objekat instance klase {@code Drive} i izvršava ažuriranje tog objekta
 * u bazi.
 * 
 * Nasleđuje apstraktne metode {@code validate} i {@code execute} iz klase
 * {@code AbstractGenericOperation}, primenjujući specifičnu logiku validacije i izvršenja
 * za ažuriranje vožnji.
 * 
 * @author Bratislav
 */
public class UpdateDriveOperation extends AbstractGenericOperation {

    /**
     * Proverava da li je prosleđeni objekat instance klase Drive
     * Ako objekat nije validan, baca izuzetak.
     * 
     * @param entity objekat koji se validira, očekuje se da bude tipa Drive
     * @throws Exception ako objekat nije instance klase Drive, signalizira
     *                   da prosleđeni objekat nije validan za ažuriranje.
     */
    @Override
    public void validate(Object entity) throws Exception {
        if (!(entity instanceof Drive)) {
            throw new Exception("Objekat nije validan!");
        }
        
    }

    /**
     * Izvršava ažuriranje prosleđene vožnje (Drive) u bazi podataka.
     * Pre izvršenja, objekat se validira metodom validate
     * 
     * @param entity objekat vožnje koji se ažurira, očekuje se da bude tipa Drive
     * @throws Exception ako ažuriranje nije uspešno, bilo zbog problema u bazi
     *                   podataka ili nevalidnog objekta.
     */
    @Override
    public void execute(Object entity) throws Exception {
        db.izmeni((IGeneralEntity) entity);
        
    }


}
