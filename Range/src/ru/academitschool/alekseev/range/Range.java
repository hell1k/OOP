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

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public Range getIntersection(Range range) {
        if (to <= range.getFrom() || range.getTo() <= from) {
            return null;
        }

        return new Range(Math.max(from, range.getFrom()), Math.min(to, range.getTo()));
    }

    public Range[] getUnion(Range range) {
        if (to < range.getFrom()) {
            return new Range[]{new Range(from, to), new Range(range.getFrom(), range.getTo())};
        } else if (range.getTo() < from) {
            return new Range[]{new Range(range.getFrom(), range.getTo()), new Range(from, to)};
        }

        return new Range[]{new Range(Math.min(from, range.getFrom()), Math.max(to, range.getTo()))};
    }

    public Range[] getDifference(Range range) {
        if (to < range.from || range.to < from) {
            return new Range[]{new Range(from, to)};
        } else if (from < range.from) {
            if (to > range.to) {
                return new Range[]{new Range(from, range.from), new Range(range.to, to)};
            }

            return new Range[]{new Range(from, range.from)};
        }

        if (to > range.to) {
            return new Range[]{new Range(range.to, to)};
        }

        return new Range[]{};
    }

    @Override
    public String toString() {
        return "(" + from + "; " + to + ")";
    }
}
