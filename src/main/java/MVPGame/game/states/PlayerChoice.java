package MVPGame.game.states;

/**
 * Created by 20305 on 20.06.2017.
 */
public enum PlayerChoice {
        HEAL (1, "Heal"),
        FIGHT (2, "Fight"),
        SAVE (3, "Save"),
        EXIT(4, "Exit");

        private int number;
        private String name;

        private PlayerChoice(int number, String name){
            this.number = number;
            this.name = name;
        }

        public String toString(){
            return number + ". " + name;
        }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
