import java.util.ArrayList;
import java.util.Arrays;

public class Primos {

    public static void main(String[] args) {
        System.out.println(numerosPrimosLinear(100));
        System.out.println(numerosPrimosRecursivo(100));
    }

    public static ArrayList<Integer> numerosPrimosLinear(int N){
        if (N < 2){ //Validação de entrada
            return null;
        }
        /*Criar o array de numeros primos, com o primeiro primo já dentro, o numero 2 */
        ArrayList<Integer> arrPrimos = new ArrayList<>(Arrays.asList(new Integer[]{2}));
        /* Iterar sobre todos os numeros de 3 até N (inclusive), para cada número 'i' tentar dividi-lo pelos numeros primos
           já encontrados que sejam menores que sqrt(i), se 'i' não for divisivel por nenhum dos primos menores que sqrt(i),
           'i' é primo e é adicionado a lista */
        for(int i = 3; i <= N; i++) {
            for (int j = 0; j < arrPrimos.size(); j++) {
                if(i % arrPrimos.get(j) == 0 ){
                    break;
                } else if (Math.sqrt(i) < arrPrimos.get(j) || j == (arrPrimos.size()-1)){
                    arrPrimos.add(i);
                    break;
                }
            }
        }
        return arrPrimos;
    }

    public static ArrayList<Integer> numerosPrimosRecursivo(int N){
        if (N < 2){ //Validação de entrada
            return null;
        }
        /*Criar o array de numeros primos, com o primeiro primo já dentro, o numero 2 */
        ArrayList<Integer> arrPrimos = new ArrayList<>(Arrays.asList(new Integer[]{2}));
        if (N == 2){ //Caso base
            return arrPrimos;
        }
        /*Chamada recursiva interna, para evitar testar as condições acima desnecessáriamente*/
        primosRecInterno(arrPrimos,N, 3);
        return arrPrimos;
    }

    private static ArrayList<Integer> primosRecInterno(ArrayList<Integer> arrPrimos, int N, int i){
        /* Dado o 'i' atual a ser testado, tentar dividi-lo pelos numeros primos já encontrados que sejam menores que
           sqrt(i), se 'i' não for divisivel por nenhum dos primos menores que sqrt(i),'i' é primo e é adicionado a lista */
        for (int j = 0; j < arrPrimos.size(); j++) {
            if(i % arrPrimos.get(j) == 0 ){
                break;
            } else if (Math.sqrt(i) < arrPrimos.get(j) || j == (arrPrimos.size()-1)){
                arrPrimos.add(i);
                break;
            }
        }
        /* Se o próximo numero for menor ou igual ao numero máximo a ser testado, chama a função recursivamente para ele */
        if(++i <= N){
            primosRecInterno(arrPrimos,N,i);
        }
        return arrPrimos;
    }
}


