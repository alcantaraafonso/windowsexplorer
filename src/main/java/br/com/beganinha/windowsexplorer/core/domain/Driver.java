package br.com.beganinha.windowsexplorer.core.domain;

public class Driver {

    private String letter;
    private long totalCapicty;
    private long freeCapicty;

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public long getTotalCapicty() {
        return totalCapicty;
    }

    public void setTotalCapicty(long totalCapicty) {
        this.totalCapicty = totalCapicty;
    }

    public long getFreeCapicty() {
        return freeCapicty;
    }

    public void setFreeCapicty(long freeCapicty) {
        this.freeCapicty = freeCapicty;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "letter='" + letter + '\'' +
                ", totalCapicty=" + totalCapicty +
                ", freeCapicty=" + freeCapicty +
                '}';
    }
}
