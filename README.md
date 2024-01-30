Overview

This Java program calculates the number of intersections between various chords in a circle. The algorithm is based on a sweep line approach combined with a balanced binary search tree for efficient computation. It's designed to handle a set of chords, each defined by their start and end radian measures on the circle's circumference.

Algorithm
The program processes the chords in two main steps:

Sorting and Preparation: Chords are first sorted based on their start points and mapped for easy access.
Sweep Line with TreeSet: A sweep line technique is used along with a TreeSet to keep track of active chords (chords that the sweep line is currently intersecting). The TreeSet is ordered by the end points of the chords, allowing for efficient addition and removal of chords.

Key Components

Chord Class: Represents a chord with start and end points.
ChordEndComparator: Custom comparator for ordering chords in the TreeSet based on their end points.
Main Algorithm: Iterates through each chord, updates the set of active chords, and counts intersections.
Time Complexity
The time complexity of the algorithm is O(n log n), where n is the number of chords. This is due to the sorting of the chords and the efficient operations (addition, removal, and querying) on the TreeSet.

How to Run

Ensure Java is installed on your system.
Save the program in a file named ChordIntersectionCounter.java.
Compile the Java program using the command: javac ChordIntersectionCounter.java.
Run the compiled program using: java ChordIntersectionCounter.

Customization

To test different scenarios, modify the radians and identifiers arrays in the main method of ChordIntersectionCounter.java. Each chord is represented by a pair of values in these arrays, corresponding to its start and end points.

Dependencies

No external libraries or dependencies are required. The program uses standard Java libraries.
