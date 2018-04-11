package ba.unsa.etf.nwtcinemareservations.feign_clients.dto;

public class TicketReservationDTO {
    private Long projectionId;
    private int tickets;

    public TicketReservationDTO() {
    }

    public TicketReservationDTO(Long projectionId, int tickets) {
        this.projectionId = projectionId;
        this.tickets = tickets;
    }

    public Long getProjectionId() {
        return projectionId;
    }

    public void setProjectionId(Long projectionId) {
        this.projectionId = projectionId;
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }
}