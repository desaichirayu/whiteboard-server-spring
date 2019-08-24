package com.example.cs5610su19javaservercdesai.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "widgets")
public class Widget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="\"name\"")
    private String name;
    @Column(name="\"type\"")
    @Enumerated(EnumType.STRING)
    private WidgetType type;
    @Column(name="\"text\"")
    private String text;
    private Integer size;
    private String src;
    private String href;
    private String items;
    private String listType;
    private String paraText;
    private String linkText;
    @Column(name="\"order\"")
    private Integer order;

    @ManyToOne
    @JsonIgnore
    private Topic topic;


    public void set(Widget newWidget){
        this.name = newWidget.getName();
        this.type = newWidget.getType();
        this.text = newWidget.getText();
        this.size = newWidget.getSize();
        this.src = newWidget.getSrc();
        this.href = newWidget.getHref();
        this.items = newWidget.getItems();
        this.listType = newWidget.getListType();
        this.paraText = newWidget.getParaText();
        this.linkText = newWidget.getLinkText();
        this.order = newWidget.getOrder();
    }

    @Transient
    public Integer getTopicId() {
        return topic.getId();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WidgetType getType() {
        return type;
    }

    public void setType(WidgetType type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getListType() {
        return listType;
    }

    public void setListType(String listType) {
        this.listType = listType;
    }

    public String getParaText() {
        return paraText;
    }

    public void setParaText(String paraText) {
        this.paraText = paraText;
    }

    public String getLinkText() {
        return linkText;
    }

    public void setLinkText(String linkText) {
        this.linkText = linkText;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Widget{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", topicId=" + topic.getId() +
                ", type='" + type + '\'' +
                ", text='" + text + '\'' +
                ", size='" + size + '\'' +
                ", src='" + src + '\'' +
                ", href='" + href + '\'' +
                ", items='" + items + '\'' +
                ", listType='" + listType + '\'' +
                ", paraText='" + paraText + '\'' +
                ", linkText='" + linkText + '\'' +
                ", order=" + order +
                '}';
    }
}
