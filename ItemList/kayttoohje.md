### Alustava käyttöohje

Lataa tiedosto expensecounter.jar(LINKKI TÄHÄN)

## Konfigurointi

Ohjelmassa tulee olla sen käynnistyshakemistosssa config.properties, jossa määritellään  tallettavien tiedostojen nimet. Tiedosto sisältö on seuraavanlainen:

```
userFile=users.txt
expenseFile=expenses.txt

```

## Ohjelman käynnistys

Ohjelma saadaan käynnistettya komennolla. HUOM! _Tätä ennen kuitenkin tulee siirtää tiedosto.jar target kansiosta ExpensesCounter kansioon ja käynnistää se sieltä käsin._

```
java -jar tiedosto.jar
```

## Sovelluksen toiminnallisuudet

- Sovellus aukeaa kirjautumisnäkymään. 
	Näkymästä pääsee luomaan uuden käyttäjän klikkaamalla _luo uusi käyttäjä_ tai 
	siirtymällä laskuriin klikkaamalla _kirjaudu_ 

- Uuden käyttäjän luominen tapahtuu:
	luodaan tunnus, jos sellaista ei vielä ole, syöttämällä kenttiin _tunnus_  valinnainen	
	käyttäjätunnus, joka on minimissään 2 merkkiä sekä käyttäjän _nimi_. 
	Tunnusta tarvitaan sisään kirjautumiseen.

- Menolaskuriin päästään sisälle kirjoittamalla kohtaan tunnus äskettäin luotu tunnus tai vanha käytössä oleva tunnus.

-Menolaskurissa:
	on mahdollista lisätä tuotteita, joihin kuluttanut rahaa.


