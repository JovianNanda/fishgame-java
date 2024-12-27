package fishingrod;

abstract public class FishingRod {

    public enum FishingRodGrade {
        BASIC, GOLD, PLATINUM, DIAMOND
    }

    private String name;
    private int price;
    private FishingRodGrade grade;

    public FishingRod(String name, int price, FishingRodGrade grade) {
        this.name = name;
        this.price = price;
        this.grade = grade;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setGrade(FishingRodGrade grade) {
        this.grade = grade;
    }

    // Getter
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getGrade() {
        return grade.toString();
    }

}
