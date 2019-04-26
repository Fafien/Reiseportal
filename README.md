# Reiseportal

Entwickler:<br>
Diese Anwendung wurde entwickelt von Marwa Alqataa, Beliz Balim, Fabian Hupe, Jonas Mitschke.

Repository:<br>
https://github.com/Fafien/Reiseportal 

Zweck:<br>
Zwecke dieser Anwendung sind Suchen und Buchen von Reiseprodukten.

Kurzbeschreibung:<br>
Dies ist ein Beispiel für eine in Java realisierte, serverseitige MVC-Webanwendung. Die Anwendung setzt dabei ganz klassisch auf der „Jakarta Enterprise Edition” (ehemals „Java Enterprise Edition“) auf und läuft daher in einem speziell dafür ausgelegten Applikationsserver. Sämtliche Anwendungslogik wird dabei vom Server implementiert, so dass für jedes URL-Pattern der Anwendung ein komplett serverseitig generierte HTML-Seite abgerufen und im Browser dargestellt wird.

Verwendete Technologien:<br>
Die App nutzt Maven als Build-Werkzeug und zur Paketverwaltung. Auf diese Weise werden die für Jakarta EE notwendigen APIs, darüber hinaus aber keine weiteren Abhängigkeiten, in das Projekt eingebunden. Der Quellcode der Anwendung ist dabei wie folgt strukturiert:

Servlets dienen als Controller-Schicht und empfangen sämtliche HTTP-Anfragen.
Enterprise Java Beans dienen als Model-Schicht und kapseln die fachliche Anwendungslogik.
Persistence Entities modellieren das Datenmodell und werden für sämtliche Datenbankzugriffe genutzt.
Java Server Pages sowie verschiedene statische Dateien bilden die View und generieren den auf dem Bildschirm angezeigten HTML-Code.

Folgende Entwicklungswerkzeuge kommen dabei zum Einsatz und müssen installiert sein:

NetBeans: Integrierte Entwicklungsumgebung für Java und andere Sprachen<br>
Maven:    Build-Werkzeug und Verwaltung von Abhängigkeiten<br>
Git:      Versionsverwaltung zur gemeinsamen Arbeit am Quellcode<br>
TomEE:    Applikationsserver zum lokalen Testen der Anwendung<br>
Derby:    In Java implementierte SQL-Datenbank zum Testen der Anwendung<br>

Nutzungshinweis:<br>
Nach der Installation und der ersten Registrierung, ist der Benutzer ein "normaler" Benutzer. Daher sind die Admin-Funktionalitäten zur Hotelverwaltung und Benutzerverwaltung zunächst nicht verfügbar. Möchte ein Anwender die Admin-Funktionalitän ausüben, muss sich dieser manuell in der Datenbank als Admin eintragen. Das geschiet durch das Setzen des Admin-Wertes auf "1" in der Tabelle Useraccount.
