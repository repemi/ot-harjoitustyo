package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    //kortin saldo alussa oikein
    @Test
    public void kortinSaldoAlussaOikein() {
        kortti.saldo();
        assertEquals("saldo: 10.0", kortti.toString());
    }

    // rahan lataaminen kasvattaa saldoa oikein
    @Test
    public void lataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(1000);
        assertEquals("saldo: 20.0", kortti.toString());
    }

    //rahan ottaminen toimii:
    // saldo vähenee oikein, jos rahaa on tarpeeksi
    @Test
    public void saldoVaheneeOikein() {
        kortti.otaRahaa(1000);
        assertEquals("saldo: 0.0", kortti.toString());
    }

    // saldo ei muutu, jos rahaa ei ole tarpeeksi
    @Test
    public void saldoEiMuutuJosRahaaEiOle() {
        kortti.otaRahaa(1000);
        kortti.otaRahaa(1000);
        assertEquals("saldo: 0.0", kortti.toString());
    }

    // metodi palauttaa true, jos rahat riittivät, muuten false.
    @Test
    public void rahaaRiittavastiPalauttaaTrue() {

        assertTrue("true", kortti.otaRahaa(1000));
    }
}
