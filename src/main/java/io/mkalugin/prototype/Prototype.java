package io.mkalugin.prototype;

import java.util.ArrayList;
import java.util.List;

public class Prototype {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Create main resume.");
        List<String> seniorSkills = new ArrayList<>(List.of("Java Core", "Spring", "Databases"));
        Resume seniorResume = new Resume("Maxim Kalugin","Senior Java Developer", seniorSkills);

        System.out.println("Main resume: " + seniorResume);

        System.out.println("Create clone resume.");
        Resume juniorResume = seniorResume.clone();
        juniorResume.setName("Steve Jobs");
        juniorResume.setPosition("Junior Java Developer");
        juniorResume.getSkills().remove("Spring");
        juniorResume.getSkills().remove("Databases");

        Resume middleResume = seniorResume.clone();
        middleResume.setName("Elon Mask");
        middleResume.setPosition("Middle Java Developer");
        middleResume.getSkills().remove("Spring");

        Resume seniorCloudResume = seniorResume.clone();
        seniorCloudResume.setName("John Doe");

        System.out.println("Junior :" + juniorResume);
        System.out.println("Middle :" + middleResume);
        System.out.println("Senior :" + seniorCloudResume);

        System.out.println("Check.");
        System.out.println(" = " + (seniorResume == juniorResume));
        System.out.println(" equals " + seniorResume.equals(juniorResume));
        System.out.println("Skills references to same object : "
                + (seniorResume.getSkills() == juniorResume.getSkills()));
        System.out.println("Skills contains same data : "
                + (seniorResume.getSkills().equals(juniorResume.getSkills())));

    }
}
