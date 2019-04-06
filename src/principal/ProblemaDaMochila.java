package principal;

import java.util.Random;
import java.util.Arrays;

public class ProblemaDaMochila {

    public static void main(String[] args) {

        int capacidadeMochila = 20;

        int[][] populacao = new int[4][5];

        geraValorParaOsGenes(populacao);

        int[][] x = calculaFuncaoObjetiva(populacao);

        System.out.println("Sem ordenacao...\n");
        visualizaPopulacao(x);
        System.out.println("\n\n");

        Comparador c = new Comparador(4);

        Arrays.sort(x, c);

        System.out.println("Ordenado...\n");
        visualizaPopulacao(x);

    }

    public static void geraValorParaOsGenes(int[][] populacao) {
        for (int[] populacao1 : populacao) {
            for (int j = 0; j < populacao1.length; j++) {
                switch (j) {
                    case 0:
                        populacao1[j] = geraQuantidadeObjetos(4);
                        break;
                    case 1:
                        populacao1[j] = geraQuantidadeObjetos(2);
                        break;
                    case 2:
                        populacao1[j] = geraQuantidadeObjetos(5);
                        break;
                }
            }
        }
    }

    public static int geraQuantidadeObjetos(int quantidadeMaxObjetos) {
        Random gerador = new Random();
        //double roleta = gerador.nextDouble();
        switch (quantidadeMaxObjetos) {
            case 1: {
                double roleta = gerador.nextDouble();
                if (roleta <= 0.5) {
                    return 0;
                } else if (roleta > 0.5 && roleta <= 1.0) {
                    return 1;
                } else {
                    System.out.println("Erro! Verifique a condição.");
                    return -1;
                }
            }
            case 2: {
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
            }
            case 3: {
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
            }
            case 4: {
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
            }
            case 5: {
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
                } else if (roleta > 0.833 && roleta <= 1.000) {
                    return 5;
                } else {
                    System.out.println("Erro! Verifique a condição.");
                    return -1;
                }
            }
            default:
                return -1;
        }
    }
    
    public static void visualizaPopulacao(int[][] populacao) {

        for (int i = 0; i < populacao.length; i++) {
            System.out.println("Cromossomo: " + i + "\nGenes:");
            for (int j = 0; j < populacao[i].length; j++) {
                System.out.print(populacao[i][j] + " - ");
            }
            System.out.println("\n");
        }
    }

    public static int[][] calculaFuncaoObjetiva(int[][] populacao) {

        int[][] retorno = new int[4][4];

        for (int i = 0; i < populacao.length; i++) {
            int peso = 0;
            int valor = 0;
            System.out.println("Cromossomo: " + populacao[i]);
            System.out.println("--------------------------------------");
            for (int j = 0; j < populacao[i].length; j++) {

                if (j == 0) {
                    System.out.println("Gene 0" + (j + 1));
                    System.out.println("Quantidade de itens: " + populacao[i][j]);
                    System.out.println("Peso dos Items: " + populacao[i][j] * 3);
                    System.out.println("Valor dos Items: " + populacao[i][j] * 40 + "\n");
                    peso += populacao[i][j] * 3;
                    valor += populacao[i][j] * 40;
                }
                if (j == 1) {
                    System.out.println("Gene 0" + (j + 1));
                    System.out.println("Quantidade de itens: " + populacao[i][j]);
                    System.out.println("Peso dos Items: " + populacao[i][j] * 5);
                    System.out.println("Valor dos Items: " + populacao[i][j] * 100 + "\n");
                    peso += populacao[i][j] * 5;
                    valor += populacao[i][j] * 100;
                }
                if (j == 2) {
                    System.out.println("Gene 0" + (j + 1));
                    System.out.println("Quantidade de itens: " + populacao[i][j]);
                    System.out.println("Peso dos Items: " + populacao[i][j] * 2);
                    System.out.println("Valor dos Items: " + populacao[i][j] * 50 + "\n");
                    peso += populacao[i][j] * 2;
                    valor += populacao[i][j] * 50;
                }
            }
            populacao[i][3] = peso;
            populacao[i][4] = valor;
            System.out.println("Peso Agregado: " + peso);
            System.out.println("Valor Agregado: " + valor + "\n\n");
            retorno[i] = populacao[i];
        }
        return retorno;
    }
}
