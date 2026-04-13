package com.joaodddev.itau.model;

import lombok.Data;
import java.time.OffsetDateTime;

@Data
public class Transacao {
    private double valor;
    private OffsetDateTime dataHora;
}
