package com.epam.homework.task26;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Using sweeping line method to find intersectionOfSegments segments
 */
public class Task26Impl implements Task26 {
    private TreeMap<I2DPoint, List<ISegment>> eventPoints = new TreeMap<>((point1, point2) -> {
        if (Double.compare(point1.getX(), point2.getX()) != 0) {
            return Double.compare(point1.getX(), point2.getX());
        } else {
            return Double.compare(point1.getY(), point2.getY());
        }
    });

    private Point firstIntersectionPoint = null;

    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {
        addEventPoints(segments);

        Set<I2DPoint> result = null;
        Set<ISegment> usingSegments = new HashSet<>();
        boolean intersectionPointsFound = false;
        while (!intersectionPointsFound && !eventPoints.isEmpty()) {
            Map.Entry<I2DPoint, List<ISegment>> currentEventEntry = eventPoints.pollFirstEntry();

            Point currentEventPoint = new Point(currentEventEntry.getKey());
            Segment sweepLine = new Segment(currentEventPoint, new Point(currentEventPoint.getX(), currentEventPoint.getY() + 1));

            if (currentEventEntry.getValue().size() != 1) {
                firstIntersectionPoint = currentEventPoint;
            }

            TreeMap<Double, ISegment> sweepLineStatus = new TreeMap<>();
            for (ISegment segment : usingSegments) {
                if (Double.compare(sweepLine.first().getX(), sweepLine.second().getX()) != 0) {
                    Double sweepLineIntersectionAtY = intersectionOfLines(segment, sweepLine).get().getY();
                    sweepLineStatus.put(sweepLineIntersectionAtY, segment);
                } else {
                    sweepLineStatus.put(segment.first().getY(), segment);
                }
            }

            if (!currentEventPoint.equals(firstIntersectionPoint)) {
                ISegment segment = currentEventEntry.getValue().get(0);
                if (!usingSegments.contains(segment)) {
                    usingSegments.add(segment);
                    sweepLineStatus.put(currentEventPoint.getY(), segment);
                    Map.Entry<Double, ISegment> nearbyEntry = sweepLineStatus.higherEntry(currentEventPoint.getY());
                    if (nearbyEntry != null) {
                        intersectionOfSegments(segment, nearbyEntry.getValue()).ifPresent(this::addIntersectionPoint);
                    }
                    nearbyEntry = sweepLineStatus.lowerEntry(currentEventPoint.getY());
                    if (nearbyEntry != null) {
                        intersectionOfSegments(segment, nearbyEntry.getValue()).ifPresent(this::addIntersectionPoint);
                    }
                } else {
                    Map.Entry<Double, ISegment> higherEntry = sweepLineStatus.higherEntry(currentEventPoint.getY());
                    Map.Entry<Double, ISegment> lowerEntry = sweepLineStatus.lowerEntry(currentEventPoint.getY());

                    if (higherEntry != null && lowerEntry != null) {
                        intersectionOfSegments(higherEntry.getValue(), lowerEntry.getValue()).ifPresent(this::addIntersectionPoint);
                    }
                    usingSegments.remove(segment);
                }

            } else {
                result = new HashSet<>();
                Set<I2DPoint> sweepLineIntersectionPoints = new HashSet<>();
                usingSegments.addAll(currentEventEntry.getValue());

                Set<ISegment> verticalSegments = usingSegments.stream()
                        .filter(s -> Double.compare(s.first().getX(), s.second().getX()) == 0)
                        .collect(Collectors.toSet());
                usingSegments.removeAll(verticalSegments);

                for (ISegment segment : usingSegments) {
                    I2DPoint point = intersectionOfLines(segment, sweepLine).get();

                    boolean isIntersectWithVerticalSegment = false;
                    for (ISegment verticalSegment : verticalSegments) {
                        double minYvalue = verticalSegment.first().getY() < verticalSegment.second().getY() ?
                                verticalSegment.first().getY() : verticalSegment.second().getY();
                        double maxYvalue = verticalSegment.first().getY() > verticalSegment.second().getY() ?
                                verticalSegment.first().getY() : verticalSegment.second().getY();
                        if (Double.compare(point.getY(), minYvalue) >= 0 && Double.compare(point.getY(), maxYvalue) <= 0) {
                            isIntersectWithVerticalSegment = true;
                        }
                    }
                    if (!sweepLineIntersectionPoints.add(point) || isIntersectWithVerticalSegment) {
                        result.add(point);
                    }
                }
                intersectionPointsFound = true;
            }
        }
        return result;
    }

    private void addEventPoints(Set<ISegment> segments) {
        for (ISegment segment : segments) {
            if (!eventPoints.containsKey(segment.first())) {
                ArrayList<ISegment> segmentList = new ArrayList<>();
                segmentList.add(segment);
                eventPoints.put(segment.first(), segmentList);
            } else {
                eventPoints.get(segment.first()).add(segment);
            }

            if (!eventPoints.containsKey(segment.second())) {
                ArrayList<ISegment> segmentList = new ArrayList<>();
                segmentList.add(segment);
                eventPoints.put(segment.second(), segmentList);
            } else {
                eventPoints.get(segment.second()).add(segment);
            }
        }
    }

    private void addIntersectionPoint(I2DPoint point) {
        eventPoints.put(point, new ArrayList<>());
        if (firstIntersectionPoint == null || point.getX() <= firstIntersectionPoint.getX()) {
            firstIntersectionPoint = new Point(point);
        }
    }

    private static Optional<I2DPoint> intersectionOfSegments(ISegment firstSegment, ISegment secondSegment) {
        //quick rejection:
        //if bounding boxes of two segments have no common points then this segments don's intersect
        double x1 = firstSegment.first().getX() <= firstSegment.second().getX() ? firstSegment.first().getX() : firstSegment.second().getX();
        double y1 = firstSegment.first().getY() <= firstSegment.second().getY() ? firstSegment.first().getY() : firstSegment.second().getY();

        double x2 = firstSegment.first().getX() >= firstSegment.second().getX() ? firstSegment.first().getX() : firstSegment.second().getX();
        double y2 = firstSegment.first().getY() >= firstSegment.second().getY() ? firstSegment.first().getY() : firstSegment.second().getY();

        double x3 = secondSegment.first().getX() <= secondSegment.second().getX() ? secondSegment.first().getX() : secondSegment.second().getX();
        double y3 = secondSegment.first().getY() <= secondSegment.second().getY() ? secondSegment.first().getY() : secondSegment.second().getY();

        double x4 = secondSegment.first().getX() >= secondSegment.second().getX() ? secondSegment.first().getX() : secondSegment.second().getX();
        double y4 = secondSegment.first().getY() >= secondSegment.second().getY() ? secondSegment.first().getY() : secondSegment.second().getY();

        // if (x2 >= x3) && (x4 >= x1) && (y2 >= y3) && (y4 >= y1) then bounding boxes of two segments have no common points
        if (!((Double.compare(x2, x3) >= 0)
                && (Double.compare(x4, x1) >= 0)
                && (Double.compare(y2, y3) >= 0)
                && (Double.compare(y4, y1) >= 0))) {
            return Optional.empty();
        }

        return intersectionOfLines(firstSegment, secondSegment).filter(point -> (point.getX() >= x1
                && point.getX() <= x2
                && point.getX() >= x3
                && point.getX() <= x4
                && point.getY() >= y1
                && point.getY() <= y2
                && point.getY() >= y3
                && point.getY() <= y4));
    }

    private static Optional<I2DPoint> intersectionOfLines(ISegment firstSegment, ISegment secondSegment) {
        Vector firstLine = crossVector(new Vector(firstSegment.first().getX(), firstSegment.first().getY(), 1.0),
                new Vector(firstSegment.second().getX(), firstSegment.second().getY(), 1.0));

        Vector secondLine = crossVector(new Vector(secondSegment.first().getX(), secondSegment.first().getY(), 1.0),
                new Vector(secondSegment.second().getX(), secondSegment.second().getY(), 1.0));

        //put in result homogeneous coordinates of an intersection point of two lines passing through segment's
        Vector result = crossVector(firstLine, secondLine);

        if (!result.getZ().equals(BigDecimal.valueOf(0.0))) { //if lines are not parallel
            return Optional.of(new Point(result.getX().divide(result.getZ(), 3, BigDecimal.ROUND_HALF_UP).doubleValue(),
                    result.getY().divide(result.getZ(), 3, BigDecimal.ROUND_HALF_UP).doubleValue()));
        } else { //lines are parallel
            return Optional.empty();
        }
    }

    private static Vector crossVector(Vector firstVector, Vector secondVector) {
        return new Vector(
                ((firstVector.getY().multiply(secondVector.getZ())).subtract((firstVector.getZ().multiply(secondVector.getY())))).doubleValue(),
                ((firstVector.getZ().multiply(secondVector.getX())).subtract((firstVector.getX().multiply(secondVector.getZ())))).doubleValue(),
                ((firstVector.getX().multiply(secondVector.getY())).subtract((firstVector.getY().multiply(secondVector.getX())))).doubleValue());
    }

    @Getter
    private static class Vector {
        private BigDecimal x;
        private BigDecimal y;
        private BigDecimal z;

        Vector(double x, double y, double z) {
            this.x = BigDecimal.valueOf(x);
            this.y = BigDecimal.valueOf(y);
            this.z = BigDecimal.valueOf(z);
        }
    }
}
