package hashwork.client.content.system.demographics.forms;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import hashwork.client.content.system.demographics.model.IdentificationTypeModel;

/**
 * Created by hashcode on 2015/08/18.
 */
public class IdentificationTypeForm extends FormLayout {

    private final IdentificationTypeModel bean;
    public final BeanItem<IdentificationTypeModel> item;
    public final FieldGroup binder;
    // Define Buttons
    public Button save = new Button("Save");
    public Button edit = new Button("Edit");
    public Button cancel = new Button("Cancel");
    public Button update = new Button("Update");
    public Button delete = new Button("Delete");


    public IdentificationTypeForm() {
        bean = new IdentificationTypeModel();
        item = new BeanItem<IdentificationTypeModel>(bean);
        binder = new FieldGroup(item);

        TextField idvalue = new TextField("Identification Number");
        idvalue.setNullRepresentation("");
        TextField description = new TextField("Identication Description");
        description.setNullRepresentation("");

        // Add the bean validator
        idvalue.addValidator(new BeanValidator(IdentificationTypeModel.class, "idvalue"));
        idvalue.setImmediate(true);
        description.addValidator(new BeanValidator(IdentificationTypeModel.class, "description"));
        description.setImmediate(true);

        // Create a field group and use it to bind the fields in the layout

        binder.bind(idvalue, "idvalue");
        binder.bind(description, "description");
        addComponent(description);
        addComponent(idvalue);
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.addComponent(save);
        buttons.addComponent(edit);
        buttons.addComponent(cancel);
        buttons.addComponent(update);
        buttons.addComponent(delete);

        // Determines which properties are shown, and in which order:
        edit.setVisible(false);
        update.setVisible(false);
        delete.setVisible(false);
        addComponent(buttons);
    }

}