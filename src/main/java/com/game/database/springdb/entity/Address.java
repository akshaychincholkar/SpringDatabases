package com.game.database.springdb.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.annotation.TypeAlias;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
//@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int addressId;

    @Column(name = "street",length = 50)
    private String street;

    @Column(name = "CITY",length = 100)
    private String city;

    @Column(name = "is_open")
    private boolean isOpen;

    @Transient
    private double x;

    @Column(name = "added_date")
    @Temporal(TemporalType.DATE)
    private Date addedDate;

    @Lob
    private byte[] image;
//      many - 1 without ftc
/*    @OneToMany
    private List<Student> children;

    public List<Student> getChildren() {
        return children;
    }

    public void setChildren(List<Student> children) {
        this.children = children;
    }*/
    //  1-Many without FTC
/*    @ManyToOne
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }*/
    //    many-many
//    @ManyToMany(targetEntity=Student.class,mappedBy="address")
//    private Set address;

/*    public Set getAddress() {
        return address;
    }

    public void setAddress(Set address) {
        this.address = address;
    }*/

    public Address() {
    }

    public Address(int addressId, String street, String city, boolean isOpen, double x, Date addedDate, byte[] image) {
        this.addressId = addressId;
        this.street = street;
        this.city = city;
        this.isOpen = isOpen;
        this.x = x;
        this.addedDate = addedDate;
        this.image = image;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", isOpen=" + isOpen +
                ", x=" + x +
                ", addedDate=" + addedDate +
//                ", image=" + Arrays.toString(image) +
                '}';
    }
}
