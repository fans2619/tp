package seedu.teachbook.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.teachbook.commons.core.Messages;
import seedu.teachbook.commons.core.index.GeneralIndex;
import seedu.teachbook.logic.commands.exceptions.CommandException;
import seedu.teachbook.model.Model;
import seedu.teachbook.model.classobject.Class;
import seedu.teachbook.model.classobject.ClassName;
import seedu.teachbook.model.classobject.exceptions.ClassNameWithNameException;

/**
 * Deletes a class identified using its name.
 */
public class DeleteClassCommand extends Command {

    public static final String COMMAND_WORD = "deleteClass";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the class identified by its name.\n"
            + "Parameters: CLASSNAME (case-sensitive)\n"
            + "Example: " + COMMAND_WORD + " Class A";

    public static final String MESSAGE_DELETE_CLASS_SUCCESS = "Deleted Class: %1$s";

    private final ClassName className;

    public DeleteClassCommand(ClassName className) {
        this.className = className;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Class> classes = model.getUniqueClassList();
        GeneralIndex classIndex;

        try {
            classIndex = model.getIndexOfClass(className);
        } catch (ClassNameWithNameException exception) {
            throw new CommandException(Messages.MESSAGE_INVALID_CLASS_NAME);
        }

        Class classToDelete = classes.get(classIndex.getZeroBased());
        model.deleteClass(classToDelete);
        return new CommandResult(String.format(MESSAGE_DELETE_CLASS_SUCCESS, classToDelete));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeleteClassCommand // instanceof handles nulls
                && className.equals(((DeleteClassCommand) other).className)); // state check
    }
}
