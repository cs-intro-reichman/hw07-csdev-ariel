/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		// curve(Integer.parseInt(args[0]),
			  // Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      // Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		

		
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		// snowFlake(Integer.parseInt(args[0]));
		
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n == 0) {
		StdDraw.line(x1, y1, x2, y2);
		return;
		}

		// Determine the points that divide the line to 3 segments
		double x_seg1 = x1 + (x2 - x1) / 3.0;
        double y_seg1 = y1 + (y2 - y1) / 3.0;
        double x_seg2 = x1 + 2.0 * (x2 - x1) / 3.0;
        double y_seg2 = y1 + 2.0 * (y2 - y1) / 3.0;

		double x_seg3 = (Math.sqrt(3.0) / 6.0) * (y_seg1 - y_seg2) + 0.5 * (x_seg1 + x_seg2);
        double y_seg3 = (Math.sqrt(3.0) / 6.0) * (x_seg2 - x_seg1) + 0.5 * (y_seg1 + y_seg2);

		curve(n - 1, x1, y1, x_seg1, y_seg1);
        curve(n - 1, x_seg1, y_seg1, x_seg3, y_seg3); 
        curve(n - 1, x_seg3, y_seg3, x_seg2, y_seg2); 
        curve(n - 1, x_seg2, y_seg2, x2, y2);
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);

		double x1 = 0.1, y1 = 0.3;
        double x2 = 1.0, y2 = 0.3;
        double x3 = 0.55, y3 = 0.3 + (0.9 * Math.sqrt(3.0) / 2.0);

		// Draws a Koch snowflake of depth n
		curve(n, x1, y1, x2, y2);
        curve(n, x2, y2, x3, y3);
        curve(n, x3, y3, x1, y1);
	}
}
