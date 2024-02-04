package ru.academitschool.alekseev.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from & number <= to;
    }

    public Range getIntersection(Range range2) {
        if (to <= range2.getFrom() || range2.getTo() <= from) {
            return null;
        }

        return new Range(Math.max(from, range2.getFrom()), Math.min(to, range2.getTo()));
    }

    public Range[] getUnification(Range range2) {
        if (to < range2.getFrom()) {
            return new Range[]{new Range(from, to), new Range(range2.getFrom(), range2.getTo())};
        } else if (range2.getTo() < from) {
            return new Range[]{new Range(range2.getFrom(), range2.getTo()), new Range(from, to)};
        } else {
            return new Range[]{new Range(Math.min(from, range2.getFrom()), Math.max(to, range2.getTo()))};
        }
    }

    public Range[] getDifference(Range range2) {
        if (to < range2.from || range2.to < from) {
            return new Range[]{new Range(from, to)};
        } else if (from < range2.from) {
            if (to > range2.to) {
                return new Range[]{new Range(from, range2.from), new Range(range2.to, to)};
            } else {
                return new Range[]{new Range(from, range2.from)};
            }
        } else {
            if (to > range2.to) {
                return new Range[]{new Range(range2.to, to)};
            } else {
                return new Range[]{};
            }
        }
    }
}
