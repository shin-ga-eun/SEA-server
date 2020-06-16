package com.bugkillers.domain.artItem.entity;

import com.bugkillers.domain.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ArtItem {

    //대여관련 다뺐음
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long ano;

    @ManyToOne(targetEntity = Member.class, fetch = FetchType.EAGER)
    @JoinColumn(name="artist")
    private Member member;

    private String title;
    private String description;
    private int price;
    private LocalDate create_at;
    private LocalDate modify_at;

    public Long getAno() {
        return ano;
    }

    public void setAno(Long ano) {
        this.ano = ano;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreate_at() {
        return create_at;
    }

    public void setCreate_at(LocalDate create_at) {
        this.create_at = create_at;
    }

    public LocalDate getModify_at() {
        return modify_at;
    }

    public void setModify_at(LocalDate modify_at) {
        this.modify_at = modify_at;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
