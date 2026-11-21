package utez.project.cinematoon.model;

import java.time.LocalDateTime;
import java.util.List;

public class Reservation {
    private int id;
    private int showTimeId;
    private List<Seat> seats;
    private LocalDateTime createdAt;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShowTimeId() {
        return showTimeId;
    }

    public void setShowTimeId(int showTimeId) {
        this.showTimeId = showTimeId;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
