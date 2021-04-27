# Vaatimusmäärittely

## Sovelluksen tarkoitus
Menolaskuri sovellus, jonka tarkoituksena: 
- Mahdollista seurata ja listata omia menoja ylös, jotta saa selville mihin rahaa kuluu eli menolaskuri (= mitä on ostettu ja miten paljon rahaa on kulunut).
- Sovellusta voi käyttää rekisteröityneet käyttäjät
- Rekisteröitynyt käyttäjä näkee kirjautumisen jälkeen omat menotietonsa eli kirjatut menot listana.

## Käyttäjät
Käyttäjärooleja on peruskäyttäjä. Myöhemmin mahdollisesti myös ylläpitäjä, jolla on ennemmän oikeuksia esim peruskäyttäjien hallinointi ( = käyttäjien poistaminen).

## Käyttöliittymäluonnos
Sovellus koostuu kolmesta (3) näkymästä:
1. Kirjautumisnäkymä: voi kirjautua sisään sovellukseen tai luoda uuden käyttäjätunnuksen.
2. Uuden käyttäjätunnuksen luonti: luodaan uusi käyttäjätunnus, josta palataan takaisin kirjautumisnäkymään, kun tunnus on luotu onnistuneesti.
3. Menolistanäkymä: kirjautunut käyttäjä näkee omat kirjaamansa menotiedot.

## Suunnitellut toiminnallisuudet (Perusversio)

### Ennen kirjautumista:
* Käyttäjä voi luoda tunnuksen järjestelmään.
* Käyttäjä voi kirjautua järjestelmään.
 * Kirjautuminen tapahtuu syöttämällä olemassa oleva käyttäjätunnus sille varattuun kohtaan ja klikataan "kirjaudu". 
 * Jos käyttäjää ei löydy, järjestelmä antaa virheviestin.

### Kirjautumisen jälkeen

* Käyttäjä näkee listan kirjatuista menoista.
* Käyttäjä voi kirjata lisää menoja syöttämällä tuotteen nimen ja klikkaamalla "ok".
* Käyttäjä voi lisätä menolle summan, kuinka paljon se on maksanut.
* Menolistanäkymässä on yhteenlaskettu summa menojen kuluista.
* Käyttäjä voi kirjautua ulos järjestelmäst klikkaamalla "kirjaudu ulos".

## Jatkokehitysideat

* Menolistanäkymässä näkyisi myös kertyneet menot summana.
* Yhteenveto menoista eli lista kaikista menoista.
* Menolaskurin laajennus budjettilaskuriksi, johon voi lisätä tulotietoja.
* Käyttäjälle lisätään salasana, joka vaaditaan kirjatuessa.
* Käyttäjätunnuksen poisto ja siihen liittyvän menolistan poistaminen.
* Käyttäjä voi perua väärin merkatut menot.
* Käyttäjällä voi olla useampia menolistoja esim. eri kuukausille.
* Useampi käyttäjä voi nähdä ja muokata samaa budjettia esim. perheelle yhteinen budjetti.

