# Modellering av DNA

## Introduksjon

TrondheimBio jobber på spreng for å utvikle en mRNA-vaksine for å bekjempe den globale peroni-pandemien, og for å kunne jobbe effektivt trenger de nå hjelp fra en datakyndig konsulent til å modellere DNA-molekyler i kode.

Oppgaven din er å lage en klasse, `DNA`, som er en representasjon av et DNA-molekyl. Som kjent fra naturfag så består DNA-molekyl av to _kjeder_ som begge inneholder en sekvens av nukleobaser. Nukleobaser kan ha verdiene **A**, **T**, **G** og **C**, og danner såkalte komplementære _basepar_. Hvis den ene kjeden inneholder **A**, så må tilsvarende posisjon på den andre kjeden inneholde **T** og omvendt, mens **G** dannes i par med **C**. Et DNA-molekyl består av flere _gener_ som igjen består av en sekvens med nukleobaser, og TrondheimBio ønsker å ha DNA-et oppdelt i disse genene for å enklere kunne forske på de.

For enkelhets skyld så trenger du i klassen din trenger bare å lagre den ene kjeden av et DNA, og i dette tilfellet bør du lagre samme kjede som gis som input. Med andre ord trenger du ikke konvertere fra T -> A etc. når du skal lagre DNA-strengen inne i klassen.

Når man jobber med DNA så må man også forholde seg til RNA. RNA består (grovt sett) av en enkelt kjede med DNA (som vanligvis består av to kjeder), hvor kodingen av nukleobaser er lik, men unntak av at **T** byttes ut med **U**. Dette må håndteres inne i programmet du lager.

## Beskrivelse

I kravspesifikasjonen fra TrondheimBio får du følgende krav:

- DNA-sekvenser skal kunne leses inn som en **liste**, bestående av **strenger** som representerer enkelt-gener i DNA-et.
- DNA-klassen skal ta vare på hvilke gener som finnes inne i DNA-et, samt hvilke nukleobaser de forskjellige genene inneholder og hvilken rekkefølge de står i.
- Man skal kunne gjøre RNA-transkripsjon på DNA-strengen, som vil si at en sekvens bestående av **komplementære** nukleobaser skal printes ut.
- Man skal kunne filtrere ut gener med spesifikke egenskaper og sjekke om DNA-et inneholder spesifikke **kodon** (en sekvens med tre nukleobaser som kommer i rekkefølge)

Prosjektleder har allerede konkretisert de funksjonelle kravene til et sett med metoder som du skal implementere inne i din `DNA`-klasse:

- **addGene**: Tar inn et gen (String) og legger til dette i DNA-objektet _dersom_ det ikke allerede finnes i DNA-et, det består av minst én nukleobase, samt at alle nukleobasene i genet består av gyldige verdier (A, T, G, C).
- **getAllMatchingGenes**: Tar inn et `Predicate` av typen String og returnerer en liste med gener (`String`) som matcher predikatet.
- **reorder**: Tar inn et `Comparator`-objekt av typen `String` og sorterer genene i DNA-et med dette.
- **containsCodon**: Returnerer en `boolean` avhengig av om DNA-objektet inneholder et spesifikt kodon. Dersom kodonet ikke er av lengde tre så skal det alltid returneres `false`.
- **getComplement**: Tar innen en nukleobase (char) og returnerer komplementet til denne som en `char` (A->T, etc.). Dersom en ugyldig nukleobase gis som inputargument så skal `X` returneres.
  - _Eksempel: Hvis inputargument er **"G"** skal denne returnere **"C"**._
- **getComplementaryStrand**: Returnerer en sammenhengende streng av komplementære nukleobaser, som danner den andre kjeden i DNA-et.
  - _Eksempel: Hvis innholdet i DNA-et er **"GACT"** skal denne returnere **"CTGA"**._
- **transcribeToRNA**: Returnerer en sammenhengende RNA-streng bestående av _alle_ gener i DNA-et. RNA-strengen må også være invertert til komplementær-nukleobaser (A->T, etc.) og T skal byttes ut med U.
  - _Eksempel: Hvis innholdet i DNA-et er **"GACT"** skal denne returnere **"CUGA"**._
- **toString**: Returnerer innholdet i DNA-et som en sammenhengende linje, i tillegg til den komplementære kjeden,
  adskilt med linjeskift.
  - _Eksempel: Hvis innholdet i DNA-et er **"GACT"** skal denne returnere **"GACT\nCTGA"**._

Prosjektleder nevner forøvrig at mange av disse metodene kan implementeres med bruk av Streams- og lambda-syntaks fra Java 8, og anbefaler deg derfor å se nærmere på dette.

## Poeng

Samtlige klasser nevnt ovenfor gir poeng, opptil totalt 190 poeng. Det vil testes for diverse unntak og riktighet.

## Hjelp jeg står fast!


Dersom du står fast kan du titte på (en av veldig mange mulige løsninger) [her](https://github.com/Magssch/java-kodenotter/blob/main/descriptions/DNA.md)
