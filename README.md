# FxDocking

Experiments with "Docking" for JavaFX.

Goal is very basic support for "Tabs" similar to a web browser:
 * One or more tabs
 * Tabs can be re-arranged
 * Tabs can be de-tacked into new windows
 * Tabs can be moved between such windows

Initially looked at the following:

1. https://bugs.openjdk.java.net/browse/JDK-8092098: JavaFX might eventually get docking support, "targeted JDK10", but not, yet
2. http://berry120.blogspot.co.uk/2014/01/draggable-and-detachable-tabs-in-javafx.html is a very compact example, in principle has just what's needed, but doesn't work on Linux
3. https://github.com/alexbodogit/AnchorFX
4. https://github.com/RobertBColton/DockFX
5. http://www.drombler.org/drombler-fx

Libraries 3. to 4. add more than the basic requirements, but may not work on Linux depending on your window manager. 5. requires OSGi.

## docking1.Demo1:

With either Java 8 or Java 9, run as
```
ant demo1
```

Demonstrates the problem on Linux.
When starting to 'drag' an existing tab, many libraries open a new `Stage` which is meant to be dragged, but that stage takes the focus from the original tab. The result on Linux is an abandoned Stage.

In this demo, starting to drag a tab opens a new stage to represent the outline of what's dragged.
That new stage takes the focus, so one needs to try dragging the same tab again(!) to move the stage.
Not further developed.

## docking2.Demo2:

With either Java 8 or Java 9, run as
```
ant demo2
```

Tabs can be rearranged via drag-and-drop.
Context menu of tab allows de-taching tab into a new window.
Tabs can then be dragged between that new window and existing windows.
