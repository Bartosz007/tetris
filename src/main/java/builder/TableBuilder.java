package builder;

public class TableBuilder {
    private int score;
    private String name;

    public TableBuilder( int score, String name) {
        this.score = score;
        this.name = name;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TableBuilder{" +
                "score=" + score +
                ", name='" + name + '\'' +
                '}';
    }
}
