module LibraryApk {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    exports main to javafx.graphics;
    opens main to javafx.fxml, javafx.base;
    opens controllers to javafx.fxml;
    opens model to javafx.base;
}