package session11.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import session11.model.da.ProductDa;
import session11.model.entity.Brand;
import session11.model.entity.Product;
import session11.model.utils.Validation;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ProductController implements Initializable {
    private final Validation validation = new Validation();

    @FXML
    private TextField idTxt, productNameTxt, priceTxt, countTxt;

    @FXML
    private ComboBox<String> brandComBox;


    @FXML
    private Button saveBut, editBut, deleteBut;

    @FXML
    private TableView<Product> productTbl;

    @FXML
    private TableColumn<Product, Integer> columProductId, columProductPrice, columProductCount;

    @FXML
    private TableColumn<Product, String> columProductName, columProductBrand;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (Brand brand : Brand.values()) {
            brandComBox.getItems().add(brand.name());
        }

        resetForm();


        saveBut.setOnAction(event -> {
            try (ProductDa productda = new ProductDa()) {
                Product product =
                        Product
                                .builder()
                                .name(validation.nameValidator(productNameTxt.getText()))
                                .brand(Brand.valueOf(brandComBox.getSelectionModel().getSelectedItem()))
                                .count(validation.countValidator(Integer.parseInt(countTxt.getText())))
                                .price(validation.priceValidator(Integer.parseInt(priceTxt.getText())))
                                .build();
                productda.save(product);

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Product Saved\n" + product.toString());
                alert.show();
                resetForm();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Product Save Error\n" + e.getMessage());
                alert.show();
            }
        });

        editBut.setOnAction(event -> {
            try (ProductDa productDa = new ProductDa()) {
                // Data Validation
                Product product =
                        Product
                                .builder()
                                .id(Integer.parseInt(idTxt.getText()))
                                .name(validation.nameValidator(productNameTxt.getText()))
                                .brand(Brand.valueOf(brandComBox.getSelectionModel().getSelectedItem()))
                                .count(validation.countValidator(Integer.parseInt(countTxt.getText())))
                                .price(validation.priceValidator(Integer.parseInt(priceTxt.getText())))
                                .build();
                productDa.edit(product);

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Product Edited\n" + product.toString());
                alert.show();
                resetForm();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Product Edit Error\n" + e.getMessage());
                alert.show();
            }
        });

        deleteBut.setOnAction(event -> {
            try (ProductDa productDa = new ProductDa()) {
                Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure To Remove Product ?");
                if (confirmAlert.showAndWait().get() == ButtonType.OK) {
                    int id = Integer.parseInt(idTxt.getText());
                    productDa.remove(id);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Product Removed With ID : " + id);
                    alert.show();
                    resetForm();
                }

            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Product Remove Error\n" + e.getMessage());
                alert.show();
            }
        });

        productTbl.setOnMouseReleased(event->{
            Product product = productTbl.getSelectionModel().getSelectedItem();
            idTxt.setText(String.valueOf(product.getId()));
            productNameTxt.setText(product.getName());
            brandComBox.getSelectionModel().select(product.getBrand().name());
            countTxt.setText(String.valueOf(product.getCount()));
            priceTxt.setText(String.valueOf(product.getPrice()));
        });
    }

    private void resetForm() {
        idTxt.clear();
        productNameTxt.clear();
        brandComBox.getSelectionModel().select(0);
        countTxt.clear();
        priceTxt.clear();
        try (ProductDa productDa = new ProductDa()) {
            refreshTable(productDa.findAll());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Find Products Error\n" + e.getMessage());
            alert.show();
        }
    }

    private void refreshTable(List<Product> productList) {
        ObservableList<Product> products = FXCollections.observableList(productList);

        columProductId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columProductName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columProductBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        columProductPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        columProductCount.setCellValueFactory(new PropertyValueFactory<>("Count"));

        productTbl.setItems(products);
    }
}