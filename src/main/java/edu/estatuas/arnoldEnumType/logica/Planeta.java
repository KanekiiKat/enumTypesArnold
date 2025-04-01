package edu.estatuas.arnoldEnumType.logica;

public enum Planeta {

    MERCURY (3.303e+23, 2.4397e6),     
    VENUS   (4.869e+24, 6.0518e6),     
    EARTH   (5.976e+24, 6.37814e6),     
    MARS    (6.421e+23, 3.3972e6),     
    JUPITER (1.9e+27,   7.1492e7),     
    SATURN  (5.688e+26, 6.0268e7),     
    URANUS  (8.686e+25, 2.5559e7),     
    NEPTUNE (1.024e+26, 2.4746e7);  

    private double masa;
    private double radio;

    private static final double G = 6.674e-11;

    private Planeta(double masa, double radio) {
        
        this.masa = masa;
        this.radio = radio;
        
    }

    public  double pesoSuperficie(double miPeso){
        double gravedad = G * this.masa / (this.radio * this.radio );
        return gravedad * miPeso;
    }

    public static Planeta[] getPlanetasTerrestres() {
        return new Planeta[] {MERCURY, VENUS, EARTH, MARS} ;
    }

    public static Planeta[] getGigantesGaseosos() {
        return new Planeta[] {JUPITER, SATURN, URANUS, NEPTUNE};
    }


}