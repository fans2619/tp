package seedu.teachbook.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.teachbook.commons.core.GuiSettings;
import seedu.teachbook.commons.core.index.GeneralIndex;
import seedu.teachbook.model.classobject.Class;
import seedu.teachbook.model.classobject.ClassName;
import seedu.teachbook.model.classobject.exceptions.ClassNameWithNameException;
import seedu.teachbook.model.student.Student;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Student> PREDICATE_SHOW_ALL_PERSONS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' teachbook book file path.
     */
    Path getTeachBookFilePath();

    /**
     * Sets the user prefs' teachbook book file path.
     */
    void setTeachBookFilePath(Path addressBookFilePath);

    /**
     * Replaces teachbook book data with the data in {@code addressBook}.
     */
    void setTeachBook(ReadOnlyTeachBook addressBook);

    /** Returns the AddressBook */
    ReadOnlyTeachBook getTeachBook();

    GeneralIndex getCurrentlySelectedClassIndex();

    /**
     * Returns true if a student with the same identity as {@code student} exists in the teachbook book.
     */
    boolean hasStudent(Student student);

    /**
     * Returns true if a student with the same identity as {@code student} exists in the teachbook book.
     */
    boolean hasClass(Class classObj);

    /**
     * Deletes the given class.
     * The class must exist in the teachbook book.
     */
    void deleteClass(Class target);

    void addClass(Class toAdd);

    /**
     * Deletes the given student.
     * The student must exist in the teachbook book.
     */
    void deleteStudent(Student target);

    /**
     * Adds the given student.
     * {@code student} must not already exist in the teachbook book.
     */
    void addStudent(Student student);

    /**
     * Replaces the given student {@code target} with {@code editedPerson}.
     * {@code target} must exist in the teachbook book.
     * The student identity of {@code editedPerson} must not be the same as another
     * existing student in the teachbook book.
     */
    void setStudent(Student target, Student editedStudent);

    /** Returns an unmodifiable view of the filtered student list */
    ObservableList<Student> getFilteredStudentList();

    /** Returns an unmodifiable view of the unique class list */
    ObservableList<Class> getUniqueClassList();

    /**
     * Updates the filter of the filtered student list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredStudentList(Predicate<Student> predicate);

    GeneralIndex getIndexOfClass(ClassName className) throws ClassNameWithNameException;

    void updateCurrentlySelectedClass(GeneralIndex newClassIndex);

//    void updateFilteredClassList(Predicate<Class> predicate);


}
