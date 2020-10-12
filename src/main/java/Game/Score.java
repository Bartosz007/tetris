package Game;

public class Score {
    private int score;
    private int lines;
    private int level;

    public Score() {
        this.score = 0;
        this.lines = 0;
        this.level = 1;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
