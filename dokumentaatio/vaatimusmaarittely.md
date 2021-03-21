# Vaatimusmäärittely

## Sovelluksen tarkoitus
Sovelluksella on mahdollista seurata omia menoja ja lisätä tuloja. Sovellusta voivat käyttää rekisteröityneet käyttäjät. Rekisteröitynyt käyttäjä näkee kirjautumisen takana olevan oman budjettinäkymänsä.

## Käyttäjät
Käyttäjärooleja on alkuun vain peruskäyttäjä. Tavoitteena on luoda myös ylläpitäjä, jolla on ennemmän oikeuksia esim peruskäyttäjien hallinointi ( = käyttäjien poistaminen).

## Käyttöliittymäluonnos

Sovellus koostuu neljästä näkymästä. Sovelluksen ensimmäinen ikkuna on kirjautumisnäkymä, josta on mahdollista kirjautua sisään ko. käyttäjän budjettiin tai luoda uusi käyttäjä.
Budjettinäkymästä voi klikata itsensä kaavionäkymään, jossa menot ovat esitettynä kaaviomuodossa.

## Suunnitellut toiminnallisuudet (Perusversio)

### Ennen kirjautumista:
* Käyttäjä voi luoda tunnuksen järjestelmään.
* Käyttäjä voi kirjautua järjestelmään.
 * Kirjautuminen tapahtuu syöttämällä olemassa oleva käyttäjätunnus sille varattuun kohtaan ja klikataan "kirjaudu". 
 * Jos käyttäjää ei löydy, järjestelmä antaa virheviestin.

### Kirjautumisen jälkeen

* Käyttäjä näkee käytettävissä olevat varat kohdassa saldo eli summan, josta on vähennetty ilmoitetut menot.
* Käyttäjä voi kirjata lisää tuloja syöttämällä summan ja klikkaamalla "ok".
* Käyttäjä voi lisätä uuden menon valitsemalla alasvetovalikosta kategorian ja syöttämällä summan ja klikkaamalla "ok".
* Käyttäjä pääsee menojen kaavionäkymään klikkaamalla "luo kaavio menoista".
* Kaavionäkymästä palataan takaisin budjettinäkymään klikkaamalla "palaa takaisin".
* Käyttäjä voi kirjautua ulos järjestelmäst klikkaamalla "kirjaudu ulos".

## Jatkokehitysideat

* Budjettinäkymässä näkyy myös kertyneet menot summana.
* Budjetin nollaaminen
* Yhteenveto menoista eli lista kaikista menoista.
* Käyttäjälle lisätään salasana, joka vaaditaan kirjatuessa.
* Käyttäjätunnuksen poisto ja siihen liittyvän budjetin poistaminen.
* Käyttäjä voi perua väärin merkatut menot.
* Käyttäjälle luodaan mahdollisuus kirjata lisätietoja menoista esim. farkut, hotelliyö tms.
* Käyttäjällä voi olla useampia budjettinäkymiä esim. eri kuukausille
* Useampi käyttäjä voi nähdä ja muokata samaa budjettia esim. perheelle yhteinen budjetti.

