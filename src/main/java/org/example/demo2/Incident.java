package org.example.demo2;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@Getter
@Setter
@AllArgsConstructor
public class Incident {
    private String reference;
    private Timestamp time;
    private Status status;
    private Membre membre;

}
