public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacciLinear(10));
        System.out.println(fibonacciRecursiva(10));
    }

    public static int fibonacciLinear(int N){
        if (N < 0) //Validação da entrada
            return -1;
        int fib = 0; //Numero de Fibonacci atual
        int pFib = 1; //Próximo numero de Fibonacci
        int temp; //Temporário usado na conta
        for(int i = 0; i < N; i ++){
            temp = fib;
            fib = pFib;
            pFib = temp + fib; //Próximo numero de Fibonacci recebe o anterior + atual
        }
        return fib;
    }

    public static int fibonacciRecursiva(int N){
        if (N < 0) //Validação da entrada
            return -1;
        return fibRecInterna(N); //Chama a função recursiva interna, para evitar testar N<0 a cada iteração
    }
    private static int fibRecInterna(int N){
        if (N == 0){ //Primeiro caso base
            return 0;
        } else if (N == 1){ // Segundo caso base
            return 1;
        }
        else{
            return fibRecInterna(N-1)+fibRecInterna(N-2); // Passo recursivo fib(N) = fib(N-1)+fib(N-2)
        }
    }
}
