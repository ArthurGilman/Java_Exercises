//package practice;
//
//import lombok.Getter;
//
//import java.math.BigDecimal;
//import java.math.RoundingMode;
//import java.util.Arrays;
//
//class Scratch {
//    private static final BigDecimal PI = BigDecimal.valueOf(3.14159);
//
//    public static void main(String[] args) {
//        final Circle circle = new Circle(BigDecimal.TEN);
//        final FlatShape square = new Square(BigDecimal.TEN);
//        final Sphere sphere = new Sphere(BigDecimal.TWO, BigDecimal.valueOf(33));
//        // Есть взаимная зависимость между высотой и боковой стороной (высота <= боковой стороны),
//        // поэтому вместо задания трёх длин лучше использовать длины двух сторон и угол,
//        // здесь сделано для простоты
//        final FlatShape parallelogram = new Parallelogram(BigDecimal.TEN, BigDecimal.ONE, BigDecimal.TWO);
//        final VolumetricShape cube = new Cube(BigDecimal.TEN, BigDecimal.valueOf(15.123));
//
//        System.out.println("Summary area of all shapes: " + sumArea(circle, square, sphere, parallelogram, cube));
//        System.out.println("Summary perimeter of flat shapes: " +
//                sumPerimeter(circle, square, parallelogram));
//        System.out.println("Summary volume of volumetric shapes: " +
//                sumVolume(sphere, cube));
//        System.out.println("Average radius of round shapes: " +
//                calculateAverageRadius(circle, sphere));
//        System.out.println("Summary weight of volumetric shapes: " +
//                sumWeight(sphere, cube));
//    }
//
//    private static BigDecimal sumArea(Shape... shapes) {
//        return Arrays.stream(shapes)
//                .map(Shape::getArea)
//                .reduce(BigDecimal::add)
//                .orElseThrow();
//    }
//
//    private static BigDecimal sumPerimeter(FlatShape... shapes) {
//        return Arrays.stream(shapes)
//                .map(FlatShape::getPerimeter)
//                .reduce(BigDecimal::add)
//                .orElseThrow();
//    }
//
//    private static BigDecimal sumVolume(VolumetricShape... shapes) {
//        return Arrays.stream(shapes)
//                .map(VolumetricShape::getVolume)
//                .reduce(BigDecimal::add)
//                .orElseThrow();
//    }
//
//    private static BigDecimal calculateAverageRadius(IRound... shapes) {
//        return Arrays.stream(shapes)
//                .map(IRound::getRadius)
//                .reduce(BigDecimal::add)
//                .map(sum -> sum.divide(BigDecimal.valueOf(shapes.length), RoundingMode.HALF_UP))
//                .orElseThrow();
//    }
//
//    private static BigDecimal sumWeight(VolumetricShape... shapes) {
//        return Arrays.stream(shapes)
//                .map(VolumetricShape::getWeight)
//                .reduce(BigDecimal::add)
//                .orElseThrow();
//    }
//
////    @Getter
////    static abstract class Shape {
////        private final BigDecimal area;
////
////        Shape(BigDecimal area) {
////            this.area = area;
////        }
////    }
////
////    @Getter
////    static abstract class FlatShape extends Shape {
////        private final BigDecimal perimeter;
////
////        public FlatShape(BigDecimal area, BigDecimal perimeter) {
////            super(area);
////            this.perimeter = perimeter;
////        }
////
////    }
////
////    @Getter
////    static abstract class VolumetricShape extends Shape {
////        private final BigDecimal volume;
////        private final BigDecimal weight;
////
////        public VolumetricShape(BigDecimal area, BigDecimal volume, BigDecimal weight) {
////            super(area);
////            this.volume = volume;
////            this.weight = weight;
////        }
////
////    }
////
////    static class Circle extends FlatShape implements IRound {
////        private final BigDecimal radius;
////
////        Circle(BigDecimal radius) {
////            super(radius.pow(2).multiply(PI),
////                    radius.multiply(PI).multiply(BigDecimal.TWO));
////            this.radius = radius;
////        }
////
////        @Override
////        public BigDecimal getRadius() {
////            return radius;
////        }
////    }
////
////    static class Sphere extends VolumetricShape implements IRound {
////        // Прим.: У сферы, как и у круга, есть радиус, но нет периметра
////        // Поэтому не вполне корректно делать и наследование сферы от круга, и делать круг как сферу с нулевым объёмом
////        private final BigDecimal radius;
////
////        public Sphere(BigDecimal radius, BigDecimal weight) {
////            super(radius.pow(3).multiply(PI),
////                    radius.pow(3).multiply(PI).multiply(BigDecimal.valueOf(4)).divide(BigDecimal.valueOf(3), RoundingMode.HALF_UP),
////                    weight);
////            this.radius = radius;
////        }
////
////        @Override
////        public BigDecimal getRadius() {
////            return radius;
////        }
////    }
////
////    static class Parallelogram extends FlatShape {
////        private final BigDecimal base; // Основание: __
////        private final BigDecimal height; // Высота: |
////        private final BigDecimal side; // Боковая грань: /
////
////        public Parallelogram(BigDecimal base, BigDecimal height, BigDecimal side) {
////            super(base.multiply(height),
////                    base.add(side).multiply(BigDecimal.TWO));
////            this.base = base;
////            this.height = height;
////            this.side = side;
////        }
////    }
////
////    static class Square extends Parallelogram {
////        public Square(BigDecimal side) {
////            super(side, side, side);
////        }
////    }
////
////    static class Cube extends VolumetricShape {
////        private final BigDecimal side;
////
////        public Cube(BigDecimal side, BigDecimal weight) {
////            super(side.pow(2).multiply(BigDecimal.valueOf(6)),
////                    side.pow(3),
////                    weight);
////            this.side = side;
////        }
////    }
////
////    interface IRound {
////        BigDecimal getRadius();
////    }
//}