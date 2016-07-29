
Am Projekt teilnehmen
=======

Ich kann **nicht** programmieren
-------
Das ist kein Problem, denn man kann auch so seinen Teil zu dem Projekt beitragen. Man kann sich z.B. immer die neuesten Builds "bleeding edges" von unserem Buildserver runterladen und die neu einprogrammierten Features auf Bugs untersuchen und diese dann einbauen.

Andererseits kann man sich auch Features ausdenken und diese requesten oder einfach als Supporter ein wenig auf die Bugreports und Features achten und Duplicates bei uns in Discord melden bzw. einen Kommentar in dem Issue/Feature Request hinterlassen.

Ich kann programmieren
-------
Du kannst direkt loslegen! Erstelle dir einfach eine Fork von dem Projekt und nimm dir ein Feature oder Bugfix vor. Wenn du fertig bist, dann kannst du eine Pull Request stellen. Einer der Project Contributors wird sich dann deine Pull Request ansehen und sollte alles stimmen, wird sie angenommen.

Dieses Projekt ist für die NetBeans IDE optimiert. Solltest du also NetBeans besitzen, kannst du das Projekt bzw. deine Fork clonen und direkt loslegen. Bei anderen IDEs kann es sein, dass noch ein paar Einstellungen angepasst werden müssen.



### Workspace einrichten
Alle Informationen zur Einrichtung des Workspaces findest du in der [SETUP.md](SETUP.md)

### Kompilieren
Alle Informationen zum Kompilieren des Projektes findest du in der [COMPILING.md](COMPILING.md)

### Features & Bugfixes

Bei neuen Features und Bugfixes sollten sie (wenn möglich) von allen unterstützten Versionen implementiert werden.


### Core-Projekt

Das RewiMod-Core Projekt ist das Herzstück der ganzen Mod. Wenn du ein neues Feature in die Mod programmierst, dann versuche so viel Code wie möglich im Core Projekt unterzubringen, damit wir möglichst wenig doppelten Code haben.

Dinge wie die "draw" Funktionen von Gui-Elementen sollten von einer Methode im Core Projekt übernommen werden. Dieser Aufbau des Projektes sorgt dafür, dass man einfacher Bugs beheben kann, insgesamt weniger Code benötigt, die Chance von Bugs reduziert wird und alle unterstützten Versionen nahezu gleich fungieren.


**Beispiel:**

Ein Button hat eine falsche Textur. Ohne das Core Projekt müsste man in allen unterstützten Versionen den Code ändern (der wahrscheinlich auch immer anders ist, da sich die API von Forge relativ häufig verändert). Mit dem Core Projekt muss man den Pfad zur Textur nur an einer Stelle ändern und es zählt automatisch für alle unterstützten Versionen.
