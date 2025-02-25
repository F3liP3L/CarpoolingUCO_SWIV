package co.edu.uco.infrastructure.controller.response.dto;

import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.infrastructure.controller.response.enumeration.MessageLevel;
import lombok.ToString;

import static co.edu.uco.crosscutting.util.UtilObject.isNull;
import static co.edu.uco.crosscutting.util.UtilText.trim;

@ToString
public class Message {
    private String text;
    private String title;
    private MessageLevel level;

    private Message(String text, String title, MessageLevel level) {
        setText(text);
        setTitle(title);
        setLevel(level);
    }

    public static Message createMessage(String text, String title, MessageLevel level) {
        return new Message(text, title, level);
    }

    public static Message createMessage(String text, MessageLevel level) {
        return new Message(text, text, level);
    }

    public static Message createErrorMessage(String text, String title) {
        return new Message(text, title, MessageLevel.ERROR);
    }

    public static Message createWarningMessage(String text, String title) {
        return new Message(text, title, MessageLevel.WARNING);
    }

    public static Message createInfoMessage(String text, String title) {
        return new Message(text, title, MessageLevel.INFORMATION);
    }

    public static Message createSuccessMessage(String text, String title) {
        return new Message(text, title, MessageLevel.SUCCESS);
    }
    public static Message createFatalMessage(String text, String title) {
        return new Message(text, title, MessageLevel.FATAL);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        if(isNull(text) || UtilText.EMPTY.equals(trim(text))) {
            this.text = UtilText.EMPTY;
        } else {
            this.text = trim(text);
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (isNull(title) || UtilText.EMPTY.equals(trim(title))) {
            this.title = UtilText.EMPTY;
        } else {
            this.title = trim(title);
        }
    }

    public MessageLevel getLevel() {
        return level;
    }

    public void setLevel(MessageLevel level) {
        if(isNull(level)) {
            this.level = MessageLevel.FATAL;
        } else {
            this.level = level;
        }
    }
}
