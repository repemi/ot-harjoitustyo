# **Ohjelmistotekniikka, harjoitustyö**
Helsingin yliopiston [Ohjelmistotekniikan](https://ohjelmistotekniikka-hy.github.io/) kurssille kevät 2021 toteutettu harjoitustyö.
Projektina on JavaFX sovellus, jolla tunnuksen luonut käyttäjä voi kirjata ja seurata omia menojaan.

Sovellus ExpenseCounter (menolaskuri) löytää [täältä](https://github.com/repemi/ot-harjoitustyo/tree/master/ExpenseCounter)


## Dokumentaatio

* [Vaatimusmäärittely](https://github.com/repemi/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)
* [Työaikakirjanpito](https://github.com/repemi/ot-harjoitustyo/blob/master/dokumentaatio/tyoaikakirjanpito.md)
* [Arkkitehtuurikuvaus](https://github.com/repemi/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

## Releaset



## Komentorivitoiminnot

Siirry ensin kansioon:

```
cd ExpenseCounter/
```
Ohjelman saa suoritettua komennolla:

```
mvn compile exec:java -Dexec.mainClass=expensecounter.Main
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
 
*Kun ExpenseCounter-1.0-SNAPSHOT.jar tiedosto löytyy target kansiosta. Siirrä se samaan kansioon, mistä löytyy config.properties eli ExpensesCounter kansion alle, jossa jar tiedosto on mahdollista ajaa.*
