module org.zerock.myapp {
    requires java.base;

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    requires lombok;
    requires org.apache.logging.log4j;


    opens org.zerock.myapp
       to javafx.fxml,
          javafx.controls,
          javafx.graphics;

    opens org.zerock.myapp.controller
       to javafx.fxml,
          javafx.controls,
          javafx.graphics;

    opens org.zerock.myapp.model
       to javafx.base;
} // module


