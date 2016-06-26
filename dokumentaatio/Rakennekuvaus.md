Rakennekuvaus

## Logiikasta:

* Logiikka-luokka vastaa suurimmaksi osaksi pelin logiikasta. 
* Palikka-luokka on vastuussa pelissä olevan palikan kääntämisestä ja liikuttamisesta, sekä siihen kuuluvien osien kontrolloinnista.
* Osa-luokka muodostaa Palikka-luokan abstraktin olion.
* PalikkaArpoja luo palikat ja arpoo seuraavan pelattavan palikan.
* Ajastin-luokka luo ajastimen, käynnistää sen ja nopeuttaa sitä.
* Ruudukko-luokka luo ruudukon ja tarkistaa, onko tietty ruudukon kohta tyhjä.
* Suunta-luokka koostuu suunta-enumeista (vasen, oikea, alas).
* Palikkatyypit luovat tietyn mallisia palikoita koorinaattien mukaan.

## Käyttöliittymästä:

* Luokka Alusta toimii pelialustana ja vastaa omasta logiikastaan. 
* Kayttoliittyma-luokka vastaa pelin komponenttien luonnista. 
* Paivitys-rajapinta vastaa pelinäkymän päivittämisestä. 
* Listenerit kuuntelevat pelaajan painamia näppäimiä. 
* Ohjaaja-luokka luo uuden pelin ja asettaa ajastimen päälle.
