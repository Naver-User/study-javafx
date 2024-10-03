package org.zerock.myapp.model;

import javafx.beans.property.SimpleStringProperty;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;


@Log4j2
@ToString
public class Phone {    // JavaFX TableView Model
    private SimpleStringProperty smartPhone;    // Property of TableView Column
    private SimpleStringProperty image;         // Property of TableView column


    public Phone() {
        log.trace("Default constructor invoked.");

        this.smartPhone = new SimpleStringProperty();
        this.image = new SimpleStringProperty();
    } // Default Constructor

    public Phone(String smartPhone, String image) {
        log.trace("Phone({}, {}) invoked.", smartPhone, image);

        this.smartPhone = new SimpleStringProperty(smartPhone);
        this.image = new SimpleStringProperty(image);
    } // Constructor


    public String getSmartPhone() {
        log.trace("getSmartPhone() invoked.");
        return this.smartPhone.get();
    } // getSmartPhone

    public String getImage() {
        log.trace("getImage() invoked.");
        return this.image.get();
    } // getImage

    public void setSmartPhone(String smartPhone) {
        log.trace("setSmartPhone({}) invoked.", smartPhone);
        this.smartPhone.set(smartPhone);
    } // setSmartPhone

    public void setImage(String image) {
        log.trace("setImage({}) invoked.", image);
        this.image.set(image);
    } // setImage

} // end class


