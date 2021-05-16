#**ItemList – Pakkauslista sovellus**

Helsingin yliopiston [Ohjelmistotekniikan](https://ohjelmistotekniikka-hy.github.io/) kurssille kevät 2021 toteutettu harjoitustyö. Projektina on JavaFX sovellus.

_Mitä mukaan reissuun tai matkalle ? Pakkauslista on kätevä tapa laittaa muistiin tuotteet/tavarat, jotka haluat muistaa pakata reissua varten._

Sovelluksen avulla käyttäjän on mahdollista luoda yksilöllinen pakkauslista. Pakkauslista sovellusta käytetään sisäänkirjautuneena. Useampi rekisteröitynyt käyttäjä voi käyttää sovellusta, ja jokainen pääsee omaan pakkauslistaansa. Sovellus on hyvin yksinkertainen mallinnus pakkauslistasta.


## Dokumentaatio

* [Käyttöohje](https://github.com/repemi/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)
* [Vaatimusmäärittely](https://github.com/repemi/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)
* [Arkkitehtuurikuvaus](https://github.com/repemi/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)
* [Testausdokumentti] (TYHJÄ)
* [Työaikakirjanpito](https://github.com/repemi/ot-harjoitustyo/blob/master/dokumentaatio/tyoaikakirjanpito.md)


## Releaset



## Komentorivitoiminnot

Siirry ensin kansioon:

```
cd ItemList/
```
Ohjelman saa suoritettua komennolla:

```
mvn compile exec:java -Dexec.mainClass=itemlist.Main
```

### Testaus


Testit voi suorittaa komennolla:
```
mvn test
```

Testikattavuusraportti saadaan luotua komennolla:
```
mvn test jacoco:report
```
Testiraportti löytyy -> _target/site/jacoco/index.html_

Checkstyle raportin saa komennolla: 

```
mvn jxr:jxr checkstyle:checkstyle
```
Checkstyle raportti löytyy -> _target/site/checkstyle.html_

### JavaDoc

JavaDoc luodaan komennolla:
```
mvn javadoc:javadoc
```
dokumenttia pääset tarkastelemaan kun avaat
*target/site/apidocs/index.html* selaimessa.

### Suoritettava jar luodaan: 

komento:
```
mvn package
```
komento generoi target hakemistoon suoritettavan jar-tiedoston 
 
*Kun ItemList-1.0-SNAPSHOT.jar tiedosto löytyy target kansiosta. Siirrä se samaan kansioon, mistä löytyy config.properties eli ItemList kansion alle, jossa jar tiedosto on mahdollista ajaa.*
