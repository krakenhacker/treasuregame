package Models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Game {

    private Long id;

    private String name;

    private LocalDateTime start;

    private double duration;


    private double x;

    private double y;

    private double w;

    private double z;

    public Game() {
    }

    public Game(Long id, String name, LocalDateTime start,double duration, double x, double y, double z, double w) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.duration = duration;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Game(String name, LocalDateTime start,double duration, double x, double y, double z, double w) {
        this.name = name;
        this.start = start;
        this.duration = duration;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

}
