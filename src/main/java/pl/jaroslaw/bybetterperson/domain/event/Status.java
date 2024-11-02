package pl.jaroslaw.bybetterperson.domain.event;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Status {
    INPROGRESS, COMPLETED, CLOSED
}
