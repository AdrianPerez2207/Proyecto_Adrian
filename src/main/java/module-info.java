module Proyecto.Adrian {

    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires static lombok;
    requires java.naming;

    opens org.example.javafx to javafx.fxml;
    opens org.example.models;
    opens org.example.repositories;
    exports org.example.javafx;
    exports org.example;
    opens org.example to javafx.fxml;
}