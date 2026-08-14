class Variaveis  { 

    public static void fazAlgo( int numero ) { 
        long quadrado = numero * numero;
        double totalSegundoQuartilAnoAnterior = 0.0;
        System.out.println("Quadrado: " + quadrado);
    }


    public static void main( String[] args ) {

        // float f1 = (float)30.6;  // 30.6 (double)
        float f1 = 30.6f;  // 30.6 (double)

        String strAltura = "1.79";

        float altura = Float.parseFloat( strAltura );

        int alturaInt = (int) altura;

        fazAlgo( alturaInt );


    }

}