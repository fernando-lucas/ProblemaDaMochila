package principal;

import java.util.Random;
import java.util.Arrays;

public class ProblemaDaMochila {

    public static void main(String[] args) {
        
        Comparador c = new Comparador(4);
        int capacidadeMochila = 20;
        int[][] populacao = new int[4][5];
        
        geraValorParaOsGenes(populacao);
        populacao = calculaFuncaoObjetiva(populacao);

        System.out.println("Sem ordenacao...\n");
        visualizaPopulacao(populacao);
        System.out.println("\n\n");

        avaliaRestricoes(populacao);
        System.out.println("Visualização após a análise de restrições:\n");
        Arrays.sort(populacao, c);
        visualizaPopulacao(populacao);
    }

    public static void geraValorParaOsGenes(int[][] populacao) {
        for (int[] cromossomo : populacao) {
            for (int j = 0; j < cromossomo.length; j++) {
                switch (j) {
                    case 0:
                        cromossomo[j] = geraQuantidadeObjetos(4);
                        break;
                    case 1:
                        cromossomo[j] = geraQuantidadeObjetos(2);
                        break;
                    case 2:
                        cromossomo[j] = geraQuantidadeObjetos(5);
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

    public static int[] calculaFuncaoObjetiva(int[] cromossomo) {
        int peso = 0;
        int valor = 0;
        for (int j = 0; j < cromossomo.length; j++) {
            if (j == 0) {
                peso += cromossomo[j] * 3;
                valor += cromossomo[j] * 40;
            }
            if (j == 1) {
                peso += cromossomo[j] * 5;
                valor += cromossomo[j] * 100;
            }
            if (j == 2) {
                peso += cromossomo[j] * 2;
                valor += cromossomo[j] * 50;
            }
        }
        cromossomo[3] = peso;
        cromossomo[4] = valor;
        return cromossomo;
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

    public static void visualizaCromossomo(int[] cromossomo) {
        for (int i = 0; i < cromossomo.length; i++) {
            System.out.print(cromossomo[i] + " - ");
        }
        System.out.println("\n");
    }

    public static int[][] avaliaRestricoes(int[][] populacao) {
        //int[][] novaPupulacao = populacao;
        for (int i = 0; i < populacao.length; i++) {
            if (populacao[i][3] > 20) {
                System.out.println("Cromossomos que estão fora dos requisitos: " + i);
                visualizaCromossomo(populacao[i]);
                System.out.println("Inicio - Novo Cromossomo Criado");
                int[] cromossomo = criaCromossomo();
                visualizaCromossomo(cromossomo);
                System.out.println("Fim - Novo Cromossomo Criado");
                //novaPupulacao[i] = cromossomo;
                populacao[i] = cromossomo;
            }
        }
        //return novaPupulacao;
        return populacao;
    }

    public static int[] criaCromossomo() {
        int[] cromossomo = new int[5];

        for (int j = 0; j < cromossomo.length; j++) {
            switch (j) {
                case 0:
                    cromossomo[j] = geraQuantidadeObjetos(4);
                    break;
                case 1:
                    cromossomo[j] = geraQuantidadeObjetos(2);
                    break;
                case 2:
                    cromossomo[j] = geraQuantidadeObjetos(5);
                    break;
            }
        }
        calculaFuncaoObjetiva(cromossomo);
        if(cromossomo[3] > 20) {
           int[] novoCromossomo = criaCromossomo();
           return novoCromossomo;
        }
        return cromossomo;
    }
}
