package com.ntnn.final_example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Upgrad {
    static class Person {
        private String eyeColor;
        protected String name;

        public Person(String name) {
            this.name = name;
        }
    }

    static class Adult extends Person {
        protected int age;

        public Adult(String name, int age) {
            super(name);
            this.age = age;
        }
    }

    static class Policeman extends Adult {
        protected final String job;

        public Policeman(String name, int age) {
            super(name, age);
            this.job = "policeman";
        }
    }
}
