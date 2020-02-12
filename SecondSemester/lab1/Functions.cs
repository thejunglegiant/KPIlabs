namespace lab1 {
    class Functions {
        public static int Increment(int a) {
            int counter = 0;
 
            while((a & (1 << counter)) > 0)
                counter++;
            
            a ^= ((1 << (counter + 1)) - 1);

            return a;
        }

        public static bool CompareBinaries(int a, int b) {
            return (a ^ b) == 0;
        }
    }
}