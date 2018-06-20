package com.epam.homework.task26;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.*;

public class Task26Implementation implements Task26 {
    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {

        List<ISegment> segmentList = new ArrayList<>(segments);
        // TreeMap, чтобы в ключе хранить абсциссу, а в значении - точки
        // сортировка по ключу => firstEntry().getValue() вернет точки c минимальной абсциссой
        TreeMap<Double, Set<I2DPoint>> mapOfIntersections = new TreeMap<>();

        for (int i = 0; i < segmentList.size(); i++) {
            for (int j = i + 1; j < segmentList.size(); j++) {
                I2DPoint point = getIntersectionPoint(segmentList.get(i), segmentList.get(j));
                if (point != null) {
                    addIntersectionPoint(mapOfIntersections, point);
                }
            }
        }
        return mapOfIntersections.firstEntry().getValue();
    }

    private void addIntersectionPoint(TreeMap<Double, Set<I2DPoint>> mapOfIntersections, I2DPoint point) {

        double key = point.getX();
        if (!mapOfIntersections.containsKey(key)) {
            Set<I2DPoint> hashSet = new HashSet<>();
            hashSet.add(point);
            mapOfIntersections.put(key, hashSet);
        } else {
            // если уже есть такой ключ, добавляем в Set точку
            mapOfIntersections.merge(key, mapOfIntersections.get(key),
                    (a, b) -> {
                        // добавляем точку в Set
                        mapOfIntersections.get(key).add(point);
                        //возвращаем новый Set
                        return mapOfIntersections.get(key);
                    });
        }

    }

    private I2DPoint getIntersectionPoint(ISegment segment1, ISegment segment2) {
        double x1 = segment1.first().getX();
        double y1 = segment1.first().getY();
        double x2 = segment1.second().getX();
        double y2 = segment1.second().getY();
        double x3 = segment2.first().getX();
        double y3 = segment2.first().getY();
        double x4 = segment2.second().getX();
        double y4 = segment2.second().getY();


        double c = (y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1);
        if (Math.abs(c) - 0 < 0.0000001) {

            if ((x2 == x4 || x2 == x3) & (y2 == y4 || y2 == y3)) {
                return new IntersectionPoint(x2, y2);
            }
            if ((x1 == x3 || x1 == x4) & (y1 == y3 || y1 == y4)) {
                return new IntersectionPoint(x1, y1);
            }
            return null;
        }

        // общий случай
        double A1 = -(y2 - y1);
        double B1 = (x2 - x1);
        double C1 = -(A1 * x1 + B1 * y1);

        double A2 = -(y4 - y3);
        double B2 = x4 - x3;
        double C2 = -(A2 * x3 + B2 * y3);

        double line1Start = A2 * x1 + B2 * y1 + C2;
        double line1End = A2 * x2 + B2 * y2 + C2;

        double line2Start = A1 * x3 + B1 * y3 + C1;
        double line2End = A1 * x4 + B1 * y4 + C1;

        if (line1Start * line1End > 0 || line2Start * line2End > 0) {
            return null;
        }

        double k = line1Start / (line1Start - line1End);
        return new IntersectionPoint(x1 + k * (x2 - x1), y1 + k * (y2 - y1));
    }
}

@AllArgsConstructor
@EqualsAndHashCode
class IntersectionPoint implements Task26.I2DPoint {
    private double x;
    private double y;

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public double getY() {
        return this.y;
    }
}
