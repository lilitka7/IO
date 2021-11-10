# System aukcyjny

## Wprowadzenie

Specyfikacja wymagań funkcjonalnych w ramach informatyzacji procesu sprzedaży produktów w oparciu o mechanizm aukcyjny. 

## Procesy biznesowe

---
<a id="bc1"></a>
### BC1: Sprzedaż aukcyjna 

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Opis:** Proces biznesowy opisujący sprzedaż za pomocą mechanizmu aukcyjnego. |

**Scenariusz główny:**
1. [Sprzedający](#ac1) wystawia produkt na aukcję. ([UC1](#uc1))
2. [Kupujący](#ac2) oferuje kwotę za produkt wyższą od aktualnie najwyższej oferty. ([BR1](#br1))
3. [Kupujący](#ac2) wygrywa aukcję ([BR2](#br2))
4. [Kupujący](#ac2) przekazuje należność Sprzedającemu.
5. [Sprzedający](#ac1) przekazuje produkt Kupującemu.

**Scenariusze alternatywne:** 

2.A. Oferta Kupującego została przebita, a [Kupujący](#ac2) pragnie przebić aktualnie najwyższą ofertę.
* 2.A.1. Przejdź do kroku 2.

3.A. Czas aukcji upłynął i [Kupujący](#ac2) przegrał aukcję. ([BR2](#br2))
* 3.A.1. Koniec przypadku użycia.

---

## Aktorzy

<a id="ac1"></a>
### AC1: Sprzedający

Osoba oferująca towar na aukcji.

<a id="ac2"></a>
### AC2: Kupujący

Osoba chcąca zakupić produkt na aukcji.


## Przypadki użycia poziomu użytkownika

### Aktorzy i ich cele

[Sprzedający](#ac1):
* [UC1](#uc1): Wystawienie produktu na aukcję
* [UC4](#uc4): Rozstrzygnięcie aukcji 
* [UC6](#uc6): Przekazanie produktu

[Kupujący](#ac2)
* [UC2](#uc2): Przebicie oferty
* [UC3](#uc3): Przekazanie należności
* [UC5](#uc5): Złożenie oferty

---
<a id="uc1"></a>
### UC1: Wystawienie produktu na aukcję

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć wystawienia produktu na aukcję.
2. System prosi o podanie danych produktu i ceny wywoławczej.
3. [Sprzedający](#ac1) podaje dane produktu oraz cenę wywoławczą.
4. System weryfikuje poprawność danych.
5. System informuje o pomyślnym wystawieniu produktu na aukcję.

**Scenariusze alternatywne:** 

4.A. Podano niepoprawne lub niekompletne dane produktu.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Przejdź do kroku 2.

---

<a id="uc2"></a>
### UC2: Przebicie oferty

**Aktorzy:** [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) zgłasza do systemu chęć przebicia obecnie najwyższej oferty.
2. System prosi o podanie swojej oferty.
3. [Kupujący](#ac2) podaje swoją oferte. ([BR1](#br1))
4. System weryfikuje zgłoszoną ofertę.
5. System informuje o pomyślnym przebiciu oferty na aukcję.

**Scenariusze alternatywne:** 

4.A. Podana oferta jest mniejsza od obecnie najwyższej oferty.
* 4.A.1. System informuje o za małej kwocie oferty.
* 4.A.2. Przejdź do kroku 2.

---


<a id="uc3"></a>
### UC3: Przekazanie należności

**Aktorzy:** [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) zgłasza do systemu chęć przekazania kwoty oferty.
2. System prosi o wpisaniu kwoty do systemu płatności.
3. [Kupujący](#ac2) podaje kwotę. ([BR1](#br1))
4. System weryfikuje zgłoszoną kwotę.
5. System informuje o pomyślnym przekazaniu należności.

**Scenariusze alternatywne:** 

4.A. Podana kwota nie jest zgodna z ofertą.
* 4.A.1. System informuje o niepoprawnie wprowadzonej kwocie .
* 4.A.2. Przejdź do kroku 2.

---

<a id="uc4"></a>
### UC4: Rozstrzygnięcie aukcji 

**Aktorzy:** [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) zgłasza do systemu chęć złożenia oferty.
2. System spawdza aukcję. 
3. System prosi wprowadzić kwote oferty.
4. [Kupujący](#ac2) podaje kwotę.
6. System spawdza kwotę.
7. System informuje o rozstrzygnięciu aukcji.

**Scenariusze alternatywne:** 

2.A. Żadna oferta dotycząca aukcji nie została podana do systemu.
* 2.A.1. Określony czas aukcji upłynął.
* 2.A.2. System informuje o przegranej [Kupującego](#ac2).
* 2.A.3. Przejdź do kroku 7.

6.A. Już istnieje oferta większa od podanej.
* 6.A.1. Określony czas aukcji upłynął.
* 6.A.2. System informuje o przegranej [Kupującego](#ac2).

6.B. Nie ma oferty większej od podanej.
* 6.B.1. System  informuje o pomyślnie złożonej ofercie.
* 6.B.2. Określony czas aukcji upłynął.
* 6.B.3. System informuje o wygranej [Kupującego](#ac2).


---

<a id="uc5"></a>
### UC5: Złożenie oferty

**Aktorzy:** [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) zgłasza do systemu chęć złożenia oferty.
2. System prosi o wybranie produktu.
3. [Kupujący](#ac2) wybiera interesujący go produkt. 
4. System weryfikuje wybrany produkt.
5. System prosi o wpisaniu oferty.
6. [Kupujący](#ac2) zgłasza ofertę.
7. System weryfikuje zgłoszoną ofertę.
8. System informuje o pomyślnym złożeniu oferty.

**Scenariusze alternatywne:** 

4.A. Czas aukcji produktu został ukończony.
* 4.A.1. System informuje [Kupującego](#ac2) o nieistnieniu danego produktu.
* 4.A.2. Przejdź do kroku 2.
 
6.A. Kwota oferty jest mniejsza niż 1,00 PLN.
* 6.A.1. System informuje [Kupującego](#ac2), że kwota oferty powinna wynosić minimum 1,00 PLN. 
* 6.A.2. Przejdź do kroku 5.
---

<a id="uc6"></a>

### UC6: Przekazanie produktu

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. System sprawdza, czy należność została przekazana.
2. System przekazuje należność [Sprzedającemu](#ac1) i informuje o tym [Sprzedającego](#ac1).
3. System prosi wybrać produkt do przekazania.
4. [Sprzedający](#ac1) wybiera produkt do przekazania.
5. System weryfikuje wybrany produkt.
6. System informuje o pomyślnym przekazaniu produktu.

**Scenariusze alternatywne:** 

1.A. Przekazanie należności nie zakończyło się powodzeniem.
* 1.A.1. System informuje o tym, że nie została przekazana należność.
* 1.A.2. Przejdź do kroku 1.
 
5.A. Wybrany produkt nie odpowiada ofercie.
* 5.A.1. System informuje [Sprzedającego](#ac1) o niepoprawnie wybranym produkcie.
* 5.A.2. Przejdź do kroku 3.
---
## Obiekty biznesowe (inaczje obiekty dziedzinowe lub informatycjne)

### BO1: Aukcja

Aukcja jest formą zawierania transakcji kupna-sprzedaży, w której Sprzedający określa cenę wywoławczą produktu, natomiast Kupujący mogą oferować własną ofertę zakupu każdorazowo proponując kwotę wyższą od aktualnie oferowanej kwoty. Aukcja kończy się po upływie określonego czasu. Jeśli złożona została co najmniej jedna oferta zakupy produkt nabywa ten Kupujący, który zaproponował najwyższą kwotę. 

### BO2: Produkt

Fizyczny lub cyfrowy obiekt, który ma zostać sprzedany w ramach aukcji.

## Reguły biznesowe

<a id="br1"></a>
### BR1: Złożenie oferty

Złożenie oferty wymaga zaproponowania kwoty wyższej niż aktualnie oferowana o minimum 1,00 PLN.


<a id="br2"></a>
### BR2: Rozstrzygnięcie aukcji

Aukcję wygrywa ten z [Kupujący](#ac2)ch, który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.

## Macierz CRUDL


| Przypadek użycia                                  | Aukcja | Produkt | Oferta |
| ------------------------------------------------- | ------ | ------- | ---     |
| UC1: Wystawienia produktu na aukcję               |    C   |    C    |        |
| UC2: Przebicie oferty                             |   UR     |         | UR    |
| UC3: Przekazanie należności                       |        |         |U    |
| UC4/BR2: Rozstrzygnięcie aukcji (przegrana)        |D      |          |      |
| UC5/BR1: Złożenie oferty                          |  UR     |           |C      |
| UC6: Przekazanie produktu                         |       |   D       |       |

