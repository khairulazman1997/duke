package duke.parser;

import duke.command.*;
import duke.exceptions.DukeException;

public class Parser {

    public static Command parse(String fullCommand) throws DukeException {
        String[] words = fullCommand.split(" ");
        String command = words[0];
        switch(command){

            case "todo":
                if(words.length <= 1){
                    throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
                }
                return new AddToDoCommand(words);

            case "deadline":
                if(words.length <= 1){
                    throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
                }
                return new AddDeadlineCommand(words);

            case "event":
                if(words.length <= 1){
                    throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
                }
                return new AddEventCommand(words);

            case "done":
                if(words.length <= 1){
                    throw new DukeException("☹ OOPS!!! The index of the task to mark as complete " +
                            "must be specified");
                }
                return new DoneCommand(words);

            case "delete":
                if(words.length <= 1){
                    throw new DukeException("☹ OOPS!!! The index of the task to delete must be specified");
                }
                return new DeleteCommand(words);

            case "bye":
                return new ByeCommand();

            case "list":
                return new ListCommand();

            case "find":
                if(words.length <= 1){
                    throw new DukeException("☹ OOPS!!! The description of the task to find must be specified");
                }
                return new FindCommand(words);

            default:
                throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }
}
