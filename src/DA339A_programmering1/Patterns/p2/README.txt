Författare: Sebastian Jonas Börebäck
Datum: 2015-10-21

Programmet är skrivet med JDK 1.8 och i Intellij Idea.
TimeDiagram.jpg är UML diagrammet för Time klassen.

Det finns en ändring i PaintWindow som fixar en bugg med Java i linux.
rad 63
Toolkit.getDefaultToolkit().sync();
Efter man kört repaint(); 
så måste man köra sync(); denna göra så att alla element i Panelen blir
uppdaterade och i sync med repaint.