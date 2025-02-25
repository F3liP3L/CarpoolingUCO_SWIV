package co.edu.uco.infrastructure.controller.response;

import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.infrastructure.controller.response.dto.Message;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import static co.edu.uco.crosscutting.util.UtilObject.getDefaultIsNull;
import static co.edu.uco.crosscutting.util.UtilObject.isNull;

@ToString
public class Response<D> {
    private List<D> data;
    private List<Message> message;

    public void addMessage(final Message message ) {
        if(!isNull(message)) {
            getMessage().add(message);
        }
    }
    public void addData(final D data ) {
        if(!isNull(data)) {
            getData().add(data);
        }
    }

    public List<D> getData() {
        if(isNull(data)) {
            this.data = new ArrayList<>();
        }
        return data;
    }

    public void setData(List<D> data) {
        this.data = getDefaultIsNull(data, new ArrayList<>());
    }

    public List<Message> getMessage() {
        if(UtilObject.isNull(message)) {
            this.message = new ArrayList<>();
        }
        return message;
    }

    public void setMessage(List<Message> messages) {
        this.message = getDefaultIsNull(messages, new ArrayList<>());
    }
}
