package com.ntnn.design.pattern.creation;

public class SingletonDesign {
    static class TheRevenger {

        private static TheRevenger instance;

        private TheRevenger() {
        }

        public static TheRevenger getInstance() {
            if (instance == null) {
                instance = new TheRevenger();
            }
            return instance;
        }

        public void sayHello() {
            System.out.println("Hello, I am The Revenger!");
        }
    }


    public static void main(String[] args) {
        TheRevenger firstInstance = TheRevenger.getInstance();
        TheRevenger secondInstance = TheRevenger.getInstance();
        assert firstInstance == secondInstance;

        firstInstance.sayHello();
        secondInstance.sayHello();
    }
}
