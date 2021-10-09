package seedu.teachbook.logic;

import java.nio.file.Path;

import javafx.collections.ObservableList;
import seedu.teachbook.commons.core.GuiSettings;
import seedu.teachbook.commons.core.index.GeneralIndex;
import seedu.teachbook.logic.commands.CommandResult;
import seedu.teachbook.logic.commands.exceptions.CommandException;
import seedu.teachbook.logic.parser.exceptions.ParseException;
import seedu.teachbook.model.ReadOnlyTeachBook;
import seedu.teachbook.model.classobject.Class;
import seedu.teachbook.model.student.Student;

/**
 * API of the Logic component
 */
public interface Logic {
    /**
     * Executes the command and returns the result.
     *
     * @param commandText The command as entered by the user.
     * @return the result of the command execution.
     * @throws CommandException If an error occurs during command execution.
     * @throws ParseException   If an error occurs during parsing.
     */
    CommandResult execute(String commandText) throws CommandException, ParseException;

    /**
     * Returns the AddressBook.
     *
     * @see seedu.teachbook.model.Model#getTeachBook()
     */
    ReadOnlyTeachBook getTeachBook();

    GeneralIndex getCurrentlySelectedClassIndex();

    /**
     * Returns an unmodifiable view of the filtered list of persons
     */
    ObservableList<Student> getFilteredPersonList();

    ObservableList<Class> getUniqueClassList();

    /**
     * Returns the user prefs' teachbook book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Set the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

}
