
Setup
=======

Um das Projekt einzurichten, müssen folgende Schritte getätigt werden:

**Windows**

 - Shift + Rechtsklick in den Projektordner
 - Auf "Eingabeaufforderung hier öffnen" klicken
 - `gradlew setupDecompWorkspace`
 - Enter

**Linux, BSD, Mac OS X**

 - Terminal öffnen und zum Projektordner navigieren
 - `./gradlew setupDecompWorkspace`

Je nach PC Leistung und Internet Leitung kann das eine weile dauern.

gradle.properties
-------

Wir haben 3 Variablen für die Entwickler in der gradle.properties vorgesehen:

| Name | Typ | Beschreibung |
|------|------|------|
| `useAuth` | Boolean | Legt fest ob die Authentifizierung stattfinden soll oder nicht |
| `mcAccountName` | String | Mojang Login E-Mail |
| `mcAccountPass` | String | Mojang Login Passwort |

**Diese Werte sind keine Pflichtangaben, jedoch sind sie erforderlich, wenn ihr im Debug/Run Modus auf Online-Server Joinen möchtet.**
