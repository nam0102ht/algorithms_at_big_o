package com.ntnn.design.pattern.structural;

public class BridgeCodeDesign {
    interface SuperheroAction {
        void onActivate();
        void apply();
        void onDeactivate();
    }
    interface TheRevenger {
        void appear();
        void attack();
        void retreat();
        SuperheroAction getSuperheroAction();
    }
    static class TheMagician implements TheRevenger {

        private final SuperheroAction getSuperheroAction;

        public TheMagician(SuperheroAction getSuperheroAction) {
            this.getSuperheroAction = getSuperheroAction;
        }

        @Override
        public void appear() {
            System.out.println("The Magician has appeared from nowhere!");
            getSuperheroAction.onActivate();
        }

        @Override
        public void attack() {
            System.out.println("The Magician flies and punches the villain in the face. ");
            getSuperheroAction.apply();
        }

        @Override
        public void retreat() {
            System.out.println("The Magician disappears.");
            getSuperheroAction.onDeactivate();
        }

        @Override
        public SuperheroAction getSuperheroAction() {
            return getSuperheroAction;
        }
    }

    static class AvonTheSlayer implements TheRevenger {

        private final SuperheroAction getSuperheroAction;

        public AvonTheSlayer(SuperheroAction getSuperheroAction) {
            this.getSuperheroAction = getSuperheroAction;
        }

        @Override
        public void appear() {
            System.out.println("Avon The Slayer has appeared from nowhere!");
            getSuperheroAction.onActivate();
        }

        @Override
        public void attack() {
            System.out.println("Avon the Slayer swings his sword swiftly to attack the villain.");
            getSuperheroAction.apply();
        }

        @Override
        public void retreat() {
            System.out.println("Avon The Slayer disappears.");
            getSuperheroAction.onDeactivate();
        }

        @Override
        public SuperheroAction getSuperheroAction() {
            return getSuperheroAction;
        }
    }

    static class TheMagicianAction implements SuperheroAction {

        @Override
        public void onActivate() {
            System.out.println("The Magician is in action.");
        }

        @Override
        public void apply() {
            System.out.println("The punch from The Magician goes through the face of the villian and paralyzes the villian.");
        }

        @Override
        public void onDeactivate() {
            System.out.println("The Magician prepares for her next attack.");
        }
    }

    static class AvonTheSlayerAction implements SuperheroAction {

        @Override
        public void onActivate() {
            System.out.println("Avon The Slayer is in action. ");
        }

        @Override
        public void apply() {
            System.out.println("Avon's sword is deadly and cuts of the villain's arm.");
        }

        @Override
        public void onDeactivate() {
            System.out.println("Avon the Slayer prepares for his next attack.");
        }
    }

    public static void main(String[] args) {
        System.out.println("The Magician recieves a call from the victim.");
        var callingTheMagician = new TheMagician(new TheMagicianAction());
        callingTheMagician.appear();
        callingTheMagician.attack();
        callingTheMagician.retreat();

        System.out.println("Avon the Slayer is being called.");
        var callingAvon = new AvonTheSlayer(new AvonTheSlayerAction());
        callingAvon.appear();
        callingAvon.attack();
        callingAvon.retreat();
    }
}
