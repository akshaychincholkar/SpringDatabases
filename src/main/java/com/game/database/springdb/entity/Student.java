package com.game.database.springdb.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
//@Table(name = "student")
public class Student {
    @Id
    private int id;
    private String name;
    private String city;
//    1-Many without FTC
/*    @OneToMany
    private List<Address> address;

    public Student(int id, String name, String city, List addresses) {
            this.id = id;
            this.name=name;
            this.city = city;
            this.address = addresses;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }*/

    //      1-1
//    @OneToOne(targetEntity=Address.class,cascade= CascadeType.ALL)
//    private Address address;

//    1-many with FTC
    @OneToMany(fetch=FetchType.LAZY, targetEntity=Address.class, cascade=CascadeType.ALL)
    @JoinColumn(name = "aid", referencedColumnName="id")
    private Set children;

    public Set getChildren() {
        return children;
    }

    public void setChildren(Set children) {
        this.children = children;
    }
//        many-1 with TC
/*    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="aid",referencedColumnName="address_id")
    private Address parent;

    public Address getParent() {
        return parent;
    }

    public void setParent(Address parent) {
        this.parent = parent;
    }*/
//  many-1 without TC
/*@ManyToOne
private Address address;

        public Student(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }*/
//    many-many
/*    @ManyToMany(targetEntity=Address.class,cascade = CascadeType.MERGE)
    @JoinTable(name="students_addresses",joinColumns=@JoinColumn(referencedColumnName="id"),inverseJoinColumns=@JoinColumn(referencedColumnName="address_id"))
    private Set address;

    public Set getAddress() {
        return address;
    }

    public void setAddress(Set address) {
        this.address = address;
    }*/

//      1-1
    /*public Student(int id, String name, String city, Address address) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.address = address;
    }*/
//    1-many with FTC
    public Student(int id, String name, String city, Set children) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.children = children;
    }
//        many-1 with TC
/*    public Student(int id, String name, String city, Address parent) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.parent = parent;
    }*/
//        many-many

/*    public Student(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }*/

    public Student() {


}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
//      1-1
/*    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }*/

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", children=" + children +
                '}';
    }
}
