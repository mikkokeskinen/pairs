# Pairs in Clojure

> Sinun tulee soveltaa variaatiota rakkausprosenttialgoritmista. Tämä erityisesti parikoodauksen helpottamiseen tarkoitettu laskutapa on saanut nimekseen PAIRS. Laskukaava toimii seuraavasti:
> 
> Oletetaan, että tarkoitus on selvittää kahden reaktorilaisen, Matti Meikäläisen (nimi muutettu) sekä Erkki Esimerkin (nimi muutettu), parikoodausyhteensopivuus. Laskutavan ensimmäinen vaihe on laskea PAIRS-sanan sisältämien kirjainten määrä kummassakin nimessä. Tulokseksi saadaan [P = 0, A = 1, I = 6, R = 2, S = 1]. Tämän jälkeen vierekkäiset numerot lasketaan yhteen, kunnes jäljellä on vain kaksi lukua. Mikäli missään vaiheessa kahden luvun summaaminen tuottaa luvun, jonka arvo on suurempi tai yhtä suuri kuin 10, summataan ko. luvun numerot yhteen ennen jatkamista laskutoimituksen seuraavaan vaiheeseen.
> 
> [0 + 1 = 1, 1 + 6 = 7, 6 + 2 = 8, 2 + 1 = 3]
> [1 + 7 = 8, 7 + 8 = 15 => 1 + 5 = 6, 8 + 3 = 11 => 1 + 1 = 2]
> [8 + 6 = 14 => 1 + 4 = 5, 6 + 2 = 8]
> [5, 8] = 58%
> 
> Tulos: 58%. Erkki ja Matti ovat parikoodausyhteensopivuudessaan keskitasoa.
> 
> Sen sijaan Erkki Esimerkki ja Tiina Testaaja ovat 29% tuloksellaan suhteellisen epätoimiva parikoodaustiimi.
> 
> Oheisesta tiedostosta löytyy pitkä lista kuvitteellisia reaktorilaisia. Kerro meille kuinka monta täydellisesti (99%) yhteensopivaa koodausparia löydät listasta. Voit toteuttaa tehtävän haluamallasi ohjelmointikielellä.

[Originally from](http://reaktor.com/careers/)

## Installation

Install [leiningen](http://leiningen.org/).

Run `lein install`

## Usage

    $ lein run
    
## Example

    $ lein run
    5895 perfect PAIRS (tm) matches
    $
    
## Run tests

    $ lein test

## License

Copyright © 2014 Mikko Keskinen <keso@iki.fi>

Distributed under the MIT License
