package com.harry.cloudparking.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParkingDTO {

    private @Setter @Getter String id;
    private @Setter @Getter String license;
    private @Setter @Getter String state;
    private @Setter @Getter String model;
    private @Setter @Getter String color;
    private @Setter @Getter LocalDateTime entryDate;
    private @Setter @Getter LocalDateTime exitDate;
    private @Setter @Getter Double bill;
}
