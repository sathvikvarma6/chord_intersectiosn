import java.util.*;

public class ChordIntersectionCounter {
    static class Chord {
        double start, end;
        int index;

        public Chord(double start, double end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    static class ChordEndComparator implements Comparator<Chord> {
        @Override
        public int compare(Chord c1, Chord c2) {
            return Double.compare(c1.end, c2.end);
        }
    }

    public static void main(String[] args) {
        double[] radians = {0.78, 1.47, 1.77, 3.92};
        String[] identifiers = {"s_1","s_2","e_1","e_2"};
        System.out.println("Number of Intersections: " + countIntersections(radians, identifiers));
        // double[] radians = {0.9, 1.30, 1.70, 2.92};
        // String[] identifiers = {"s_1","e_1","s_2","e_2"};

        // System.out.println("Number of Intersections: " + countIntersections(radians, identifiers));
    }

    public static int countIntersections(double[] radians, String[] identifiers) {
        List<Chord> chords = new ArrayList<>();
        Map<Integer, Chord> map = new HashMap<>();

        // creating a map to store start and end points of chords using identifiers
        for (int i = 0; i < radians.length; i++) {
            int id = Integer.parseInt(identifiers[i].substring(2));
            if (identifiers[i].charAt(0) == 's') {
                Chord chord = new Chord(radians[i], -1, id);
                map.put(id, chord);
            } else {
                Chord chord = map.get(id);
                if (chord != null) {
                    chord.end = radians[i];
                }
            }
        }

        // Adding the completed chords intto a list
        for (Chord chord : map.values()) {
            if (chord.end != -1) {
                chords.add(chord);
            }
        }

        // Sorting the chords by their starting point
        chords.sort(Comparator.comparingDouble(chord -> chord.start));

        // treeset to store the chords in a ascending order based on their end points to find out the active chords
        TreeSet<Chord> activeChords = new TreeSet<>(new ChordEndComparator());
        int intersections = 0;

        for (Chord chord : chords) {
            // Removing chords that are no longer active with current chord
            removeInactiveChords(activeChords, chord.start);
            
            // Counting the active chords
            intersections += activeChords.size();

            // Add the new chord to the set of active chords
            activeChords.add(chord);
        }

        return intersections;
    }
    //checking and removing the unactive chords
    private static void removeInactiveChords(TreeSet<Chord> activeChords, double currentStart) {
        Iterator<Chord> iterator = activeChords.iterator();
        while (iterator.hasNext()) {
            Chord chord = iterator.next();
            if (chord.end < currentStart) {
                iterator.remove();
            } else {
                break;
            }
        }
    }
}