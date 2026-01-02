/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {

		// Sets the coordinates of the triangle's vertices
		double x1 = 0.0; double x2 = 1.0; double x3 = 0.5;
		double y1 = 0.0; double y2 = 0.0; double y3 = 0.866;

		sierpinski(n, x1, x2, x3, y1, y2, y3);
	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {
		if (n <= 0) return;
		
		StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(x1, y1, x2, y2);
        StdDraw.line(x2, y2, x3, y3);
        StdDraw.line(x3, y3, x1, y1);

		sierpinski(n-1, x1, (x1 + x2) / 2.0, (x3 + x1) / 2.0, y1, (y1 + y2) / 2.0, (y3 + y1) / 2.0);
		sierpinski(n-1, (x1 + x2) / 2.0, x2, (x2 + x3) / 2.0, (y1 + y2) / 2.0, y2, (y2 + y3) / 2.0);
		sierpinski(n-1, (x3 + x1) / 2.0, (x2 + x3) / 2.0, x3, (y3 + y1) / 2.0, (y2 + y3) / 2.0, y3);
	}
}
