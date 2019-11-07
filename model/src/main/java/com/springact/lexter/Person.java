package com.spring.lexter;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.Embedded;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.BatchSize;
import javax.persistence.Cacheable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table(name="persontbl")
public class Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Embedded
    private Name name;

    @Embedded
    private Address address;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @Column(name = "gwa")
    private Double gwa;

    @Temporal(TemporalType.DATE)
    @Column(name = "datehired")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateHired;

    @Column(name = "status")
    private boolean isCurEmp;

    @Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    @BatchSize(size = 5)
    @JoinColumn(name="empid")
    @OrderColumn(name="index")
    private List<ContactInfo> contactInfo;

    @Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Fetch(FetchMode.JOIN)
    @BatchSize(size = 5)
    @JoinTable(name = "personroletbl",
        joinColumns = {@JoinColumn(name = "empid")},
        inverseJoinColumns = {@JoinColumn(name = "roleid")} )
    private Set<Role> roles;

    public Person() {
        contactInfo = new ArrayList<ContactInfo>();
        roles = new HashSet<Role>();
        name = new Name();
        address = new Address();
        gwa = 0.0;
        birthday = null;
        dateHired = null;
        isCurEmp = false;
    }

    public Person(Name name) {
        this();
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setName(Name name) {
        this.name = name;
    }
    public Name getName() {
        return name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public Address getAddress() {
        return address;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public Date getBirthday() {
        return birthday;
    }

    public void setGwa(Double gwa) {
        this.gwa = gwa;
    }
    public Double getGwa() {
        return gwa;
    }

    public void setDateHired(Date dateHired) {
        this.dateHired = dateHired;
    }
    public Date getDateHired() {
        return dateHired;
    }

    public void setIsCurEmp(boolean empStatus) {
        isCurEmp = empStatus;
    }
    public boolean getIsCurEmp() {
        return isCurEmp;
    }

    public void setContactInfo(List<ContactInfo> contactInfo) {
        this.contactInfo = contactInfo;
    }
    public List<ContactInfo> getContactInfo() {
        return contactInfo;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    public Set<Role> getRoles() {
        return roles;
    }

    public String toString() {
        String info = "[" + id + "]\n";
        info += "Name:" + name +" \n";
        info += "Address:" + address + "\n";
        info += "Birthday:" + birthday + "\tDate Hired:" + dateHired + "\n";
        info += "Employment Status:" + isCurEmp + "\tGWA:" + gwa;
        if(contactInfo.size() != 0) 
            info += "\nContact Info:" + contactInfo + "";
        if(roles.size() != 0)
            info += "\nRoles:" + roles;
        info += "\n";
        return info;

    }

}
