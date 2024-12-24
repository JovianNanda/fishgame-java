package fish;

import java.util.Collections;
import java.util.List;

abstract public class Fish {

    public enum FishGrade {
        COMMON, UNCOMMON, RARE, EPIC, LEGENDARY
    }

    private String name;
    private Integer gold;
    private FishGrade grade;

    public Fish(String name, Integer gold, FishGrade grade) {
        this.name = name;
        this.gold = gold;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public Integer getGold() {
        return gold;
    }

    public String getGrade() {
        return this.grade.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public void setGrade(FishGrade grade) {
        this.grade = grade;
    }


}
