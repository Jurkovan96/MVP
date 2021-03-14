package com.example.application.views.main;

import com.example.application.model.User;
import com.example.application.service.UserService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "" )
public class MainView extends VerticalLayout {

    Grid<User> userGrid = new Grid(User.class);

    HorizontalLayout horizontalLayout = new HorizontalLayout();

    UserService userService;

    public MainView(UserService userService) {
        this.userService = userService;
        addClassName("userGrid");
        setSizeFull();
        //setSizeFull();
        //Config the layout here, add or remove columns
        gridConfig();
        //Add grid to the layout
        add(new H1("Hello Vaadin"));
        add(horizontalLayout);
        horizontalLayoutConfig();
        add(userGrid);
        //Populate grid with elements
        populateGrid();

    }

    private void horizontalLayoutConfig() {
        horizontalLayout.add(new H3("Component on horizontal1"));
        horizontalLayout.add(new H3("Component on horizontal2"));
    }

    private void gridConfig() {
        userGrid.removeColumnByKey("id");
        userGrid.setColumns("summary", "userEmail", "userName");
        userGrid.addColumn(User::getId).setHeader("Id");
        userGrid.isColumnReorderingAllowed();
        userGrid.getColumns().forEach(userColumn -> userColumn.setAutoWidth(true));
    }


    private void populateGrid() {
        userGrid.setItems(userService.getAllUsers());
    }

}
