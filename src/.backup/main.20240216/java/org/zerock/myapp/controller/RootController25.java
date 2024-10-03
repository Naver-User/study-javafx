package org.zerock.myapp.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;

import java.net.URL;
import java.util.ResourceBundle;


@Log4j2
@Accessors(fluent = true, chain = true)
@Data
public class RootController25 implements Initializable {
    @FXML private PieChart pieChart;
    @FXML private BarChart<String, Integer> barChart;
    @FXML private AreaChart<String, Integer> areaChart;


    @SuppressWarnings("unchecked")
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.trace("initialize({}, {}) invoked.", location, resources);

        // ----------------
        log.info("\t+ pieChart: {}", this.pieChart);
        log.info("\t+ barChart: {}", this.barChart);
        log.info("\t+ areaChart: {}", this.areaChart);

        // ----------------
        // 1. PieChart
        // ----------------
        this.pieChart().setData(FXCollections.observableArrayList(
            new PieChart.Data("AWT", 10),
            new PieChart.Data("Swing", 30),
            new PieChart.Data("SWT", 25),
            new PieChart.Data("JavaFX", 35)
        )); // .setData

        // ----------------
        // 2. BarChart
        // ----------------
        XYChart.Series<String, Integer> series1 = new XYChart.Series<>();

        series1.setName("남자");
        series1.setData(FXCollections.observableArrayList(
            // With type inference
            new XYChart.Data<>("2015", 70),
            new XYChart.Data<>("2016", 40),
            new XYChart.Data<>("2017", 50),
            new XYChart.Data<>("2018", 30)
        )); // .setData

        //-------------
        XYChart.Series<String, Integer> series2 = new XYChart.Series<>();

        series2.setName("여자");
        series2.setData(FXCollections.observableArrayList(
            // With type inference
            new XYChart.Data<>("2015", 30),
            new XYChart.Data<>("2016", 60),
            new XYChart.Data<>("2017", 50),
            new XYChart.Data<>("2018", 60)
        )); // .setData

        //-------------
        this.barChart().setData(FXCollections.observableArrayList(series1, series2)); // 1st. method
//        this.barChart().getData().addAll(series1, series2);                           // 2nd. method

        // ----------------
        // 3. AreaChart
        // ----------------
        XYChart.Series<String, Integer> series3 = new XYChart.Series<>();

        series3.setName("Avg. Temp1");
        series3.setData(FXCollections.observableArrayList(
            // With type inference
            new XYChart.Data<>("2015", 13),
            new XYChart.Data<>("2016", 6),
            new XYChart.Data<>("2017", 22),
            new XYChart.Data<>("2018", 19)
        )); // .setData

        XYChart.Series<String, Integer> series4 = new XYChart.Series<>();

        series4.setName("Avg. Temp2");
        series4.setData(FXCollections.observableArrayList(
            new XYChart.Data<>("2015", 20),
            new XYChart.Data<>("2016", 18),
            new XYChart.Data<>("2017", 19),
            new XYChart.Data<>("2018", 21),
            new XYChart.Data<>("2019", 20)
        )); // .setData

        //-------------
//        this.areaChart().getData().addAll(series3, series4);                                // 1st. method
        this.areaChart().setData(FXCollections.observableArrayList(series3, series4));      // 2nd. method
    } // initialize

} // end class


