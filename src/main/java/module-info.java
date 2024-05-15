module Proyecto.Adrian {

    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires static lombok;
    requires java.naming;

    opens org.example.javafx to javafx.fxml;
    exports org.example.javafx;
}