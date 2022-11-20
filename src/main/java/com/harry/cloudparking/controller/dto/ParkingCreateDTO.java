package com.harry.cloudparking.controller.dto;

import lombok.Getter;
import lombok.Setter;

public class ParkingCreateDTO {

    private @Getter @Setter String license;
    private @Getter @Setter String state;
    private @Getter @Setter String model;
    private @Getter @Setter String color;

}
