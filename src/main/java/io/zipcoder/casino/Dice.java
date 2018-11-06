package io.zipcoder.casino;

    import java.util.Random;

    public class Dice {
        public int dieCount;

        Dice(){ this.dieCount = 1; }
        Dice(int dieCount) {
            this.dieCount = dieCount;
        }
        Dice() {
            this.dieCount = 1;
        }

        public int tossAndSum() {
            Random random = new Random();

            int rollSum = 0;
            for (int i = 0; i < dieCount; i++) {
                int roll = random.nextInt(6)+1;
                rollSum += roll;
            }
            return rollSum;
        }

}
