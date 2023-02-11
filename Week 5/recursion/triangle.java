public class triangle {
    
    public static void createTriangle(char c, int n) {
        if (n > 0) {
            createTriangle(c, n - 1);
            for (int i = 0; i < n; i++) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        createTriangle('*', 10);
   }
}
