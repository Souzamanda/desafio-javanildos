package com.javanildos.desafio.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_account_type")
@Getter
@Setter
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Long typeId;

    private String name;

    public enum Values {
        CORRENTE(1L),
        POUPANCA(2L),
        UNIVERSITARIA(3L),
        SALARIO(4L),
        JURIDICA(5L);

        final long typeId;

        public long getTypeId() {
            return typeId;
        }

        Values(long typeId) {this.typeId = typeId;}
    }
}
