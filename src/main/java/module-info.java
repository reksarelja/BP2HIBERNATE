module me.baze2 {
	requires javafx.controls;
	requires javafx.fxml;
	requires org.hibernate.orm.core;
	requires jakarta.persistence;
	requires com.oracle.database.jdbc;

	opens me.baze2.gui to javafx.fxml, org.hibernate.orm.core, jakarta.persistence;
	exports me.baze2.gui;

	opens me.baze2.entities to javafx.fxml, org.hibernate.orm.core, jakarta.persistence;
	exports me.baze2.entities;

	opens me.baze2.utils to javafx.fxml, org.hibernate.orm.core, jakarta.persistence;
	exports me.baze2.utils;

}