package io.zipcoder.casino.dicegames.dice;

    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Random;

    public class Dice {
        public int dieCount;
        private ArrayList<Integer> lastRoll = new ArrayList<Integer>();

        private HashMap<Integer, Character> diceGraphics = new HashMap<Integer, Character>() {{
            put(1,'⚀');
            put(2,'⚁');
            put(3,'⚂');
            put(4,'⚃');
            put(5,'⚄');
            put(6,'⚅');
        }}
                ;

        public char getDieGraphic(int roll) {
            return diceGraphics.get(roll);
        }

        public String getLastRollGraphic() {
            String lastRollGraphic = "";
            for (Integer roll : lastRoll) {
                lastRollGraphic += getDieGraphic(roll) + " ";
            }
            return lastRollGraphic;
        }

        //        Dice(){ this.dieCount = 1; }

        public Dice(int dieCount) {
            this.dieCount = dieCount;
        }

        public Dice() {
            this.dieCount = 1;
        }

        public int tossAndSum() {
            Random random = new Random();

            int rollSum = 0;
            lastRoll = null;
            for (int i = 0; i < dieCount; i++) {
                int roll = random.nextInt(6)+1;
                lastRoll.add(roll);
                rollSum += roll;
            }
            return rollSum;
        }

        public ArrayList<Integer> getLastRoll() {
            return lastRoll;
        }

    }
