public class ComplexNumber {

    // The real part (a) in a + bi.
    private double realNum;

    // The imaginary part (b) in a + bi.
    private double imagNum;

    // Make a complex number from real and imaginary values.
    public ComplexNumber(double realNum, double imagNum) {
        this.realNum = realNum;
        this.imagNum = imagNum;
    }

    // Add two complex numbers: (a + bi) + (c + di).
    public ComplexNumber add(ComplexNumber o) {
        return new ComplexNumber(realNum + o.realNum, imagNum + o.imagNum);
    }

    // Square a complex number: (a + bi)^2 = (a^2 - b^2) + 2ab i.
    public ComplexNumber square() {
        return new ComplexNumber(realNum * realNum - imagNum * imagNum, 2 * realNum * imagNum);
    }

    // Magnitude squared: |z|^2 = a^2 + b^2.
    // We use this to check escape in Mandelbrot (escape if |z| > 2, so |z|^2 > 4).
    public double mag2() {
        return realNum * realNum + imagNum * imagNum;
    }
}
