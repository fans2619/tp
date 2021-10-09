package seedu.teachbook.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import seedu.teachbook.commons.core.LogsCenter;
import seedu.teachbook.commons.core.index.GeneralIndex;
import seedu.teachbook.model.ModelManager;
import seedu.teachbook.model.classobject.Class;


/**
 * Panel containing the list of persons.
 */
public class ClassListPanel extends UiPart<Region> {
    private static final String FXML = "ClassListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(ClassListPanel.class);

    @FXML
    private ListView<Class> classListView;

    /**
     * Creates a {@code PersonListPanel} with the given {@code ObservableList}.
     */
    public ClassListPanel(ObservableList<Class> classList) {
        super(FXML);
        classListView.setItems(classList);
        classListView.setCellFactory(listView -> new ClassListViewCell());
        classListView.addEventFilter(MouseEvent.MOUSE_PRESSED, Event::consume);
    }

    public void reload(GeneralIndex newSelectedClassIndex) {
        int N = newSelectedClassIndex.getZeroBased();
        classListView.getSelectionModel().select(N);
        classListView.getFocusModel().focus(N);
        classListView.scrollTo(N);
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Person} using a {@code PersonCard}.
     */
    class ClassListViewCell extends ListCell<Class> {
        @Override
        protected void updateItem(Class classObj, boolean empty) {
            super.updateItem(classObj, empty);

            if (empty || classObj == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new ClassCard(classObj, getIndex() + 1).getRoot());
            }
        }
    }

}
