package com.ntnn.design.pattern;

import java.util.HashMap;
import java.util.List;

public class PrototypeDesignPattern {
     interface Revenger {
         Object clone();
    }

    static class TheMagician implements Revenger {
        public String name = "The Magician";

        public Object clone() {
            return new TheMagician();
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static class AxonTheSlayer implements Revenger {
        public String name = "Axon The Slayer";

        public Object clone() {
            return new AxonTheSlayer();
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static class ManicTheMayhem implements Revenger {
        public static String name = "Manic The Mayhem";

        public Object clone() {
            return new ManicTheMayhem();
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static class SuperheroFactory {
        public static final HashMap<String, Revenger> prototypes = new HashMap<>();

        static {
            prototypes.put("TheMagician", new TheMagician());
            prototypes.put("AxonTheSlayer", new AxonTheSlayer());
            prototypes.put("ManicTheMayhem", new ManicTheMayhem());
        }

        public SuperheroFactory() {}

        public Object createRevenger(String name) {
            if (prototypes.containsKey(name)) {
                return prototypes.get(name).clone();
            } else {
                return "This prototype with the following name: " + name + ", doesn't exist";
            }
        }
    }
    public static void main(String[] args) {
        SuperheroFactory factory = new SuperheroFactory();
        List<String> str = List.of("TheMagician", "AxonTheSlayer", "Manic");
        for (String name : str) {
            System.out.println(factory.createRevenger(name));
        }
    }
}
