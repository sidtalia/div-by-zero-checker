import org.checkerframework.checker.dividebyzero.qual.*;

// A simple test case for your divide-by-zero checker.
// The file contains "// ::" comments to indicate expected
// errors and warnings.
//
// Passing this test does not guarantee a perfect grade on this assignment,
// but it is an important start. You should always write your own test cases,
// in addition to using those provided to you.
class Foo {
    public static void operator_errors() {
        int x = 1;
        int y = 1;
        int z = 1;
        int t = 1; // test variable 
        // :: error: divide.by.zero
        t = z/(x - y);
        // :: error: divide.by.zero
        t = y/(z - x);
        // :: error: divide.by.zero
        t = x/(z - y);
        // :: error: divide.by.zero
        t = x/(2*z - y - x);
        x *= 0;
        y *= 0;
        // :: error: divide.by.zero
        t = z/(x + y);
        t = y/(z + x);
        t = x/(z + y);
        // :: error: divide.by.zero
        t = (x - z)/y;
        t = (x - y)/z;
        x *= 1;
        y *= 1;
        // we should still get the same errors
        // :: error: divide.by.zero
        t = z/(x + y);
        t = y/(z + x);
        t = x/(z + y);
        // :: error: divide.by.zero
        t = (x - z)/y;
        t = (x - y)/z;
        // :: error: divide.by.zero
        t = (z - y)/x;
    }
    public static void f() {
        int one  = 1;
        int zero = 0;
        // :: error: divide.by.zero
        int x    = one / zero;
        int y    = zero / one;
        // :: error: divide.by.zero
        int z    = x / y;
        String s = "hello";
    }

    public static void g(int y) {
        if (y == 0) {
            // :: error: divide.by.zero
            int x = 1 / y;
        } else {
            int x = 1 / y;
        }

        if (y != 0) {
            int x = 1 / y;
        } else {
            // :: error: divide.by.zero
            int x = 1 / y;
        }

        if (!(y == 0)) {
            int x = 1 / y;
        } else {
            // :: error: divide.by.zero
            int x = 1 / y;
        }

        if (!(y != 0)) {
            // :: error: divide.by.zero
            int x = 1 / y;
        } else {
            int x = 1 / y;
        }

        if (y < 0) {
            int x = 1 / y;
        }

        if (y <= 0) {
            // :: error: divide.by.zero
            int x = 1 / y;
        }

        if (y > 0) {
            int x = 1 / y;
        }

        if (y >= 0) {
            // :: error: divide.by.zero
            int x = 1 / y;
        }
    }

    public static void h() {
        int zero_the_hard_way = 0 + 0 - 0 * 0;
        // :: error: divide.by.zero
        int x = 1 / zero_the_hard_way;

        int one_the_hard_way = 0 * 1 + 1;
        int y = 1 / one_the_hard_way;
    }

    public static void l() {
        // :: error: divide.by.zero
        int a = 1 / (1 - 1);
        int y = 1;
        // :: error: divide.by.zero
        int x = 1 / (y - y);
        int z = y-y;
        // :: error: divide.by.zero
        int k = 1/z;
    }
}
