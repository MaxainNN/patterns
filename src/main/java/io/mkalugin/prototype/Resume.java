package io.mkalugin.prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Resume implements Cloneable{
    private String name;
    private String position;
    private List<String> skills;

    public Resume(String name, String position, List<String> skills) throws InterruptedException {
        Thread.sleep(1000);
        this.name = name;
        this.position = position;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<String> getSkills() {
        // Save origin
//        return new ArrayList<>(skills);
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = new ArrayList<>(skills);
    }

    @Override
    public Resume clone() {
        try {
            Resume cloned = (Resume) super.clone();
            cloned.skills = new ArrayList<>(this.skills);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Resume{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", skills=" + skills +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(name, resume.name) &&
                Objects.equals(position, resume.position) &&
                Objects.equals(skills, resume.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position, skills);
    }
}
