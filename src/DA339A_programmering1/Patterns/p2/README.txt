F�rfattare: Sebastian Jonas B�reb�ck
Datum: 2015-10-21

Programmet �r skrivet med JDK 1.8 och i Intellij Idea.
TimeDiagram.jpg �r UML diagrammet f�r Time klassen.

Det finns en �ndring i PaintWindow som fixar en bugg med Java i linux.
rad 63
Toolkit.getDefaultToolkit().sync();
Efter man k�rt repaint(); 
s� m�ste man k�ra sync(); denna g�ra s� att alla element i Panelen blir
uppdaterade och i sync med repaint.