package io.mkalugin.builder;

public class Main {
    public static void main(String[] args) {
        GamingPC budgetPC = DefinedGamingPc.builder()
                .cpu("Intel Core i5")
                .gpu("NVIDIA RTX 4060")
                .ram(16)
                .ssd(512)
                .liquidCooling(false)
                .rgbLighting(false)
                .build();

        GamingPC topPC = DefinedGamingPc.builder()
                .cpu("Intel Core i9")
                .gpu("NVIDIA RTX 5090")
                .ram(64)
                .ssd(2000)
                .liquidCooling(true)
                .rgbLighting(true)
                .build();

        System.out.println("Budget config:");
        System.out.println(budgetPC.getDescription());

        System.out.println("\nTop config:");
        System.out.println(topPC.getDescription());
    }
}
