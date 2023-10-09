package com.ntnn.design.pattern.structural;

import java.util.ArrayList;
import java.util.List;

public class AdaptorDesign {

    static class Material {
        private String name;
        private Integer cost;
        private Integer quantity;

        public Material(String name, Integer cost, Integer quantity) {
            this.name = name;
            this.cost = cost;
            this.quantity = quantity;
        }

    }
    static class Plan {
        public String name;
        public List<Material> materials;

        public Plan() {
            this.materials = new ArrayList<>();
        }

        public Plan(String name, List<Material> materials) {
            this.name = name;
            this.materials = materials;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Material> getMaterials() {
            if (materials == null) {
                return new ArrayList<>();
            }
            return materials;
        }

        public void setMaterials(Material materials) {
            this.materials.add(materials);
        }
    }
    interface MakingArchitecturalPlan {
        Plan makePlan();
    }

    static class EstimateRawMaterials {
        static double estimate(Plan plan) {
            double cost = 0;
            for (Material material : plan.materials) {
                cost += material.cost * material.quantity;
            }
            return cost;
        }
    }

    static class Architect implements MakingArchitecturalPlan {

        private String name;

        public Architect(String name) {
            this.name = name;
        }

        @Override
        public Plan makePlan() {
            Plan plan = new Plan();
            plan.name = this.name;
            plan.materials = new ArrayList<>();
            plan.materials.add(new Material("Concrete", 100, 1));
            plan.materials.add(new Material("Steel", 50, 1));
            return plan;
        }
    }

    static class CostEstimationAdapter implements MakingArchitecturalPlan {

        private Architect architect;

        public CostEstimationAdapter(Architect architect) {
            this.architect = architect;
        }

        @Override
        public Plan makePlan() {
            Plan plan = architect.makePlan();
            return plan;
        }
    }


    public static void main(String[] args) {
        Architect architect = new Architect("John Doe");
        CostEstimationAdapter adapter = new CostEstimationAdapter(architect);
        Plan plan = adapter.makePlan();
        double cost = EstimateRawMaterials.estimate(plan);
        System.out.println(plan.name);
        System.out.println(cost);
    }
}
