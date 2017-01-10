# Vorarbeit damit es nicht rumbuggt

- altes 8-1 Projekt kopieren
- per Rechtsklick Refactor Rename in kbe-ue9-1 umbenennen
- in pom.xml alle "kbe-ue8-1" in "kbe-ue9-1" umbennen

- dann Rechtsklick auf Projekt->Maven->Update Projekt  

- bei Fehlern: Rechtsklick auf Projekt -> Properties->Project Facets und dann Dynamic WebModule auf 3.0 ändert, applyen; Java auf 1.8 ändern, applyen, Java Server faces ventl auch noch; dann nochmal Rechtsklick auf Projekt->Maven->Update Projekt

- immer wieder maven update und refresh
- dann maven clean und maven install  

- falls ein Maven Install failed, wegen Java jdk jre Gedöns:
- Rechtsklick auf das Projekt->Properties->Java Build Path ->JRE anklicken->Edit->Alternate JRE->Apply  

- bei TomcatServer Fehlern: -> In Servers in die server.xml-> doppelte context tags löschen  

- bei ActionOutcomeNotFound Warnung: -> in der faces config überall Schrägstriche ranmachen vor der ID


# Aufgabenblatt 9.1

# a) b)  

- siehe Projekt

# Aufgabenblatt 9.2

# a)

- es läuft sehr gut

# b)

## Zweck von Fassade:  
- bietet eine einheitliche Schnittstelle zu einer Menge von Schnittstellen eines Subsystems
- verienfacht damit den Umgang mit dem Subsystem  

## allgemeine Funktionsweise: 
- gehört zu den Strukturmustern
- Fassadenklasse enthält Methoden, die eine häufig benötigte Menge an Unterfunktionen zusammenfasst
- z.b. anstelle von EntityManager init, beginTrans, persist, commit, endTrans haben wir einfach save()  

## Erleichterungen in 9.1: 
- Man kann wiederkehrende Operationsfolgen (Begin, do stuff, commit, end) abkapseln in eigene Methoden
- man spart sich, immer den gleichen Code zu schreiben - weniger Redundanz
- Klasse, die die ToDoFassade verwendet, muss nich wissen, wie Entitymanager etc funktionieren und sowas
- d.h. nicht mehr so abhängig und stabiler gegenüber von Veränderungen  

# c)

- wir hauen das in die pom.xml:
```xml
		<!-- CDI und sowas -->
		<dependency>
			<groupId>javax.enterprise</groupId>
			<artifactId>cdi-api</artifactId>
			<version>1.2</version>
			<scope>provided</scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.jboss.weld.servlet/weld-servlet -->
		<dependency>
			<groupId>org.jboss.weld.servlet</groupId>
			<artifactId>weld-servlet</artifactId>
			<version>2.4.1.Final</version>
		</dependency>
```

- wir entfernen die Annotationen von IntervalMB und TodoListMB und machen die CDI-Annotationen `@Named` und `@ApplicationScoped` ran mit den Imports: `import javax.enterprise.context.ApplicationScoped` und `import javax.inject.Named`.

- wir erstellen eine beans.xml in src/main/webapp/WEB-INF, damit CDI funzt:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://java.sun.com/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="
      http://java.sun.com/xml/ns/javaee
      http://java.sun.com/xml/ns/javaee/beans_1_0.xsd">
</beans>
```

# d) 

- `ToDoDAO.java` bearbeiten:  
Wir fügen die `@Named`  Annotation hinzu, damit man ToDoDAO in ToDoFacade injizieren kann.  


- `ToDoFacade.java` bearbeiten:  
Wir fügen die `@Named`  Annotation hinzu, damit man ToDoFacade in ToDoListMB / ToDoMB injizieren kann. 
Wir beschreiben das Feld ToDoDAO mit der `@Inject` Annotation. Der Konstruktor kann weg.  


- `ToDoMB.java` bearbeiten:  
Neue CDI Annotationen `@Named` und `@ApplicationScoped` anfügen. Wir beschreiben das Feld ToDoFacade mit der `@Inject` Annotation und entfernen es aus dem Konstruktor.  


- `ToDoListMB.java` bearbeiten:  
Wir beschreiben das Feld ToDoFacade mit der `@Inject` Annotation. Der Konstruktor kann weg. Stattdessen eine neue Methode `init()` mit der Annotation `@PostConstruct`, die direkt nach der Bean Konstruktion aufgerufen wird. Darin initialisieren wir die ToDoList und füllen sie mit 'getListsOfToDos()' aus der Fassade. Ist nötig, weil im Konstruktor das Fassade Feld noch nicht initialisiert ist (dependencies are injected ***after*** construction!). Um NPE zu vermeiden, geh ich halt den Umweg ;) (siehe auch [StackOverflow 1] (http://stackoverflow.com/questions/16399974/nullpointerexception-while-trying-to-access-inject-bean-in-constructor) und [StackOverflow 2](http://stackoverflow.com/questions/3406555/why-use-postconstruct))













