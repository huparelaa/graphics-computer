# Graphichs computer course
## Content:
* [Bresenham](#Bresenham)
* [Images from text file](#Draw-from-text-file)
## How to run it?
Before run the commands make sure you are not in a specific directory
### Bresenham
```bash
javac bresenham/Bresenham.java
javac bresenham/Main.java 
java bresenham.Main
```

### Draw from text file
```bash
javac drawFromTextFile/PaintObject.java
javac drawFromTextFile/Main.java
java drawFromTextFile.Main
```
If you want to draw the other object you only need to change this line in PaintObject.java line 22:
```java
readFile("drawFromTextFile/gancho.txt", g);
```
into this:
```java
readFile("drawFromTextFile/house.txt", g);
```
