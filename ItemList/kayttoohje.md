### Käyttöohje

Lataa tiedosto itemlist.jar(LINKKI TÄHÄN)

## Konfigurointi

Ohjelma tulee olla sen käynnistyshakemistossa _config.properties_, jossa määritellään talletettavien tiedostojen nimet. Tiedostojen nimet ovat seuraavanlaiset:

```
userFile=users.txt
itemFile=items.txt

```

## Ohjelman käynnistys

Ohjelma saadaan käynnistettya komennolla. 
_HUOM! Tätä ennen tiedosto.jar target tulee siirtää _target kansisosta _ItemList kansioon ja käynnistää se sieltä käsin._

```
java -jar tiedosto.jar
```

## Sovelluksen toiminnallisuudet

- Sovellus aukeaa kirjautumisnäkymään. 
	Näkymästä pääsee luomaan uuden käyttäjän klikkaamalla _luo uusi käyttäjä_ tai siirtymällä 	
	laskuriin klikkaamalla _kirjaudu_ 

![](./kuvat/kirjautuminen.png)

- Uuden käyttäjän luominen tapahtuu:
	luodaan tunnus, jos sellaista ei vielä ole, syöttämällä kenttiin _tunnus_  valinnainen 	käyttäjätunnus, joka on 	minimissään 2 merkkiä sekä käyttäjän _nimi_. Tunnusta tarvitaan sisään kirjautumiseen.

![](./kuvat/uusikayttaja.png)

- Pakkauslista sovellukseen päästään sisälle kirjoittamalla kohtaan _tunnus_ äskettäin luotu tunnus tai vanha käytössä oleva tunnus.

![](./kuvat/pakkauslista.png)

-Pakkauslistassa:
	on mahdollista lisätä tuotteita muistiin, joita haluaa vaikkapa pakata matkalle mukaan. Se
	tapahtuu kirjoittamalla alhaalla olevaan tyhjään kenttään tuote ja painamalla sen jälkeen _lisää_.
	Jos tuotte on pakattu jo tai sen muusta syystä haluaa poistaa listalta tulee painaa tuotteen nimen vieressä
	olevaa nappia _x_.

	Jos sovelluksen haluaa sulkea tai poistua näkymästä tulee kirjautua pihalle, _kirjaudu ulos_. Jolloin sovellus
	palaa takaisin kirjautumisnäkymään.
