package fish;

abstract public class Fish {

    public enum FishGrade {
        COMMON, UNCOMMON, RARE, EPIC, LEGENDARY
    }

    private String name;
    private Integer gold;
    private FishGrade grade;
    private Integer chance;
    
    public Fish(String name, Integer gold, FishGrade grade, Integer chance) {
        this.name = name;
        this.gold = gold;
        this.grade = grade;
        this.chance = chance;
    }

    public String getName() {
        return name;
    }

    public Integer getGold() {
        return gold;
    }

    public String getGrade() {
        return grade.toString();
    }

    public Integer getChance() {
        return chance;
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

    public void setChance (Integer chance){
        this.chance = chance;
    }


}
