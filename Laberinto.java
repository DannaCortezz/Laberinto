import java.util.Stack;

public class Laberinto {
    
    // Método que recorre el laberinto a partir de la posición inicial (i, j)
    public static boolean buscarSalida(int[][] laberinto, int i, int j) {
        
        int m = laberinto.length;
        int n = laberinto[0].length;
        
        // Creamos una pila para guardar los puntos de decisión
        Stack<int[]> pila = new Stack<>();
        
        // Marcamos la posición inicial como visitada
        laberinto[i][j] = '*';
        
        // Empezamos el recorrido por el laberinto
        while (true) {
            
            // Verificamos si hemos llegado a una salida del laberinto
            if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                imprimirRuta();
                return true;
            }
            
            // Buscamos una dirección en la que podamos movernos
            boolean encontrado = false;
            int[][] movimientos = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            for (int[] mov : movimientos) {
                int fila = i + mov[0];
                int col = j + mov[1];
                if (fila >= 0 && fila < m && col >= 0 && col < n && laberinto[fila][col] == 0) {
                    encontrado = true;
                    // Guardamos el punto de decisión en la pila
                    pila.push(new int[] {i, j});
                    // Movemos la posición actual a la nueva dirección
                    i = fila;
                    j = col;
                    // Marcamos la nueva posición como visitada
                    laberinto[i][j] = 2;
                    break;
                }
            }
            
            // Si no encontramos ninguna dirección en la que podamos movernos, retrocedemos
            if (!encontrado) {
                if (pila.empty()) {
                    return false; // No hay solución
                }
                int[] puntoDecision = pila.pop();
                i = puntoDecision[0];
                j = puntoDecision[1];
            }
        }}
        public static void main(String[] args) {
        int[][] laberinto = {
                 {'1', '1', '1', '1', '1', '1', 'E', '1', '1', '1'},
                {'1', '0', '1', '0', '0', '0','0', '0', '0', '1'},
                {'1', '0', '0', '0', '1', '0','0', '1', '0', '1'},
                {'1', '1', '1', '1', '0', '0','1', '1', '1', '1'},
                {'1', '0', '0', '0', '0', '1','0', '0', '0', '1'},
                {'1', '0', '1', '1', '1', '1','0', '1', '0', '1'},
                {'1', '0', '0', '0', '0', '1','0', '1', '0', '1'},
                {'1', '1', '0', '1', '1', '1','0', '1', '0', '1'},
                {'1', '0', '0', '0', '0', '0','0', '1', '0', '1'},
                {'1', '0', '0', '0', '0', '1','0', '1', '0', '1'},
                {'1', '1', '1', '1', '1', '1','1', '1', '0', '1'},
        };
        }
    }
    
   
