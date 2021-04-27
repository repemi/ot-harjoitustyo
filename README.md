# **Ohjelmistotekniikka, harjoitustyö**
Helsingin yliopiston Ohjelmistotekniikka kurssille kevät 2021 toteutettu harjoitustyö.
Projektina on JavaFX sovellus, jolla seurataan menoja.

Sovellus ExpenseCounter (menolaskuri) löytää [täältä](https://github.com/repemi/ot-harjoitustyo/tree/master/ExpenseCounter)
BudgetApp on vanhaversio, joka ei ole käytössä - se on tarkoitus poistaa.


## Dokumentaatio

* [Vaatimusmäärittely](https://github.com/repemi/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)
* [Työaikakirjanpito](https://github.com/repemi/ot-harjoitustyo/blob/master/dokumentaatio/tyoaikakirjanpito.md)
* [Arkkitehtuurikuvaus](https://github.com/repemi/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md) tyhjä!

## Releaset



## Komentorivitoiminnot

Siirry ensin kansioon 

```
cd ExpenseCounter/
```

### Testaus

Testit voi suorittaa komennolla:
```
mvn test
```

Testikattavuusraportti saadaan luotua komennolla:
```
mvn jacoco:report
```

Luo suoritettava jar tiedosto:
```
mvn package
```
Checkstyle raportti ei ole tällä hetkellä toiminnassa.
Muulloin se toimii komennolla:

```
mvn jxr:jxr checkstyle:checkstyle
```
 

