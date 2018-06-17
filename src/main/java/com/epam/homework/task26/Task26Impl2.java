package com.epam.homework.task26;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Task26Impl2 implements Task26 {

// Предположим, что две прямые имеют уравнения y=ax+c y=bx+d,
// где a и b — угловые коэффициенты прямых, а c и d — пересечения прямых с осью y.
// В точке пересечения прямых (если они пересекаются), обе координаты y будут совпадать,
// откуда получаем равенство: ax+c=bx+d. Тогда x = (d-c)/(a-b)

    @Override
    public Set<I2DPoint> analyze(Set<ISegment> segments) {
        List<ISegment> segmentList = new ArrayList<>(segments);
        Map<ISegment, Set<I2DPoint>> map = new TreeMap<>((o1, o2) ->
                (int) (o1.first().getX() - o2.second().getX() == 0 ?
                        (o1.first().getY() - o2.second().getY()) :
                        (o1.first().getX() - o2.second().getX())));

        for (int i = 0; i < segmentList.size(); i++) {
//          Аккумулятор для занесения всех точек пересечения с первым сегментом firstSegment.
            Set<I2DPoint> currentI2DPoints = new TreeSet<>();

//            Работаем с первым сегментом.
            ISegment firstSegment = segmentList.get(i);
            I2DPoint firstPointOfFirstSegment = firstSegment.first();
            I2DPoint secondPointOfFirstSegment = firstSegment.second();

//            Получим координаты точек первого сегмента.
            double x1 = firstPointOfFirstSegment.getX();
            double y1 = firstPointOfFirstSegment.getY();
            double x2 = secondPointOfFirstSegment.getX();
            double y2 = secondPointOfFirstSegment.getY();

//            Округлим значения для дальнейшей корректной работы.
            x1 = new BigDecimal(x1).setScale(8, RoundingMode.HALF_UP).doubleValue();
            y1 = new BigDecimal(y1).setScale(8, RoundingMode.HALF_UP).doubleValue();
            x2 = new BigDecimal(x2).setScale(8, RoundingMode.HALF_UP).doubleValue();
            y2 = new BigDecimal(y2).setScale(8, RoundingMode.HALF_UP).doubleValue();

//            Переходим ко второму сегменту и производим все вычисления.
            for (int j = i + 1; j < segmentList.size() - 1; j++) {
                ISegment secondSegment = segmentList.get(j);
                I2DPoint firstPointOfSecondSegment = secondSegment.first();
                I2DPoint secondPointOfSecondSegment = secondSegment.second();

//               Получим координаты точек второго сегмента.
                double x3 = firstPointOfSecondSegment.getX();
                double y3 = firstPointOfSecondSegment.getY();
                double x4 = secondPointOfSecondSegment.getX();
                double y4 = secondPointOfSecondSegment.getY();

//                Округлим для корректной работы.
                x3 = new BigDecimal(x3).setScale(8, RoundingMode.HALF_UP).doubleValue();
                y3 = new BigDecimal(y3).setScale(8, RoundingMode.HALF_UP).doubleValue();
                x4 = new BigDecimal(x4).setScale(8, RoundingMode.HALF_UP).doubleValue();
                y4 = new BigDecimal(y4).setScale(8, RoundingMode.HALF_UP).doubleValue();

//               Создадим новую точку в которую будем сеттить значения.
                I2DPointImpl i2DPoint = new I2DPointImpl();

//               Частный случай 1. Проверим являются ли оба отрезка вертикальными.
                if (x1 - x2 == 0 && x3 - x4 == 0) {
//                    Проверим лежат ли они на одном X.
                    if (x1 == x3) {
//                        Проверим наличие общих точек.
                        if ((Math.max(y1, y2) < Math.min(y3, y4)) ||
                                (Math.min(y1, y2) > Math.max(y3, y4))) {
//                            Значит пересечений не имеют.
                            continue;
                        }
//                        Могут иметь пересеченеи только в общих точка такие как начало/конец сегмента.
                        if (y1 == y3 || y1 == y4) {
                            i2DPoint.setX(x1);
                            i2DPoint.setY(y1);
                            currentI2DPoints.add(i2DPoint);
//                            Точка найдена, переходим к следующей итерации.
                            continue;
                        }
                        if (y2 == y3 || y2 == y4) {
                            i2DPoint.setX(x2);
                            i2DPoint.setY(y2);
                            currentI2DPoints.add(i2DPoint);
//                           Точка найдена, переходим к следующей итерации.
                            continue;
                        }
                    }
                }

//              Частный случай 2. Проверим являются ли первый отрезок вертикальным.
                if (x1 - x2 == 0) {
//                    Предположим, что x вертикального отрезка является абсциссой точки пересечения,
//                    при этом неважно где второй отрезок пересекает первый, при любом раскаде,
//                    точка перечения будет принадлежать первому отрезку, то есть х известен.
                    double x = x1;
                    double a = (y3 - y4) / (x3 - x4);
                    double c = y3 - a * x3;
                    double y = a * x + c;

//                    Округлим значения для дальнейшей корректной работы.
                    y = new BigDecimal(y).setScale(8, RoundingMode.HALF_UP).doubleValue();

//                    Проверяем что полученная точка лежит в диапозоне допустимых значений,
//                    то есть не выходит за пределы координанатных точек наших отрезков.
                    if (x3 <= x && x <= x4 && Math.min(y1, y2) <= y && y <= Math.max(y1, y2)) {
                        i2DPoint.setX(x);
                        i2DPoint.setY(y);
                        currentI2DPoints.add(i2DPoint);
                    }
                    continue;
                }

//              Частный случай 3. Проверим являются ли второй отрезок вертикальным.
                if (x3 - x4 == 0) {
                    double x = x3;
                    double b = (y1 - y2) / (x1 - x2);
                    double d = y1 - b * x1;
                    double y = b * x + d;

//                    Округлим значения для дальнейшей корректной работы.
                    y = new BigDecimal(y).setScale(8, RoundingMode.HALF_UP).doubleValue();

//                    Проверяем что полученная точка лежит в диапозоне допустимых значений,
//                    то есть не выходит за пределы, координанатных точек наших отрезков.
                    if (x1 <= x && x <= x2 && Math.min(y3, y4) <= y && y <= Math.max(y3, y4)) {
                        i2DPoint.setX(x);
                        i2DPoint.setY(y);
                        currentI2DPoints.add(i2DPoint);
                    }
                    continue;
                }
//                Общий случай.
//                Найдем угловой коэффициент а для первого уравнения.
                double a = (y1 - y2) / (x1 - x2);
//                Найдем коэффициент с для первого уравнения.
                double c = y1 - a * x1;
//                Найдем угловой коэффициент b для второго уравнения.
                double b = (y3 - y4) / (x3 - x4);
//                Найдем коэффициент d для второго уравнения.
                double d = y3 - a * x3;

//                Округляем a, b, c, d
                a = new BigDecimal(a).setScale(8, RoundingMode.HALF_UP).doubleValue();
                c = new BigDecimal(c).setScale(8, RoundingMode.HALF_UP).doubleValue();
                b = new BigDecimal(b).setScale(8, RoundingMode.HALF_UP).doubleValue();
                d = new BigDecimal(d).setScale(8, RoundingMode.HALF_UP).doubleValue();

//                Проверим параллельны ли прямые. Прямые параллельны при а=b.
                if (a == b) {
                    continue;
                }
//                Проверим имеют ли прямые точки пересечения. Прямые при c!=d - различны и пересечений не имюют.
                if (c != d) {
                    continue;
                }

                double x = (d - c) / (a - b);
//                Вычислим y:
                double y = a * x + c;

//                Округляем x, y
                x = new BigDecimal(x).setScale(8, RoundingMode.HALF_UP).doubleValue();
                y = new BigDecimal(y).setScale(8, RoundingMode.HALF_UP).doubleValue();

                i2DPoint.setX(x);
                i2DPoint.setY(y);
                currentI2DPoints.add(i2DPoint);
            }
//           Проверяем значения аккумулятора, если он пуст, значит пересечения с нашим первым отрезком отсутсвуют.
            if (currentI2DPoints.size() == 0) {
                continue;
            }
            map.put(firstSegment, currentI2DPoints);
        }
//        Вытаскиваем все значения мапы, и объединяем их для поиска намименьшего X
        TreeSet<I2DPoint> values = new TreeSet<>((o1, o2) -> (int) (o1.getX() - o2.getX() == 0 ?
                o1.getY() - o2.getY() : o1.getX() - o2.getX()));

        for (Set<I2DPoint> set : map.values()){
            values.addAll(set);
        }
//        Находим наименьшее значение в мапе, отсортированное по X
            I2DPoint point = values.first();

        Set<I2DPoint> result = new TreeSet<>();

//        Ищем в мапе все значения с наименьшими X
        for (I2DPoint p : values) {
            if (p.getX() == point.getX()) {
                result.add(p);
            }
        }
        return result;
    }
}

