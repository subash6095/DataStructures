package misc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Question :
 *
 * We have to design an Air Traffic system for an airport.
 *
 * There are three runways A, B, C each having a fixed landing time of 2min, 3min, 5min.
 * you have a method where you get a list of Plane objects, which has remaining fuel time in minutes for that plane.
 * If the run way is full and plane has enough fuel we can ask the plane to hold on. If the plane can't be accommodated, we have to redirect the plane to other Airports
 *
 * The purpose is to accommodate max number of Planes.
 */

public class ATC {

    private enum Status {
        LAND_A,
        LAND_B,
        LAND_C,
        ABORT
    }

    private static class Plane {

        Integer remainingFuel;

        Status status;

        Plane(int remainingFuel) {
            this.remainingFuel = remainingFuel;
        }

        Integer getRemainingFuel() {
            return remainingFuel;
        }

        void setStatus(Status status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "Plane{" +
                    "remainingFuel=" + remainingFuel +
                    ", status=" + status +
                    '}';
        }
    }

    private static List<Plane> advise(List<Plane> planes) {
        if (planes == null || planes.size() == 0) {
            return planes;
        }

        /*
         * Since we want to maximize the output this can be approached as a greedy problem
         *
         * To maximise the plane landings, we need to process planes with less remaining fuel first
         * hence sorting the planes based on the remaining fuel.
         */
        planes.sort(Comparator.comparing(Plane::getRemainingFuel));

        int noOfPlanesQueuedForA = 0;
        int noOfPlanesQueuedForB = 0;
        int noOfPlanesQueuedForC = 0;

        for (Plane plane : planes) {
            if (plane.getRemainingFuel() >= (5 + (noOfPlanesQueuedForC * 5))) {
                plane.setStatus(Status.LAND_C);
                noOfPlanesQueuedForC += 1;
            } else if (plane.getRemainingFuel() >= (3 + (noOfPlanesQueuedForB * 3))) {
                plane.setStatus(Status.LAND_B);
                noOfPlanesQueuedForB += 1;
            } else if (plane.getRemainingFuel() >= (2 + (noOfPlanesQueuedForA * 2))) {
                plane.setStatus(Status.LAND_A);
                noOfPlanesQueuedForA += 1;
            } else {
                plane.setStatus(Status.ABORT);
            }
        }
        return planes;
    }

    public static void main(String[] args) {
        List<Plane> planes = advise(Arrays.asList(
                new Plane(10),
                new Plane(7),
                new Plane(2),
                new Plane(10),
                new Plane(6),
                new Plane(3),
                new Plane(3),
                new Plane(5),
                new Plane(4),
                new Plane(2)));

        System.out.println("planes status = " + planes);
    }
}
