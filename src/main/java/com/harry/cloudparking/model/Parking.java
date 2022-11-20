package com.harry.cloudparking.model;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Parking {

    private @Setter @Getter String id;
    private @Setter @Getter String license;
    private @Setter @Getter String state;
    private @Setter @Getter String model;
    private @Setter @Getter String color;
    private @Setter @Getter LocalDateTime entryDate;
    private @Setter @Getter LocalDateTime exitDate;
    private @Setter @Getter Double bill;

    public Parking(String id, String license, String state, String model, String color) {
        this.id = id;
        this.license = license;
        this.state = state;
        this.model = model;
        this.color = color;
    }

}
