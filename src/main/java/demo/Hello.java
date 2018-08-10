package demo;

import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.stage.Stage;

public class Hello extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private static ForceObjectProperty<User> userProperty = new ForceObjectProperty<>(new User("JavaFX"));

    @Override
    public void start(Stage primaryStage) {
        userProperty.addListener(observable -> {
            System.out.println("---- invalidated -----");
            System.out.println(userProperty.getValue());
        });
        userProperty.fireValueChangedEvent();
    }
}

class ForceObjectProperty<T> extends SimpleObjectProperty<T> {

    public ForceObjectProperty(T initialValue) {
        super(initialValue);
    }

    @Override
    public void fireValueChangedEvent() {
        super.fireValueChangedEvent();
    }
}

class User {
    public String name;
    public User(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "User{name='" + name + "'}";
    }
}