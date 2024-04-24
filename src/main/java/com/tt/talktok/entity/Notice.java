package com.tt.talktok.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no_no")
    private int noNo;
    private String no_subject;
    private String no_content;
    private int no_readcount;
    @CreationTimestamp
    private Timestamp no_date;

}
