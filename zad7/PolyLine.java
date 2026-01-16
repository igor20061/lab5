package lab5.zad7_1;

public class PolyLine {
    private Point[] points;

    public PolyLine(Point[] points) {
        this.points = points;
    }

    public Point[] getPoints() {
        return points;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Линия [");
        for (int i = 0; i < points.length; i++) {
            sb.append(points[i]);
            if (i < points.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
