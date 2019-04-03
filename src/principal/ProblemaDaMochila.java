package principal;

import java.util.Random;

public class ProblemaDaMochila {

    public static void main(String[] args) {

        int[][] populacao = new int[4][3];
        
        geraValoresParaOsGenomas(populacao);
       
        visualizaPopulacao(populacao);
        
        
    }

    public static void geraValoresParaOsGenomas(int[][] populacao) {
        for (int[] populacao1 : populacao) {
            for (int j = 0; j < populacao1.length; j++) {
                populacao1[j] = geraQuantidadeObjetos(4);
            }
        }
    }
    
    public static void visualizaPopulacao(int[][] populacao){
        
        for (int i = 0; i < populacao.length; i++) {
            System.out.println("Genoma: " + i + "\nAtributos:");
            for (int j = 0; j < populacao[i].length; j++) {
                System.out.print(populacao[i][j] + " - ");
            }
            System.out.println("\n");
        }
    }
    
    public static int geraQuantidadeObjetos(int quantidadeMaxObjetos) {
        Random gerador = new Random();
        //double roleta = gerador.nextDouble();

        if (quantidadeMaxObjetos == 1) {
            double roleta = gerador.nextDouble();
            if (roleta <= 0.5) {
                return 0;
            } else if (roleta > 0.5 && roleta <= 1.0) {
                return 1;
            } else {
                System.out.println("Erro! Verifique a condição.");
                return -1;
            }
        } else if (quantidadeMaxObjetos == 2) {
            double roleta = gerador.nextDouble();
            if (roleta <= 0.333) {
                return 0;
            } else if (roleta > 0.333 && roleta <= 0.667) {
                return 1;
            } else if (roleta > 0.667 && roleta <= 1.0) {
                return 2;
            } else {
                System.out.println("Erro! Verifique a condição.");
                return -1;
            }
        } else if (quantidadeMaxObjetos == 3) {
            double roleta = gerador.nextDouble();
            if (roleta <= 0.250) {
                return 0;
            } else if (roleta > 0.250 && roleta <= 0.500) {
                return 1;
            } else if (roleta > 0.500 && roleta <= 0.750) {
                return 2;
            } else if (roleta > 0.750 && roleta <= 1.000) {
                return 3;
            } else {
                System.out.println("Erro! Verifique a condição.");
                return -1;
            }
        } else if (quantidadeMaxObjetos == 4) {
            double roleta = gerador.nextDouble();
            if (roleta <= 0.200) {
                return 0;
            } else if (roleta > 0.200 && roleta <= 0.400) {
                return 1;
            } else if (roleta > 0.400 && roleta <= 0.600) {
                return 2;
            } else if (roleta > 0.600 && roleta <= 0.800) {
                return 3;
            } else if (roleta > 0.800 && roleta <= 1.000) {
                return 4;
            } else {
                System.out.println("Erro! Verifique a condição.");
                return -1;
            }
        } else if (quantidadeMaxObjetos == 5) {
            double roleta = gerador.nextDouble();
            if (roleta <= 0.167) {
                return 0;
            } else if (roleta > 0.166 && roleta <= 0.333) {
                return 1;
            } else if (roleta > 0.333 && roleta <= 0.500) {
                return 2;
            } else if (roleta > 0.500 && roleta <= 0.666) {
                return 3;
            } else if (roleta > 0.666 && roleta <= 0.833) {
                return 4;
            }else if (roleta > 0.833 && roleta <= 1.000) {
                return 5;
            } else {
                System.out.println("Erro! Verifique a condição.");
                return -1;
            }
        } else {
            return -1;
        }
    }

}
