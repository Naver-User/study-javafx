package org.zerock.myapp.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;
import org.zerock.myapp.model.Phone;

import java.net.URL;
import java.util.ResourceBundle;


@Log4j2

@Accessors(fluent = true, chain = true)
@Data
public class RootController22 implements Initializable {
    @FXML private ListView<String> listView;
    @FXML private TableView<Phone> tableView;
    @FXML private ImageView imageView;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.trace("initialize({}, {}) invoked.", location, resources);

        // ------------
        ObservableList<String> phoneNames =
            FXCollections.observableArrayList(
                "갤럭시 S1",
                "갤럭시 S2",
                "갤럭시 S3",
                "갤럭시 S4",
                "갤럭시 S5",
                "갤럭시 S6",
                "갤럭시 S7"
            );  // .observableArrayList

        log.info("\t1. phoneNames: {}", phoneNames);

        this.listView.setItems(phoneNames); // .setItems
        log.info("\t2. selectionModel: {}", this.listView.getSelectionModel());     // MultipleSelectionModel<String>

        this.listView
            .getSelectionModel()
            .selectedIndexProperty()
//            .selectedItemProperty()
            .addListener((observable, oldValue, newValue) -> {
                log.trace("ChangeListener<String>::changed({}, {}, {}) invoked.", observable, oldValue, newValue);

                this.tableView.getSelectionModel().select(newValue.intValue());     // .select(int row)
                this.tableView.scrollTo(newValue.intValue());                       // .scrollTo(int index)
            }); // .addListener

        // ------------
        ObservableList<Phone> phoneModels =
            FXCollections.observableArrayList(
                new Phone("갤럭시 S1", "phone01.png"),
                new Phone("갤럭시 S2", "phone02.png"),
                new Phone("갤럭시 S3", "phone03.png"),
                new Phone("갤럭시 S4", "phone04.png"),
                new Phone("갤럭시 S5", "phone05.png"),
                new Phone("갤럭시 S6", "phone06.png"),
                new Phone("갤럭시 S7", "phone07.png")
            );  // .observableArrayList

        log.info("\t3. phoneModels: {}", phoneModels);

        this.tableView.setItems(phoneModels);
        log.info("\t4. selectionModel: {}", this.tableView.getSelectionModel());     // MultipleSelectionModel<Phone>

        // ------------
        TableColumn<Phone, ?> tcSmartPhone = this.tableView.getColumns().get(0);
        // Mapping TableView Column to the specified MODEL property name.           <--- ***
        tcSmartPhone.setCellValueFactory(new PropertyValueFactory("smartPhone"));
        tcSmartPhone.setStyle("-fx-alignment: CENTER;");

        TableColumn<Phone, ?> tcImage = this.tableView.getColumns().get(1);
        // Mapping TableView Column to the specified MODEL property name.           <--- ***
        tcImage.setCellValueFactory(new PropertyValueFactory("image"));
        tcImage.setStyle("-fx-alignment: CENTER_LEFT;");

        // ------------
        this.tableView
            .getSelectionModel()
//            .selectedIndexProperty()
            .selectedItemProperty()
            .addListener((observable, oldValue, newValue) -> {
                log.trace("ChangeListener<Phone>::changed({}, {}, {}) invoked.", observable, oldValue, newValue);

                if(newValue != null) {
                    this.imageView.setImage(
                        new Image(
                            this.getClass()
                                .getResource("/images/"+newValue.getImage())
                                .toString()
                        )
                    );  // .setImage
                } // if
            }); // .addListener
    } // initialize

    public void handleConfirmBtn(ActionEvent e) {
        log.trace("handleConfirmBtn({}) invoked.", e);

        String selectedPhoneName = this.listView.getSelectionModel().getSelectedItem();
        log.info("\t+1. selectedPhoneName: {}", selectedPhoneName);

        Phone selectedPhone = this.tableView.getSelectionModel().getSelectedItem();
        log.info("\t+2. selectedPhone: {}", selectedPhone);
    } // handleConfirmBtn

    public void handleCancelBtn(ActionEvent e) {
        log.trace("handleCancelBtn({}) invoked.", e);

        Platform.exit();
    } // handleCancelBtn

} // end class


