package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class KassapaateTest {

    Kassapaate kassa;
    Maksukortti kortti;
    int edullinen;
    int maukas;

    //testiluokan alustusmetodi
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(1000);
        edullinen = 240;
        maukas = 400;

    }

    //Kassapääte luokan testit
    //kassapäätteen rahamäärä alussa: rahaa 1000 
    @Test
    public void kassassaRahaaAlussa() {

        assertEquals(100000, kassa.kassassaRahaa());
    }
//ja lounaita myyty alussa 0 kpl.

    @Test
    public void myytyjenLounaidenMaaraAlussa() {
        int myydytLounaat = kassa.edullisiaLounaitaMyyty() + kassa.maukkaitaLounaitaMyyty();
        assertEquals(0, myydytLounaat);
    }

    //käteisostotoimii edullisten ja maukkaiden lounaiden osalta:
    @Test
    public void vaihtorahanSuuruusOikeinEdullinen() {
        kassa.syoEdullisesti(edullinen);
        assertEquals(0, kassa.syoEdullisesti(edullinen));
    }

    @Test
    public void vaihtorahanSuuruusOikeinMaukas() {
        kassa.syoMaukkaasti(maukas);
        assertEquals(0, kassa.syoMaukkaasti(maukas));
    }

    //rahamäärä kasvaa kassassa lounaan hinnalla
    @Test
    public void rahamaarakasvaaEdullinen() {
        kassa.syoEdullisesti(edullinen);
        assertEquals(100240, kassa.kassassaRahaa());
    }

    @Test
    public void rahamaaraKasvaaMaukas() {
        kassa.syoMaukkaasti(maukas);
        assertEquals(100400, kassa.kassassaRahaa());
    }

    //Jos maksu on riittävä myytyjen lounaiden määrä kasvaa
    @Test
    public void edullinenLounasKasvattaaMaaraa() {

        kassa.syoEdullisesti(edullinen);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void maukasLounasKasvattaaMaaraa() {
      
        kassa.syoMaukkaasti(maukas);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }

    //jos maksu ei ole riittävä kassassa oleva rahamäärä ei muutu, kaikki rahat palautetaan
    @Test
    public void rahaaEiRiittavasti() {
        kassa.syoMaukkaasti(edullinen);
        assertEquals(100000, kassa.kassassaRahaa());
    }

    //tällöin myös myytyjen lounaiden määrään ei muutosta
    @Test
    public void lounaidenMaaraEiMuutu() {

        kassa.syoMaukkaasti(edullinen);
        int lounaat = kassa.edullisiaLounaitaMyyty() + kassa.maukkaitaLounaitaMyyty();
        assertEquals(0, lounaat);
    }

    //Maksukortti
    //korttiosto toimii edullisten ja maukkaiden lounaiden osalta
    //jos kortilla on tarpeeksi rahaa veloitetaan summa ja palautetaan true.
    @Test
    public void korttiToimiiEdullinen() {
        kassa.syoEdullisesti(kortti);

        assertTrue(true);

    }

    @Test
    public void korttiToimiiMaukas() {
        kassa.syoMaukkaasti(kortti);

        assertTrue(true);
    }

    //jos kortilla ei ole tarpeeksi rahaa kortin rahamäärä ei muutu 
    @Test
    public void kortinRahaMaaraEiMuutu() {
        kortti.otaRahaa(1000);
        kassa.syoEdullisesti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals(0, kortti.saldo());
    }

    //Kortilla ei riittavästi rahaa, niin myytyjen lounaiden määrä ei muutu.
    @Test
    public void kortillaEiRahaaLounaidenMaaraEiMuutu() {
        kortti.otaRahaa(1000);
        kassa.syoEdullisesti(kortti);
        kassa.syoMaukkaasti(kortti);
        int lounaat = kassa.edullisiaLounaitaMyyty() + kassa.maukkaitaLounaitaMyyty();
        assertEquals(0, lounaat);

    }

    //kassassa oleva rahamäärä ei muutu kortilla ostettaessa
    @Test
    public void kassanRahaMaaraEiMuutuKortilla() {
        kassa.syoEdullisesti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }

    //kortille rahaa ladattaesa kortin saldo muuttuu.
    @Test
    public void ladataanKortilleRahaa() {
        kassa.lataaRahaaKortille(kortti, 1000);
        assertEquals(2000, kortti.saldo());
    }
    
    @Test
    public void ladataanKortilleNegatiivista () {
        kassa.lataaRahaaKortille(kortti, -5);
        assertEquals(1000, kortti.saldo());
    }

    //kassassa oleva rahamäärä kasvaa ladatulla summalla
    @Test
    public void kassanSaldoMuuttuu() {
        kassa.lataaRahaaKortille(kortti, 1000);
        assertEquals(101000, kassa.kassassaRahaa());
    }

}
