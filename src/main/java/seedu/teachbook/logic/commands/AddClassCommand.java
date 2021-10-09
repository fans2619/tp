package seedu.teachbook.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.teachbook.logic.parser.CliSyntax.PREFIX_NAME;

import seedu.teachbook.logic.commands.exceptions.CommandException;
import seedu.teachbook.model.Model;
import seedu.teachbook.model.classobject.Class;


/**
 * Adds a student to the teachbook book.
 */
public class AddClassCommand extends Command {

    public static final String COMMAND_WORD = "addClass";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a class to the teach book. "
            + "Parameters: "
            + PREFIX_NAME + "NAME "
            + "\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_NAME + "classobject A ";

    public static final String MESSAGE_SUCCESS = "New class added: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON = "This class already exists in the teach book";

    private final Class toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Person}
     */
    public AddClassCommand(Class classObj) {
        requireNonNull(classObj);
        toAdd = classObj;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasClass(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_PERSON);
        }

        model.addClass(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd), false, false, true);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddClassCommand // instanceof handles nulls
                && toAdd.equals(((AddClassCommand) other).toAdd));
    }

}
