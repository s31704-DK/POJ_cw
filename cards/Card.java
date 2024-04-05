package Card;

public class Card {
        public enum Value {
        N2(2),
        N3(3),
        N4(4),
        N5(5),
        N6(6),
        N7(7),
        N8(8),
        N9(9),
        N10(10),
        J(11),
        Q(12),
        K(13),
        A(14);

        private final int VALUE;

        protected int getValue() {
                return VALUE;
        }

        private Value(int value) {
            this.VALUE = value;
        }
    }

    public enum Color {
        Kier(4),
        Karo(3),
        Trefl(2),
        Pik(1);

        private final int VALUE;

        protected int getValue() {
                return VALUE;
        }

        private Color (int value) {
                this.VALUE = value;
        }
    }

    private final Value VALUE;
    private final Color COLOR;

    public Value getValue() {
        return VALUE;
    }
    public int getValueValue() {
        return VALUE.getValue();
    }

    public Color getColor() {
        return COLOR;
    }
    public int getColorValue() {
        return COLOR.getValue();
    }

    public boolean[] checkHigher(Card cardTwo){
        if (VALUE.getValue() > cardTwo.getValueValue()) {
            return new boolean[]{true, false};
        } else if (VALUE.getValue() < cardTwo.getValueValue()) {
            return new boolean[]{false, false};
        } else {
            if (COLOR.getValue() > cardTwo.getColorValue()) {
                return new boolean[]{true, false};
            } else if (COLOR.getValue() < cardTwo.getColorValue()) {
                return new boolean[]{false, false};
            } else {
                return new boolean[]{false, true};
            }
        }
    }

    public Card(Value value, Color color) {
        this.VALUE = value;
        this.COLOR = color;
    }
}
