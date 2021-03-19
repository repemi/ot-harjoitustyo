
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MaksukorttiTest {

    //Kohteena oleva maksukortti talletaan testiluokan oliomuuttujaan.
    //Näin tehdään, jotta testimetodit pystyvät näkemään metodin setUp luoman maksukortin.
    Maksukortti kortti;

    public MaksukorttiTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }
//Suoritetaan ennen jokaista testitapausta eli testimetodia
    @Before
    public void setUp() {
        //Jokainen testitapaus aloittaa tilanteesta, jossa kortin saldo on 10.
        kortti = new Maksukortti(10);
    }

    @After
    public void tearDown() {
    }

//     TODO add test methods here.
//     The methods must be annotated with annotation @Test. For example:
    @Test
    public void hello() {
    }

    //Testi varmistaa, että konstruktorin parametrina oleva luku menee kortin alkusaldoksi.
    @Test
    public void konstruktoriAsettaaSaldonOikein() {

        String vastaus = kortti.toString();

        assertEquals("Kortilla on rahaa 10.0 euroa", vastaus);
    }

    //Testi varmistaa, että tulos pienentynyt edullisen lounaan hinnan verran.
    @Test
    public void syoEdullisestiVahentaaSaldoaOikein() {

        kortti.syoEdullisesti();

        assertEquals("Kortilla on rahaa 7.5 euroa", kortti.toString());
    }

    @Test
    public void syoMaukkaastiVahentaaSaldoaOikein() {

        kortti.syoMaukkaasti();
        assertEquals("Kortilla on rahaa 6.0 euroa", kortti.toString());
    }

    @Test
    public void syoEdullisestiEiVieSaldoaNegatiiviseksi() {

        kortti.syoMaukkaasti();
        kortti.syoMaukkaasti();
        //kortin saldo on 2
        kortti.syoEdullisesti();

        assertEquals("Kortilla on rahaa 2.0 euroa", kortti.toString());
    }
    
    @Test
    public void kortilleVoiLadataRahaa() {
        kortti.lataaRahaa(25);
        assertEquals("Kortilla on rahaa 35.0 euroa", kortti.toString());
    }
    
    @Test
    public void kortinSaldoEiYlitaMksimiarvoa() {
        kortti.lataaRahaa(200);
        assertEquals("Kortilla on rahaa 150.0 euroa", kortti.toString());
    }
    
    // Laskaritehtävän metodit:
    //Huom! assertEquals komennot aina, että ensimmäinen parametri on odotettu tulos ja jälkimmäinen
    //testatun metodin antama tulos.
    
    //maukkaan lounaan syöminen ei vie saldoa negatiiviseksi
    @Test
    public void syoMaukkaastiEiVieSaldoaNegatiiviseksi(){
        kortti.syoMaukkaasti();
        kortti.syoMaukkaasti();
        kortti.syoMaukkaasti();
        assertEquals("Kortilla on rahaa 2.0 euroa", kortti.toString());
    }
    //negatiivisen summan lataaminen ei muuta saldoa
    @Test
    public void negatiivisenSummanLataaminenEiMuutaSaldoa() {
        kortti.lataaRahaa(-5);
        assertEquals("Kortilla on rahaa 10.0 euroa", kortti.toString());
    }
    //kortilla pystyy ostamaan edullisen lounaan kun kortilla rahaa vain edullisen lounaan verran (2.5e)
    @Test
    public void kortillaRahaaVainEdullinenLounas (){
        Maksukortti edullinen = new Maksukortti(2.5);
        
        edullinen.syoEdullisesti();
        assertEquals("Kortilla on rahaa 0.0 euroa", edullinen.toString());
    }
    //kortilla pystyy ostamaan maukkaan lounaan kun kortilla rahaa vain maukkaan lounaan verran (4e)
    @Test
    public void kortillaRahaaVainMaukasLounas (){
        Maksukortti maukas = new Maksukortti(4.0);
        
        maukas.syoMaukkaasti();
        assertEquals("Kortilla on rahaa 0.0 euroa", maukas.toString());
    }
    


}
